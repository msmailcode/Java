package com.java.program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class JavaServlet {
	public String sellerId;
	public String itemId;
	public int pageCount;
	public JavaServlet(){
		this.pageCount = 2;
	}
	
	public JavaServlet(String itemId,String sellerId,int pageCount){
		this.sellerId = sellerId;
		this.itemId = itemId;
		this.pageCount = pageCount;
	}
	
	public HashMap<String,Double> Servlet() throws IOException{
		File file = new File("review.txt");
                FileWriter clear = new FileWriter(file);
                clear.write("");
                clear.close();
		BufferedWriter out = new BufferedWriter(new FileWriter(file,true));
		for(int i = 1;i <= pageCount;i++){
			URLProcess urlpro;
			if(this.sellerId !=null && this.itemId !=null){
				urlpro = new URLProcess(itemId,sellerId,i);
			}else{
				urlpro = new URLProcess(i);
			}
			String data = urlpro.accessData();
			Review review = JsonProcess.accessContent(data);
			FileProcess.FileWrite(out,review);
		}
		out.flush();
		out.close();		
		ArrayList<String> sentences = FileProcess.FileRead();
		double score; 
                HashMap<String,Double> scoreMap = new HashMap<String,Double>();
		for(String sentence:sentences){
			score = Analysis.sentiment(sentence);
                        scoreMap.put(sentence,score);
		}
               
                return scoreMap;
	}
	
}
