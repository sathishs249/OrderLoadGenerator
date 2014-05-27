package com.gsot.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class FileProcessing {
	
	public static  ArrayList<String> getFistNameList(String file,String count) throws IOException{
		Random r = new Random();
		BufferedReader in = new BufferedReader(new FileReader(file));
		ArrayList<String> firstnameList = new ArrayList<String>();  
		ArrayList<String> list = new ArrayList<String>();
        String line = "";
        int count1 = Integer.parseInt(count);
        while (((line = in.readLine()) != null)) {
        	list.add(line);
        }
        for(int i=0;i<count1;i++){
        	String firstname = list.get(r.nextInt(list.size()));
        	firstnameList.add(firstname);
        }
        	
        in.close();
        return firstnameList;
	}
	public static ArrayList<String> getLastNameList(String file,String count) throws IOException{
		Random r = new Random();
		BufferedReader in = new BufferedReader(new FileReader(file));
		ArrayList<String> lastnameList = new ArrayList<String>();      
		ArrayList<String> list = new ArrayList<String>();
		String line = "";
        int count1 = Integer.parseInt(count);
        while (((line = in.readLine()) != null)) {
        	list.add(line);
        }
        in.close();
        for(int i=0;i<count1;i++){
        	String lastname = list.get(r.nextInt(list.size()));
        	lastnameList.add(lastname);
        }
        return  lastnameList;
	}
	public static  LinkedHashMap<String, ArrayList<String>> listcityzip() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("F:\\FromPC\\Sathish\\Performance\\PerformanceDataLoadGenerator\\input\\cityzip.txt"));
		 LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();      
			String lines = "";
	        while (((lines = in.readLine()) != null)) {
	        	String parts[] = lines.split(",");
	        	ArrayList<String> listt =new ArrayList<String>();
	        	listt.add(parts[1]);
	        	listt.add(parts[2]);
	        	listt.add(parts[3]);
	        	map.put(parts[0], listt);
	        	
	        }
	        in.close();
	       return  map;
	       
		/*LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();      
		ArrayList<String> list =new ArrayList<String>();
		String line = "";
        while (((line = in.readLine()) != null)) {
        	String parts[] = line.split(",");
        	String val = ""+value;
        	if(parts[0].equals(val)){
        		list.add(parts[1]);
            	list.add(parts[2]);
            	list.add(parts[3]);
            	map.put(parts[0], list);
        	}
        }
        in.close();
       System.out.println("map :"+map.toString());
        return  map;*/
	}
	public static  LinkedHashMap<String, ArrayList<String>> getcityzip(int value) throws IOException{
		System.out.println("city zip value :"+value);
		BufferedReader in = new BufferedReader(new FileReader("F:\\FromPC\\Sathish\\Performance\\PerformanceDataLoadGenerator\\input\\cityzip.txt"));
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();      
		ArrayList<String> list =new ArrayList<String>();
		String line = "";
        while (((line = in.readLine()) != null)) {
        	String parts[] = line.split(",");
        	String val = ""+value;
        	if(parts[0].equals(val)){
        		list.add(parts[1]);
            	list.add(parts[2]);
            	list.add(parts[3]);
            	map.put(parts[0], list);
        	}
        }
        in.close();
       System.out.println("get in city zip map :"+map.toString());
        return  map;
	}
}
