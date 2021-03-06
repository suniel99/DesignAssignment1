package aAnalyze;



import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXML {
	ArrayList <String> applicationName=new ArrayList<String>();
	static ArrayList <String> applicationRating=new ArrayList<String>();
	public ArrayList <String> getApplicationName()
	{
		return applicationName;
	}
	public static ArrayList <String> getApplicationRating()
	{
		return applicationRating;
	}
	 
	public static void readXML(String filePath)
	{
		ArrayList <String> applicationName=new ArrayList<String>();
		ArrayList <String> applicationRating=new ArrayList<String>();
		try
		{
		
			File inputXmlFile = new File(filePath);	
		DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		
			docBuilder = docFactory.newDocumentBuilder();
			Document doc=docBuilder.parse(inputXmlFile);
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("appName");
			
			for(int temp=0;temp<nList.getLength();temp++)
			{
				Node nNode=nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					applicationName.add(nNode.getTextContent());
					applicationRating.add(eElement.getElementsByTagName("dataPoint").item(0).getTextContent());
					//System.out.println("appName is "+eElement.getElementsByTagName("appName").item(0).getTextContent());
					//System.out.println("value is "+eElement.getElementsByTagName("dataPoint").item(0).getTextContent());
				
				}
			
		}
			Trigger.triggerCall(applicationRating);	
		}

		catch (Exception e) {
			e.printStackTrace();
		  } 
		
		
		
	}

}
