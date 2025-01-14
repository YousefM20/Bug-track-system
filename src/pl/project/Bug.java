public class Bug {

	private static int bugIds = 1;
	private String Id;
	private String date;
	private String name;
	private String projectID;
	private String developerID;
	private String testerID;
	private Boolean status;
	private String type;
	private String img;
 

	// Getters and Setters

	public void setBugstatus(Boolean bugstatus) {
		this.status = bugstatus;
	}

	public Boolean getStatus() {
		return this.status;
	}



	public String getDeveloperID() {
		return developerID;
	}

	public void setDeveloperID(String developerID) {
		this.developerID = developerID;
	}

	public String getTesterID() {
		return testerID;
	}

	public void setTesterID(String testerID) {
		this.testerID = testerID;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "ID: " + this.getId() + "Developer: " + this.getDeveloperID() + "Status: " + this.getStatus() + "\n";
	}

	public Bug(Boolean status, String type, String name, String projectID,
			String developerID, String testerID, String img, String date) {
		super();
		this.date = date;
		this.status = status;
		this.type = type;
		this.Id = bugIds+"";
		bugIds++;
		this.name = name;
		this.projectID = projectID;
		this.developerID = developerID;
		this.testerID = testerID;
		this.img = img;
	}

}