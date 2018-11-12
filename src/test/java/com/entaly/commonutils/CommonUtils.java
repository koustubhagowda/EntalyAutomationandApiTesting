package com.entaly.commonutils;

import java.io.BufferedReader;
import java.io.FileReader;


import gherkin.deps.com.google.gson.Gson;

public class CommonUtils 
{
	public static String json = "";
	//Convert Json file to Json String
			public static String JSonFiletoJsonString(String JsonFile) {
				try {
					Gson gson = new Gson(); 
					json = gson.toJson(JsonFile); 
				}catch (Exception e) {
					 e.printStackTrace();
				}
				return json;
			}
	public static String readFile(String filename) {
	    String result = "";
	    try {
	        BufferedReader file = new BufferedReader(new FileReader(filename));
	        StringBuilder sb = new StringBuilder();
	        String line = file.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = file.readLine();
	        }
	        result = sb.toString();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
