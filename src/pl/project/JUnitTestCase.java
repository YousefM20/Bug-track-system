import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class JUnitTestCase {
	Tester tester;
	Developer developer;
	Bug bug1;
	
	@BeforeEach
	void init() {
		 tester = new Tester("Ram");
		developer = new Developer("Shyam");
		bug1 = new Bug(BUGSTATUS.OPEN,SEVERITY.HIGH,"1","StackoverFlow error","first error","project1","developer1","tester1");
	}
	
	@Test
	void testAssignBug() {
		 developer.assign(bug1, tester);
		 String name = tester.toString();
		 Assert.assertEquals(tester.getName(), name);
	}
	
	

}