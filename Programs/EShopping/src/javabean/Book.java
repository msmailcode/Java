package javabean;

public class Book {
	private int id;
	private int typeid;
	private String name;
	private float price;
	private float saleprice;
	private String descript;
	private String contents;
	private String fileName;
	private String leavetime;
	private int storage;
	private String provider;
	private String marque;
	private String unit;
	public Book(int id, int typeid, String name, float price, float saleprice, String descript, String contents, String fileName, String leavetime, int storage, String provider, String marque, String unit) {
		this.id = id;
		this.typeid = typeid;
		this.name = name;
		this.price = price;
		this.saleprice = saleprice;
		this.descript = descript;
		this.contents = contents;
		this.fileName = fileName;
		this.leavetime = leavetime;
		this.storage = storage;
		this.provider = provider;
		this.marque = marque;
		this.unit = unit;
	}
	public Book() {
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLeavetime() {
		return leavetime;
	}
	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public float getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(float saleprice) {
		this.saleprice = saleprice;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
