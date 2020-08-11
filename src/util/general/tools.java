package util.general;

import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class tools 
{

	public static int getTotalImageCount( Document htmlDocument )
	{
		return htmlDocument.getElementsByAttribute("src").size();
	}
	
	public static int getAllImageSize( Document htmlDocument )
	{
		int countOfAllImages = htmlDocument.getElementsByAttribute("src").size();
		for (int i = 0; i < countOfAllImages ; i++) 
		{
			String imageURL = htmlDocument.getElementsByAttribute("src").get( i ).absUrl("src");
			int imageSize = getImageSize( imageURL );
			boolean hasAltText = htmlDocument.getElementsByAttribute("src").get( i ).hasAttr("alt");
			String altText = htmlDocument.getElementsByAttribute("src").get( i ).attr("alt");
			//boolean isImagePrestnt = isImagePrestnt( imageURL );
			System.out.println( imageURL + " , " + /*isImagePrestnt +  , "*/ + imageSize+ " , "+ hasAltText + " , " + altText + " , ");

		}
		
		return countOfAllImages;
		
	}
	
	public static int getImageSize( String url )
	{
		try
		{
			return new URL( url ).openConnection().getContentLength(); // size in bytes/
		}
		catch (Exception e5) 
		{
			e5.printStackTrace();
		}
		return -1;
	}

	public static boolean isImagePrestnt( String url )
	{
		try
		{
			return Jsoup.connect( url ).followRedirects(false).execute().statusCode() == 200 ;
		}
		catch (Exception e5) 
		{
			e5.printStackTrace();
		}
		return false;
	}

	public static String getAllElementsStatus(Document htmlDocument)
	{
	        
		String elements = htmlDocument.getAllElements().get(0).baseUri();
		//elements.get(0).
		//.out.println("Elements : " + elements.get(0.);
		try 
		{
			Response response = Jsoup.connect( elements ).followRedirects(false).execute();
		    System.out.println(response.statusCode() + " : " + response.url());
	
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
