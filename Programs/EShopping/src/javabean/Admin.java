package javabean;

public class Admin {
	private int id;
	private int adminType;
	private String adminName;
	private String adminuserName;
	private String adminpassWord;
	public Admin(int id, int adminType, String adminName, String adminuserName, String adminpassWord) {
		super();
		this.id = id;
		this.adminType = adminType;
		this.adminName = adminName;
		this.adminuserName = adminuserName;
		this.adminpassWord = adminpassWord;
	}
	public Admin() {
		super();
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminpassWord() {
		return adminpassWord;
	}
	public void setAdminpassWord(String adminpassWord) {
		this.adminpassWord = adminpassWord;
	}
	public int getAdminType() {
		return adminType;
	}
	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}
	public String getAdminuserName() {
		return adminuserName;
	}
	public void setAdminuserName(String adminuserName) {
		this.adminuserName = adminuserName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
