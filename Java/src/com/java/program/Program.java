package com.java.program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Program {
	public static void main(String[] args) throws IOException{		
		int pageNum = 10;
		File file = new File("review.txt");
		FileWriter clear = new FileWriter(file);
	    clear.write("");
	    clear.close();		
		BufferedWriter out = new BufferedWriter(new FileWriter(file,true));
		for(int i = 1;i <=pageNum;i++){
			URLProcess urlpro = new URLProcess(i);
			String data = urlpro.accessData();
			Review review = JsonProcess.accessContent(data);
			FileProcess.FileWrite(out,review);
		}
		out.flush();
		out.close();		
		ArrayList<String> sentences = FileProcess.FileRead();
		double score;
		int pos=0;
		int neg=0;
		int neu=0;
		int count=0;
		for(String sentence:sentences){
			score = Analysis.sentiment(sentence);
			count++;
			if(score<0){
				neg++;
			}else if(score<5){
				neu++;
			}else{
				pos++;
			}
			System.out.println(sentence+" "+score);
		}
		System.out.println("共计"+count+"评论。");
		System.out.println("Positive(>5): "+pos+"  Nuetral(0-5): "+neu+"  Negative(<0): "+neg);
	}
}
