package javabean;

public class OrderBean {
	
	private int id;
	private String datatime;
	private int state;
	private float totalprice;
	public OrderBean(int id, String datatime, int state, float totalprice) {
		this.id = id;
		this.datatime = datatime;
		this.state = state;
		this.totalprice = totalprice;
	}
	public OrderBean() {
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
}
