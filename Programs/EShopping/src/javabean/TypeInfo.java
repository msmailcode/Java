package javabean;

import java.io.Serializable;

public class TypeInfo implements Serializable{
	
	private int id;
	private String typeName;
	private String typeInfo;
	public TypeInfo(int id, String typeName, String typeInfo) {
		this.id = id;
		this.typeName = typeName;
		this.typeInfo = typeInfo;
	}
	public TypeInfo() {
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeInfo() {
		return typeInfo;
	}
	public void setTypeInfo(String typeInfo) {
		this.typeInfo = typeInfo;
	}
}
