package com.java.program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

import org.wltea.analyzer.core.IKSegmenter;  
import org.wltea.analyzer.core.Lexeme;  

public class function {
	   public static void main(String[] args) throws IOException {	   
		   ArrayList<String> review = new ArrayList<String>();
		   try {
			   String encoding = "UTF-8";
			   File file = new File("review.txt");              
               if(file.isFile() && file.exists()){ //判断文件是否存在
                   InputStreamReader read = new InputStreamReader(
                   new FileInputStream(file),encoding);//考虑到编码格式
                   BufferedReader bufferedReader = new BufferedReader(read);
                   String line = null;
                   while((line = bufferedReader.readLine()) != null){
                       review.add(line);
                   }
                   read.close();
	       }else{
	           System.out.println("找不到指定的文件");
	       }
	       } catch (Exception e) {
	           System.out.println("读取文件内容出错");
	           e.printStackTrace();
	       }
		   System.out.println(review);
		   for(String text:review){
			   StringReader sr=new StringReader(text);  
		       IKSegmenter ik=new IKSegmenter(sr, true);
		   }
	       String text="内容充实 装订好。 适合有一定编程基础的人看 满分";  
	       StringReader sr=new StringReader(text);  
	       IKSegmenter ik=new IKSegmenter(sr, true);
	       ArrayList<String> word = new ArrayList<String>();	       
	       Lexeme lex=null;  
	       while((lex=ik.next())!=null){
	    	   String wordele = lex.getLexemeText();
	    	   word.add(wordele);
	    	   System.out.print(lex.getLexemeText()+"|");  
	       }
	       System.out.println("");
	       System.out.println(word);
	   }
	}
