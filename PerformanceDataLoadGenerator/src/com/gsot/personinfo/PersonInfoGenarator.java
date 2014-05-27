package com.gsot.personinfo;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.yantra.yfc.dom.YFCDocument;
import com.yantra.yfc.dom.YFCElement;
//import  scala.collection.JavaConversions; 
//import static com.gsot.personinfo.PersonInfoGen;
public class PersonInfoGenarator {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		//get input XML pass the values to there methods   F:\Sathish\Workspace\OrderLoadGenerator\PerformanceDataLoadGenerator\input\orderLoadGenerator.xml
		YFCDocument orderLoadGenerator = YFCDocument.getDocumentForXMLFile("F:\\Sathish\\Workspace\\OrderLoadGenerator\\PerformanceDataLoadGenerator\\input\\orderLoadGenerator.xml");
		YFCElement orderLoadGeneratorEle = orderLoadGenerator.getDocumentElement();
		YFCElement orderPacing = orderLoadGeneratorEle.getChildElement("OrderPacing");
		String numberOfOrders = orderPacing.getAttribute("NumberOfOrders");
		
	
		for(int i=0;i<Integer.parseInt(numberOfOrders);i++){
			String personInfoBillToDoc= process(orderLoadGenerator);
			System.out.println("peronInfo bill to :"+ i+ " values :"+personInfoBillToDoc);
		}	
	}
	
	public String getPersonInfoXML() throws IOException{
		YFCDocument orderLoadGenerator = YFCDocument.getDocumentForXMLFile("F:\\Sathish\\Workspace\\OrderLoadGenerator\\PerformanceDataLoadGenerator\\input\\orderLoadGenerator.xml");
		return process(orderLoadGenerator);
	}
	
	private static String process(YFCDocument orderLoadGenerator) throws IOException{
		
		YFCElement orderLoadGeneratorEle = orderLoadGenerator.getDocumentElement();
		YFCElement personInfoGenerator = orderLoadGeneratorEle.getChildElement("PersonInfoGenerator");
		YFCElement firstName = personInfoGenerator.getChildElement("FirstName");
		String firstNamefile = firstName.getAttribute("File");
		String firstNamecount =  firstName.getAttribute("Count");
		YFCElement lastName = personInfoGenerator.getChildElement("LastName");
		String lastNamefile = lastName.getAttribute("File");
		String lastNamecount =  lastName.getAttribute("Count");
		
		//method call
		ArrayList<PersonInfoObject> totalcombinationList = CombinationGenarator.getCombinationsList(firstNamefile,firstNamecount,lastNamefile,lastNamecount);
		Random r = new Random();
		PersonInfoObject personInfoObject  = totalcombinationList.get(r.nextInt(totalcombinationList.size()));
		String personInfoBillToDoc = createPersonInfoBillTo(personInfoObject);
		String personInfoShipToDoc = createPersonInfoShipTo(personInfoObject);
		
		return personInfoBillToDoc+personInfoShipToDoc;
	}
	private static String createPersonInfoBillTo(PersonInfoObject personInfoObject){
		
			YFCDocument personInfoBillTo = YFCDocument.createDocument("PersonInfoBillTo");	
			YFCElement personInfoBillToEle = personInfoBillTo.getDocumentElement();
			personInfoBillToEle.setAttribute("AddressLine1", personInfoObject.getAddress());
			personInfoBillToEle.setAttribute("AddressLine2", "");
			personInfoBillToEle.setAttribute("AddressLine3", "");
			personInfoBillToEle.setAttribute("AddressLine4", "");
			personInfoBillToEle.setAttribute("AddressLine5", "");
			personInfoBillToEle.setAttribute("City", personInfoObject.getCity());
			personInfoBillToEle.setAttribute("Country", "");
			personInfoBillToEle.setAttribute("DayPhone", personInfoObject.getPhoneNo());
			personInfoBillToEle.setAttribute("EMailID", personInfoObject.getEmailID());
			personInfoBillToEle.setAttribute("FirstName", personInfoObject.getFirstName());
			personInfoBillToEle.setAttribute("JobTitle", "");
			personInfoBillToEle.setAttribute("LastName", personInfoObject.getLastName());
			personInfoBillToEle.setAttribute("MiddleName", "");
			personInfoBillToEle.setAttribute("MobilePhone", personInfoObject.getPhoneNo());
			personInfoBillToEle.setAttribute("PersonID", "");
			personInfoBillToEle.setAttribute("State", personInfoObject.getState());
			personInfoBillToEle.setAttribute("Suffix", "");
			personInfoBillToEle.setAttribute("Title", "");
			personInfoBillToEle.setAttribute("ZipCode", personInfoObject.getZipcode());
				
			return personInfoBillTo.toString();
	}
	private static String createPersonInfoShipTo(PersonInfoObject personInfoObject){
		
		YFCDocument personInfoBillTo = YFCDocument.createDocument("PersonInfoShipTo");	
		YFCElement personInfoBillToEle = personInfoBillTo.getDocumentElement();
		personInfoBillToEle.setAttribute("AddressLine1", personInfoObject.getAddress());
		personInfoBillToEle.setAttribute("AddressLine2", "");
		personInfoBillToEle.setAttribute("AddressLine3", "");
		personInfoBillToEle.setAttribute("AddressLine4", "");
		personInfoBillToEle.setAttribute("AddressLine5", "");
		personInfoBillToEle.setAttribute("City", personInfoObject.getCity());
		personInfoBillToEle.setAttribute("Country", "");
		personInfoBillToEle.setAttribute("DayPhone", personInfoObject.getPhoneNo());
		personInfoBillToEle.setAttribute("EMailID", personInfoObject.getEmailID());
		personInfoBillToEle.setAttribute("FirstName", personInfoObject.getFirstName());
		personInfoBillToEle.setAttribute("JobTitle", "");
		personInfoBillToEle.setAttribute("LastName", personInfoObject.getLastName());
		personInfoBillToEle.setAttribute("MiddleName", "");
		personInfoBillToEle.setAttribute("MobilePhone", personInfoObject.getPhoneNo());
		personInfoBillToEle.setAttribute("PersonID", "");
		personInfoBillToEle.setAttribute("State", personInfoObject.getState());
		personInfoBillToEle.setAttribute("Suffix", "");
		personInfoBillToEle.setAttribute("Title", "");
		personInfoBillToEle.setAttribute("ZipCode", personInfoObject.getZipcode());
		
		
		//System.out.println(personInfoBillTo);		
		return personInfoBillTo.toString();
	}
}
