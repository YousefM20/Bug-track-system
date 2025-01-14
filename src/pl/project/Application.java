
public class Application {
	
	public static void main(String[] args) {
		
		
		Bug bug1 = new Bug(BUGSTATUS.OPEN,SEVERITY.HIGH,"1","StackoverFlow error","first error","project1","developer1","tester1");
		
		
		Tester tester = new Tester("Ram");
		Developer developer = new Developer("Shyam");
		Manager manager  = new Manager();
		
		//developer.addBug(bug1);
//		developer.editBugStatus(bug1, BUGSTATUS.VERIFIED, SEVERITY.MEDIUM);
//		developer.showBug(bug1);
////		tester.action(bug, BUGSTATUS.NEED_MORE_INFO);
//		developer.closeBug(bug1);

	}

}
