
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Project {
	ArrayList<Bug> bugs = new ArrayList<Bug>();
	
	private String managerId;
	private String developerId;
	private String testerId;
	
	public List<Bug> getBugs() {
		return bugs;
	}
	public void setBugs(List<Bug> bugs) {
		this.bugs = (ArrayList<Bug>) bugs;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}
	public String getTesterId() {
		return testerId;
	}
	public void setTesterId(String testerId) {
		this.testerId = testerId;
	}
	
	
	
	
	
	

}