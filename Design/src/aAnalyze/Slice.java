package aAnalyze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
/*
class Slice {
   ArrayList<String> applicationRating;
	//double value;
   Color color;
   public Slice(ArrayList<String> applicationRating, Color color) {  
      this.applicationRating= applicationRating;
      this.color = color;
   }
}
*/class MyComponent extends JComponent {
/*Slice[] slices = { 
	new Slice(Integer.parseInt(applicationRating.get(1)), Color.black), 
   new Slice(Integer.parseInt(applicationRating.get(1)), Color.green),
   new Slice(Integer.parseInt(applicationRating.get(1)), Color.yellow), 
   new Slice(Integer.parseInt(applicationRating.get(1)), Color.red) };*/
	
	ArrayList<String> applicationRating=new ArrayList<String>();	
	MyComponent(ArrayList<String> applicationRating) {
		this.applicationRating=applicationRating;
		
	}
	
	
	public ArrayList<String> getApplicationRating()
	{
		System.out.println("Time "+applicationRating);
		return applicationRating;
	}
   public void paint(Graphics g) {
	   System.out.println("Logger present here 2"+applicationRating);
      getApplicationRating();
	   drawPie((Graphics2D) g, getBounds(), applicationRating);
      //System.out.println("Logger present here 3");
      //System.out.println("applicationRating---->"+applicationRating);
   }
   void drawPie(Graphics2D g, Rectangle area,ArrayList<String> applicationRating) {
      double total = 0.0D;
      //System.out.println("Logger present here 4");
      //System.out.println("Logger present here 5"+applicationRating);
      ArrayList<Integer> applicationRatingInteger= new ArrayList<Integer>();
      //System.out.println("Logger present here 6");
      for(int j=0;j<applicationRating.size();j++)
      {
    	//  System.out.println("Logger present here 7");
    	  String s = applicationRating.get(j).substring(0, 4).replace(",","");
    	  //System.out.println(s);
      int a = Integer.parseInt(s);
      System.out.println("a---->"+a);
      applicationRatingInteger.add(a);
      }
      
      /*
      int b = Integer.parseInt(applicationRating.get(2));
      int c = Integer.parseInt(applicationRating.get(3));
      int d = Integer.parseInt(applicationRating.get(4));*/
      
      
      for (int i = 0; i < applicationRatingInteger.size(); i++) {
    	  System.out.println("applicationRatingInteger--->"+applicationRatingInteger);
         total += applicationRatingInteger.get(i);
      }
      System.out.println("total----->"+total);
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < applicationRatingInteger.size(); i++) {
         startAngle = (int) (curValue * 360 / total);
         System.out.println("Start angle------>"+startAngle);
         int arcAngle = (int) (applicationRatingInteger.get(i) * 360 / total);
         if(i%2==0)
         {
         g.setColor(Color.red);
         System.out.println("inside if");
         }
         else
            {
        	 g.setColor(Color.blue);
            
         System.out.println("inside else");
            }
         g.fillArc(area.x, area.y, area.width, area.height, 
         startAngle, arcAngle);
         curValue += applicationRatingInteger.get(i);
      System.out.println("currvalue---->"+curValue);
      }
   }
}
