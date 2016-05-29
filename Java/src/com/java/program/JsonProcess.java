package com.java.program;

import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonProcess {
	public static Review accessContent(String data) throws IOException{		
		String json = "{"+data+"}";
		json = json.replaceAll("\"pics\":\"\"","\"pics\": [\"jpg\"]");
		Gson gson = new Gson();
		//Type type = new TypeToken<Review>(){}.getType();
		//Review review = gson.fromJson(json, type);
		Review review = gson.fromJson(json, Review.class);
		return review;
	}
	
}
