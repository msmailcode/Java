package com.shop.test;

public class HelloWorld { 
    public static void main(String[] argv){ 
       try{                
         System.out.println(new String("����".getBytes("ISO8859_1")));//1 
         System.out.println(new String("����".getBytes("ISO8859_1"),"ISO8859_1"));//2 
         System.out.println(new String("����".getBytes("ISO8859_1"),"GB2312"));//3        
         System.out.println(new String("����".getBytes(),"ISO8859_1"));//4 
         System.out.println(new String("����".getBytes("GB2312"),"ISO8859_1"));//5 
         System.out.println("����".getBytes());//6
         System.out.println("����".getBytes("ISO8859_1"));//7 
         System.out.println("����".getBytes("GB2312"));//8        
         System.out.println("����");//9         
         System.out.println(new String("����".getBytes()));//10 
         System.out.println(new String("����".getBytes(),"GB2312"));//11 
         System.out.println(new String("����".getBytes("GB2312")));//12 
         System.out.println(new String("����".getBytes("GB2312"),"GB2312"));//13 
       } 
       catch(Exception e){ 
         e.printStackTrace(); 
       } 
     } 
} 



