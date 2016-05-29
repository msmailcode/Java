package com.java.program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class FileProcess {
	public static void FileWrite(BufferedWriter out,Review review) throws IOException{		
		for(int i = 0;i < review.rateDetail.rateList.size();i++){
			out.write(review.rateDetail.rateList.get(i).rateContent+"\r\n");
		}
		System.out.println("File Success!");
	}
	
	public static ArrayList<String> FileRead() throws IOException{
		File file = new File("review.txt");
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
		BufferedReader in = new BufferedReader(reader);
		String line;
		ArrayList<String> addLine = new ArrayList<String>();
		while((line = in.readLine()) != null){
			if(line.equals("\r\n") ){
				continue;
			}
			addLine.add(line);
		}
		in.close();
		return addLine;
	}
	
	public static HashMap<String,Double> LoadData() throws IOException{
		HashMap<String,Double> map = new HashMap<String,Double>();
		File file = new File("sentiment_score.txt");
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
		BufferedReader in = new BufferedReader(reader);
		String line;
		String[] word;
		while((line = in.readLine()) != null){
			word = line.split(" ");
			map.put(word[0], Double.parseDouble(word[1]));
		}
		in.close();
		return map;
	}
}
