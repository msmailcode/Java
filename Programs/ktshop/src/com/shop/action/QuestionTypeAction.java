package com.shop.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Bigtype;
import com.shop.model.Smalltype;
import com.shop.service.BigtypeService;

public class QuestionTypeAction extends ActionSupport {

private static final long serialVersionUID = 1L;
private List<Bigtype> bigtypeList;
private Map<Integer, List<Smalltype>> smalltypeMap;
private BigtypeService bigtypeService;
private int bigtypeid;
public List<Bigtype> getBigtypeList() {
	return bigtypeList;
}

public void setBigtypeList(List<Bigtype> bigtypeList) {
	this.bigtypeList = bigtypeList;
}


public Map<Integer, List<Smalltype>> getSmalltypeMap() {
	return smalltypeMap;
}

public void setSmalltypeMap(Map<Integer, List<Smalltype>> smalltypeMap) {
	this.smalltypeMap = smalltypeMap;
}

//get/set·½·¨

public String list() {
bigtypeList = new ArrayList<Bigtype>();
try {
bigtypeList = this.bigtypeService.getAll();
} catch (Exception e) {
e.printStackTrace();
}
smalltypeMap = new HashMap<Integer, List<Smalltype>>();
for (int i = 0; i < bigtypeList.size(); i++) {
@SuppressWarnings({ })
List<Smalltype> smalltypeList = new ArrayList<Smalltype>(bigtypeList.get(i).getSmalltypes());
Integer bigtypeid = bigtypeList.get(i).getBigtypeid();
smalltypeMap.put(bigtypeid, smalltypeList);
}
return SUCCESS;
}

public void setBigtypeService(BigtypeService bigtypeService) {
	this.bigtypeService = bigtypeService;
}

public BigtypeService getBigtypeService() {
	return bigtypeService;
}

public int getBigtypeid() {
	return bigtypeid;
}

public void setBigtypeid(int bigtypeid) {
	this.bigtypeid = bigtypeid;
}


}