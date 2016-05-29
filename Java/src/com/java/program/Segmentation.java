package com.java.program;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Segmentation {
	public static ArrayList<String> Segment(String sentence) throws IOException{
		ArrayList<String> word = new ArrayList<String>();
		StringReader stringReader = new StringReader(sentence);  
		IKSegmenter ik = new IKSegmenter(stringReader, true);
		Lexeme lex = null;
		while((lex = ik.next()) != null){
			String cut = lex.getLexemeText();
			word.add(cut);
		}
		return word;
	}
}
