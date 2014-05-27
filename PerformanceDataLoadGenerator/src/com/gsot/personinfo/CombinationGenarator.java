package com.gsot.personinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.gsot.utils.FileProcessing;


public class CombinationGenarator extends FileProcessing {
	
	public static ArrayList<ArrayList<String>> getCombinationsList(String firstNamefile, String firstNamecount, String lastNamefile, String lastNamecount) throws IOException{
		 ArrayList<ArrayList<String>> totalList = new ArrayList<ArrayList<String>>();
		 ArrayList<String> listFirstName = FileProcessing.getFistNameList(firstNamefile, firstNamecount);
		 ArrayList<String> listLastName = FileProcessing.getLastNameList(lastNamefile, lastNamecount);
		 for(int i=0;i<listFirstName.size();i++){
				for(int j=0;j<listLastName.size();j++){
	        	   ArrayList<String> list = new ArrayList<String>();
	        	   System.out.println("Name :"+listFirstName.get(i)+" "+listLastName.get(j));   
	        	   String emailID = getEmailID(listFirstName.get(i).toString(),listLastName.get(j).toString());
	        	   int value = getValue(listFirstName.get(i)+listLastName.get(j));
	        	   ArrayList<String> cityziplist = getCityZip(value);
	        	   String city = getCity(cityziplist);
	        	   String state = getState(cityziplist);
	        	   String zipcode = getZipcode(cityziplist);
	        	   String phone = getPhone(value);
	        	   String address = getAddress(value,listLastName.get(j));
	        	   
	        	   list.add(listFirstName.get(i));
	        	   list.add(listLastName.get(j));
	        	   list.add(emailID);
	        	   list.add(city);
	        	   list.add(state);
	        	   list.add(zipcode);
	        	   list.add(phone);
	        	   list.add(address);
	        	   System.out.println("list :"+list);
	        	   totalList.add(list);
	           }
		 }
		System.out.println(totalList);
		return totalList;
		
	}
	private static String getEmailID(String fName, String lName) throws IOException{
		return fName + "." + lName + "@gmail.com";
	}
	private static int getValue(String name) throws IOException{
		int a =0;
		for(int i=0;i<name.length();i++){
			char character = name.charAt(i); 
            int b = (int) character;
            a = a+b;
            //a = ((a + (b - ' '))*2);
		}
		return a;
	}
	
	private static ArrayList<String> getCityZip(int value) throws IOException{
		LinkedHashMap<String, ArrayList<String>> Listcityzip = listcityzip();
		int cityzipsize = Listcityzip.size();
 	    int citvalue = value%cityzipsize;
 	   LinkedHashMap<String, ArrayList<String>> cityzipList =getcityzip(citvalue);
		 ArrayList<String> list = new ArrayList<String>();
		 for (Entry<String, ArrayList<String>> entry : cityzipList.entrySet()) { 
			 list = entry.getValue();
      }
		return list;
	}
	
	private static String getCity(ArrayList<String> cityziplist) throws IOException{
		 return cityziplist.get(0);
	}
	private static String getState(ArrayList<String> cityziplist) throws IOException{
		 return cityziplist.get(1);
	}
	private static String getZipcode(ArrayList<String> cityziplist) throws IOException{
		 return cityziplist.get(2);
	}
	private static String getPhone(int value) throws IOException{
		Long val = Long.parseLong(String.valueOf(value));
		String len = ((val % 800) + 133)  + "-" + ((val % 700) + 201) + "-" + ((val % 6000) + 1333);
		 return len;
	}
	private static String getAddress(int value, String lname) throws IOException{
		Long val = Long.parseLong(String.valueOf(value));
		String address = val% 1000 + " " + lname + " Street";
		 return address;
	}
}
