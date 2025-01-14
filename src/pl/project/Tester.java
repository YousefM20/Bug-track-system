import java.io.*;
import java.util.*;

public class Tester extends Employee{

	private ArrayList<Bug> bugs;
	private static int ids= 1;

	public Tester(String name, String email){
		setName(name);
		setId(ids+"");
		setEmail(email);
		ids+=1;
	}

	public Tester(String name, String email, String Id){
		setName(name);
		setId(Id);
		setEmail(email);
	}



	public void defineBug() throws IOException{
		// Create a Scanner object for user input
		Scanner scanner = new Scanner(System.in);
	
		// Prompt the tester to enter details
		System.out.println("Enter Bug Name:");
		String name = scanner.nextLine();
	
		System.out.println("Enter Bug Type:");
		String type = scanner.nextLine();
	
		System.out.println("Enter Project ID:");
		String projectID = scanner.nextLine();
	
		System.out.println("Enter Developer ID:");
		String developerID = scanner.nextLine();
	
		System.out.println("Enter Tester ID:");
		String testerID = scanner.nextLine();

		System.out.println("Enter IMG URL:");
		String img = scanner.nextLine();

		System.out.println("Enter Bug Date (e.g., 2024-12-15):");
		String date = scanner.nextLine();
	
		System.out.println("Is the bug resolved? (true/false):");
		Boolean status = scanner.nextBoolean();
	
		// Create a new Bug object with the provided details
		Bug b = new Bug(status, type, name, projectID, developerID, testerID, img, date);

		System.out.println("Bug defined successfully: " + b.getName());
		bugs.add(b);
		addBug(b);
	}
	
	private void loadBugs() throws IOException {
		File bugsFile = new File("bugs.txt");
		if (!bugsFile.exists()) return;
	
		Scanner fileScanner = new Scanner(bugsFile);
		while (fileScanner.hasNextLine()) {
			String[] bugData = fileScanner.nextLine().split(" ");
			if (bugData[5].equals(this.getId())) { 
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
				bugs.add(bug);
				
			}
		}
		fileScanner.close();
	}
	
	private void addBug(Bug b1) throws IOException {
		File bugs = new File("bugs.txt");
		FileWriter writer = new FileWriter(bugs, true);
	
		// Write bug details in a structured format
		writer.write(b1.getId() + " " + b1.getName() + " " + b1.getDate() + " " + b1.getProjectID() + " " + b1.getDeveloperID() + " "
				+ b1.getTesterID() + " " + b1.getImg() + " " + b1.getStatus() + " " + b1.getType() + "\n");
	
		// Close the FileWriter
		writer.close();
		System.out.println("Bug added successfully.");
	}
	

	public void showReport() {
		if (this.bugs.isEmpty()) {
			System.out.println("No bugs to show.");
			return;
		}
	
		System.out.println("Bug Report:\n");
		for (Bug bug : this.bugs) {
			System.out.println(bug.toString());
		}
	}
	
	public String ProjectReport(String id){
		int x =0;
		for(Bug bug : this.bugs){
			if (bug.getProjectID().equals(id))x++;
		}
		return this.getName()+"\nNumber of bugs created: " + x;
	}

	
	@Override
	public String toString() {
		return getName();
	}
	

}