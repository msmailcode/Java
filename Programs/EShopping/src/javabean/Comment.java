package javabean;

public class Comment {
	
	private int id;
	private String userName;
	private int bookid;
	private String datatime;
	private String contents;
	public Comment(int id, String userName, int bookid, String datatime, String contents) {
		this.id = id;
		this.userName = userName;
		this.bookid = bookid;
		this.datatime = datatime;
		this.contents = contents;
	}
	public Comment() {
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDatatime() {
		return datatime;
	}
	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
