package javabean;

public class LeaveWord {

	private int id;
	private int memberid;
	private int adminid;
	private String title;
	private String content;
	private String leavrdate;
	private String answercontent;
	private String answerdate;
	private int state;
	public LeaveWord(int id, int memberid, int adminid, String title, String content, String leavrdate, String answercontent, String answerdate, int state) {
		super();
		this.id = id;
		this.memberid = memberid;
		this.adminid = adminid;
		this.title = title;
		this.content = content;
		this.leavrdate = leavrdate;
		this.answercontent = answercontent;
		this.answerdate = answerdate;
		this.state = state;
	}
	public LeaveWord() {
		super();
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAnswercontent() {
		return answercontent;
	}
	public void setAnswercontent(String answercontent) {
		this.answercontent = answercontent;
	}
	public String getAnswerdate() {
		return answerdate;
	}
	public void setAnswerdate(String answerdate) {
		this.answerdate = answerdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLeavrdate() {
		return leavrdate;
	}
	public void setLeavrdate(String leavrdate) {
		this.leavrdate = leavrdate;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
