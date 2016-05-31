package javabean;

public class Orders {
	
	private int id;
	private int userID;
	private String datatime;
	private String saveName;
	private String savePhone;
	private String saveAddress;
	private String zip;
	private int deliverymode;
	private int moneymode;
	private int state;
	public Orders(int id, int userID, String datatime, String saveName, String savePhone, String saveAddress, String zip, int deliverymode, int moneymode, int state) {
		this.id = id;
		this.userID = userID;
		this.datatime = datatime;
		this.saveName = saveName;
		this.savePhone = savePhone;
		this.saveAddress = saveAddress;
		this.zip = zip;
		this.deliverymode = deliverymode;
		this.moneymode = moneymode;
		this.state = state;
	}
	public Orders() {
	}
	public String getDatatime() {
		return datatime;
	}
	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}
	public int getDeliverymode() {
		return deliverymode;
	}
	public void setDeliverymode(int deliverymode) {
		this.deliverymode = deliverymode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoneymode() {
		return moneymode;
	}
	public void setMoneymode(int moneymode) {
		this.moneymode = moneymode;
	}
	public String getSaveAddress() {
		return saveAddress;
	}
	public void setSaveAddress(String saveAddress) {
		this.saveAddress = saveAddress;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public String getSavePhone() {
		return savePhone;
	}
	public void setSavePhone(String savePhone) {
		this.savePhone = savePhone;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
}
