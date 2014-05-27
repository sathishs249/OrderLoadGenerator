package com.gsot.personinfo;

i
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class CombinationGenarator {
	
	public static ArrayList<PersonInfoObject> getCombinationsList(String firstNamefile, String firstNamecount, String lastNamefile, String lastNamecount) throws IOException{
		 ArrayList<PersonInfoObject> totalList = new ArrayList<PersonInfoObject>();
		 ArrayList<String> listFirstName = FileProcessing.getFistNameList(firstNamefile, firstNamecount);
		 ArrayList<String> listLastName = FileProcessing.getLastNameList(lastNamefile, lastNamecount);
		 
		 for(int i=0;i<listFirstName.size();i++){
				for(int j=0;j<listLastName.size();j++){
	        	   PersonInfoObject personInfoObject = new PersonInfoObject();
	        	   //System.out.println("Name :"+listFirstName.get(i)+" "+listLastName.get(j));   
	        	   String emailID = getEmailID(listFirstName.get(i).toString(),listLastName.get(j).toString());
	        	   int value = getValue(listFirstName.get(i)+listLastName.get(j));
	        	   AddressObject cityzipobj = getCityZip(value);
	        	   String city = getCity(cityzipobj);
	        	   String state = getState(cityzipobj);
	        	   String zipcode = getZipcode(cityzipobj);
	        	   String phone = getPhone(value);
	        	   String address = getAddress(value,listLastName.get(j));
	        	   
	        	   personInfoObject.setFirstName(listFirstName.get(i));
	        	   personInfoObject.setLastName(listLastName.get(j));
	        	   personInfoObject.setEmailID(emailID);
	        	   personInfoObject.setCity(city);
	        	   personInfoObject.setState(state);
	        	   personInfoObject.setZipcode(zipcode);
	        	   personInfoObject.setPhoneNo(phone);
	        	   personInfoObject.setAddress(address);
	        	   totalList.add(personInfoObject);
	        	  
	           }
		 }
		//System.out.println(totalList.toString());
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
	
	private static AddressObject getCityZip(int value) throws IOException{
		String file = "F:\\FromPC\\Sathish\\Performance\\PerformanceDataLoadGenerator\\input\\cityzip.txt";
	
		LinkedHashMap<String, ArrayList<String>> Listcityzip = FileProcessing.listcityzip(file);
		int cityzipsize = Listcityzip.size();
 	    int citvalue = value%cityzipsize;
 	   LinkedHashMap<String, AddressObject> cityzipList =FileProcessing.getcityzip(citvalue,file);
		 AddressObject addressObject = new AddressObject();
		 for (Entry<String, AddressObject> entry : cityzipList.entrySet()) { 
			 addressObject = entry.getValue();
      }
		return addressObject;
	}
	
	private static String getCity(AddressObject cityzipobj) throws IOException{
		 return cityzipobj.getCity();
	}
	private static String getState(AddressObject cityzipobj) throws IOException{
		 return cityzipobj.getState();
	}
	private static String getZipcode(AddressObject cityzipobj) throws IOException{
		 return cityzipobj.getZipcode();
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
