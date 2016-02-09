package Scrape;

import java.io.IOException;
import java.util.ArrayList;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//import org.jsoup.select.Elements;
import Scrape.GenerateXML;

public class ScrapeWebUrl {

	public static void scrapeUrl(ArrayList<String> l){
		Document doc;
		
		try {
			//System.out.println("url in Scrapeweburl is -->"+url );
			
			
			ArrayList <String> applicationName=new ArrayList<String>();
			ArrayList <String> applicationRating=new ArrayList<String>();
			
			for(int i=0;i<l.size();i++)
			{
			String url=l.get(i);
				doc=Jsoup.connect(url).get();
			//Element div=doc.select("#offscreen-renderer").first();
			Element rating=doc.select("div.right-info span").first();
			System.out.println("div to be printed : "+rating);
			System.out.println("final text is ---> "+rating.text());
			
			Element appName=doc.select("div.id-app-title").first();
			System.out.println("title for the app"+appName.text());
			
			applicationName.add(appName.text());
			applicationRating.add(rating.text());
			
			
		}
			GenerateXML.writeXML(applicationName,applicationRating);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
