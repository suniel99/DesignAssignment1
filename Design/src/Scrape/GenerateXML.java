package Scrape;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import aAnalyze.ParseXML;
import aAnalyze.Trigger;

public class GenerateXML {
	public static void writeXML(ArrayList<String> applicationName,ArrayList<String> applicationRating)
	{
		try
		{
		DocumentBuilderFactory docFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
		
		Document doc=docBuilder.newDocument();
		Element rootElement=doc.createElement("Apps");
		doc.appendChild(rootElement);
		
		for(int i=0;i<applicationName.size();i++){
			
		
		Element appName=doc.createElement("appName");
		appName.appendChild(doc.createTextNode(applicationName.get(i)));
		rootElement.appendChild(appName);
		
		Element dataPoint=doc.createElement("dataPoint");
		dataPoint.appendChild(doc.createTextNode(applicationRating.get(i)));
		appName.appendChild(dataPoint);
		}
		
		
		
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		DOMSource source=new DOMSource(doc);
		StreamResult result=new StreamResult(new File("C:\\Concordia\\SDM\\Assignment1\\sample.xml"));
		
		transformer.transform(source,result);
		System.out.println("File saved");
		ParseXML.readXML("C:\\Concordia\\SDM\\Assignment1\\sample.xml");
		
		
	}
	catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }

}
}

