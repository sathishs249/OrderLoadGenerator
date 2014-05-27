package com.gsot.personinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.yantra.yfc.dom.YFCDocument;
import com.yantra.yfc.dom.YFCElement;
//import  scala.collection.JavaConversions; 
//import static com.gsot.personinfo.PersonInfoGen;
public class PersonInfoGenarator extends CombinationGenarator{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		//get input XML pass the values to there methods
		YFCDocument orderLoadGenerator = YFCDocument.getDocumentForXMLFile("F:\\FromPC\\Sathish\\Performance\\PerformanceDataLoadGenerator\\input\\orderLoadGenerator.xml");
		process(orderLoadGenerator);
	}
	public static  void process(YFCDocument orderLoadGenerator) throws IOException{
		System.out.println("orderLoadGenerator"+orderLoadGenerator);
		YFCElement orderLoadGeneratorEle = orderLoadGenerator.getDocumentElement();
		YFCElement personInfoGenerator = orderLoadGeneratorEle.getChildElement("PersonInfoGenerator");
		YFCElement firstName = personInfoGenerator.getChildElement("FirstName");
		String firstNamefile = firstName.getAttribute("File");
		String firstNamecount =  firstName.getAttribute("Count");
		YFCElement lastName = personInfoGenerator.getChildElement("LastName");
		String lastNamefile = lastName.getAttribute("File");
		String lastNamecount =  lastName.getAttribute("Count");
		YFCElement orderPacing = orderLoadGeneratorEle.getChildElement("OrderPacing");
		String numberOfOrders = orderPacing.getAttribute("NumberOfOrders");
//new com.gsot.personinfo.PersonInfoGen.getValue();
//PersonInfoGen.initFirstName();
		//method call
		ArrayList<ArrayList<String>> totalcombinationList = getCombinationsList(firstNamefile,firstNamecount,lastNamefile,lastNamecount);
		Random r = new Random();
		for(int i=0;i<Integer.parseInt(numberOfOrders);i++){
		
			ArrayList<String> list = totalcombinationList.get(r.nextInt(totalcombinationList.size()));
			System.out.println("total list :"+list);
			createPersonInfoBillTo(list);
			createPersonInfoShipTo(list);

		}
	}
	private static YFCDocument createPersonInfoBillTo(ArrayList<String> list){
			
			YFCDocument personInfoBillTo = YFCDocument.createDocument("PersonInfoBillTo");	
			YFCElement personInfoBillToEle = personInfoBillTo.getDocumentElement();
			personInfoBillToEle.setAttribute("AddressLine1", list.get(7));
			personInfoBillToEle.setAttribute("AddressLine2", "");
			personInfoBillToEle.setAttribute("AddressLine3", "");
			personInfoBillToEle.setAttribute("AddressLine4", "");
			personInfoBillToEle.setAttribute("AddressLine5", "");
			personInfoBillToEle.setAttribute("City", list.get(3));
			personInfoBillToEle.setAttribute("Country", "");
			personInfoBillToEle.setAttribute("DayPhone", list.get(6));
			personInfoBillToEle.setAttribute("EMailID", list.get(2));
			personInfoBillToEle.setAttribute("FirstName", list.get(0));
			personInfoBillToEle.setAttribute("JobTitle", "");
			personInfoBillToEle.setAttribute("LastName", list.get(1));
			personInfoBillToEle.setAttribute("MiddleName", "");
			personInfoBillToEle.setAttribute("MobilePhone", list.get(6));
			personInfoBillToEle.setAttribute("PersonID", "");
			personInfoBillToEle.setAttribute("State", list.get(4));
			personInfoBillToEle.setAttribute("Suffix", "");
			personInfoBillToEle.setAttribute("Title", "");
			personInfoBillToEle.setAttribute("ZipCode", list.get(5));
			
			System.out.println(personInfoBillTo);		
			return personInfoBillTo;
	}
	private static YFCDocument createPersonInfoShipTo(ArrayList<String> list){
		
		YFCDocument personInfoBillTo = YFCDocument.createDocument("PersonInfoShipTo");	
		YFCElement personInfoBillToEle = personInfoBillTo.getDocumentElement();
		personInfoBillToEle.setAttribute("AddressLine1", list.get(7));
		personInfoBillToEle.setAttribute("AddressLine2", "");
		personInfoBillToEle.setAttribute("AddressLine3", "");
		personInfoBillToEle.setAttribute("AddressLine4", "");
		personInfoBillToEle.setAttribute("AddressLine5", "");
		personInfoBillToEle.setAttribute("City", list.get(3));
		personInfoBillToEle.setAttribute("Country", "");
		personInfoBillToEle.setAttribute("DayPhone", list.get(6));
		personInfoBillToEle.setAttribute("EMailID", list.get(2));
		personInfoBillToEle.setAttribute("FirstName", list.get(0));
		personInfoBillToEle.setAttribute("JobTitle", "");
		personInfoBillToEle.setAttribute("LastName", list.get(1));
		personInfoBillToEle.setAttribute("MiddleName", "");
		personInfoBillToEle.setAttribute("MobilePhone", list.get(6));
		personInfoBillToEle.setAttribute("PersonID", "");
		personInfoBillToEle.setAttribute("State", list.get(4));
		personInfoBillToEle.setAttribute("Suffix", "");
		personInfoBillToEle.setAttribute("Title", "");
		personInfoBillToEle.setAttribute("ZipCode", list.get(5));
		
		System.out.println(personInfoBillTo);		
		return personInfoBillTo;
}


}
