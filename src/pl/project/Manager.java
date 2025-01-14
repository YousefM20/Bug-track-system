
public class Manager extends Employee {
	BUGSTATUS bugstatus;
	
	public void approvalStatus() {
		
		if(bugstatus == BUGSTATUS.CLOSED) {
			System.out.println("Bug is approved");
		}
	}
	
	

}