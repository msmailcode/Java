package com.java.program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Analysis {
	public static double sentiment(String sentence) throws IOException{
		HashMap<String, Double> map = FileProcess.LoadData();
		ArrayList<String> word = Segmentation.Segment(sentence);
		double senScore = 0;
		double wordScore;
		for(String cut:word){
			if((map.get(cut)) != null){
				wordScore = map.get(cut);
			}else{
				wordScore = 0;
			}
			senScore += wordScore; 
		}
		return senScore;
	}
}
