import java.io.File;
import java.util.*; 

import java.io.File;
import java.io.FileNotFoundException;
import java.net.PasswordAuthentication;
import javax.mail.*;
import javax.mail.internet.*;


public class Developer extends Employee {
    private List<Bug> assignedBugs;
    private static int dIds= 1;


	public Developer(String name, String email){
		setName(name);
		setId(dIds+"");
		setEmail(email);
		dIds+=1;
	}

    public Developer(String name, String email, String Id){
		setName(name);
		setId(Id);
		setEmail(email);
	}

    public void loadBugsFromFile() {
            Scanner scanner = new Scanner("bugs.txt");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] bugData = line.split(" ");
                if (bugData[4].equals(this.getId())) { 
                    Bug bug = new Bug(
                        Boolean.parseBoolean(bugData[7]), // Status
                        bugData[8],                       // Type
                        bugData[1],                       // Name
                        bugData[3],                       // Project ID
                        bugData[4],                       // Developer ID
                        bugData[5],                       // Tester ID
                        bugData[6],                       // Image URL
                        bugData[2],                       // Date
                        bugData[0]                        // ID
                    );
                    assignedBugs.add(bug); 
            }
            System.out.println("Bugs loaded successfully.");
            
        }
    }


    public void viewAssignedBugs() {
        System.out.println("Assigned Bugs:");
        for (Bug bug : assignedBugs) {
            System.out.println(bug.toString());
        }
    }


    public void changeBugStatus(String bugId, Boolean newStatus) {
        for (Bug bug : assignedBugs) {
            if (bug.getId().equals(bugId)) {
                bug.setBugstatus(newStatus);
                System.out.println("Bug status updated to: " + newStatus);
                return;
            }
        }
        System.out.println("Bug not found.");
    }

    public String ProjectReport(String id){
		int x =0;
		for(Bug bug : this.assignedBugs){
			if (bug.getProjectID().equals(id))x++;
		}
		return this.getName()+"\nNumber of bugs assigned: " + x;
	}



    public void sendEmailToTester(Bug bug) {
        String to = bug.getTesterID(); 
        String subject = "Bug Status Changed";
        String messageBody = "The status of Bug ID: " + bug.getId() +
                " has been changed to: " + bug.getStatus() ;

        String from = "1020081@stemegypt.edu.eg";
        String password = "123456";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageBody);

            Transport.send(message);
            System.out.println("Email sent to: " + to);
        } catch (MessagingException e) {
            System.out.println("Email could not be sent: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Developer: " + this.getName();
    }

    // public static void main(String[] args) {
    //     Developer dev = new Developer("Nabil"); /
    //     dev.loadBugsFromFile("bugs.txt");
    //     dev.viewAssignedBugs();
    //     dev.changeBugStatus("1", true); 
    // }
}
