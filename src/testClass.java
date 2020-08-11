import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.w3c.dom.html.HTMLInputElement;
///import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

public class testClass 
	{
    
	private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    
   private static final  String url = "http://www.mitramain.com/";
   //final WebClient webClient = new WebClient(); 

  // public static WebDriver driver = new HtmlUnitDriver();
   public static Element element = null;
	
		public static void main( String s[])
		{
			try
			{
	            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
	            Document htmlDocument = connection.get();
/*	            System.out.println("Title : " + htmlDocument.title());
	            System.out.println("Page Content : " + htmlDocument.text());
	            System.out.println("Char Set : " +  htmlDocument.outputSettings().charset());
	            System.out.println("cssSelector : " +  htmlDocument.cssSelector());
	            System.out.println("className : " +  htmlDocument.className());
	            System.out.println("elementSiblingIndex : " +  htmlDocument.elementSiblingIndex());
	            System.out.println("Page HTML Content : " +  htmlDocument.html());
	            System.out.println("Page User visible content : " +  htmlDocument.wholeText());
*/	           // System.out.println("Number of Images : " + util.general.tools.getTotalImageCount(htmlDocument));
	            System.out.println("Image Details : " + util.general.tools. getAllImageSize ( htmlDocument ));
	           
	            //work on the below code
	            //System.out.println( "Element Status " + util.general.tools. getAllElementsStatus ( htmlDocument ));
	            
	            
	            
	            
	            
	            

	      //      System.out.println("Page User visible content : " +  htmlDocument.getAllElements().get(0).getElementById(""));
	     //       element = htmlDocument.getAllElements().get(0).click();
	 //           HtmlElement anchor = ( HtmlElement )htmlDocument.getElementsByTag("a").get(2);
	          //  HtmlElement


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
