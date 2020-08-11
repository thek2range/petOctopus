import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider
{
  private static final int MAX_PAGES_TO_SEARCH = 100000;
  private Set<String> pagesVisited = new HashSet<String>();
  private List<String> pagesToVisit = new LinkedList<String>();


  /**
   * Our main launching point for the Spider's functionality. Internally it creates spider legs
   * that make an HTTP request and parse the response (the web page).
   * 
   * @param url
   *            - The starting point of the spider
   * @param searchWord
   *            - The word or string that you are searching for
   */
  public void search(String url, String searchWord)
  {
      while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
      {
          String currentUrl;
          SpiderLeg leg = new SpiderLeg();
          if(this.pagesToVisit.isEmpty())
          {
              currentUrl = url;
              this.pagesVisited.add(url);
          }
          else
          {
              currentUrl = this.nextUrl();
          }
          if ((!currentUrl.contains("facebook.com")) &&
        		  (!currentUrl.contains("youtube.com")) &&
        		  (!currentUrl.contains("linkedin.com")) &&
        		  (!currentUrl.contains("twitter.com")) &&
        		  (!currentUrl.contains("googleplus.com") &&
        		(!currentUrl.contains("baidu.com")) &&
        		(!currentUrl.contains("transunion.com"))
        		&&(!currentUrl.contains("accounts.google.com"))
        		&&(!currentUrl.contains("https://postalinspectors.uspis.gov/"))
        		&&(!currentUrl.contains("http://www.fraudalerts.equifax.com/"))
        		&&(!currentUrl.contains("http://www.experian.com/"))
        		&&(!currentUrl.contains("http://www.consumer.ftc.gov"))
        		&&(!currentUrl.contains("http://www.onguardonline.gov/"))
        		&&(!currentUrl.contains("http://www.lipperfundawards.com/"))
        		&&(!currentUrl.contains("https://www.assettv.com/"))
        		&&(!currentUrl.contains("call-us"))
        		&&(!currentUrl.contains("/ca"))
        		&&(!currentUrl.contains("/asia")) 
        		&&(!currentUrl.contains("/lu/fr")) 
        		&&(!currentUrl.contains("#")) 
        		&&(!currentUrl.contains(".html#")) 
        		&&(!currentUrl.contains("contact")) 
        		&&(!currentUrl.contains("feedback")) 
        		&&(!currentUrl.contains("login"))
        		&&(!currentUrl.contains("logon"))
        		&&(!currentUrl.contains("logout"))
        		&&(!currentUrl.contains("switcher")) 
        		&&(!currentUrl.contains("/de/")) 
        		&&(!currentUrl.contains("/fr/")) 
           		&&(!currentUrl.contains("/at/")) 
           		&&(!currentUrl.contains("/be/")) 
           		&&(!currentUrl.contains("/ch/")) 
        		&&(!currentUrl.contains("/es/"))
        		&&(!currentUrl.contains("/sg/"))
        		&&(!currentUrl.contains("/hk/"))
        		&&(!currentUrl.contains("/nl/"))
        		&&(!currentUrl.contains("/dk/"))
        		&&(!currentUrl.contains("/no/"))
        		&&(!currentUrl.contains("/fi/"))
        		&&(!currentUrl.contains("/se/"))
        		&&(!currentUrl.contains("/it/")) 
        		&&(!currentUrl.contains("/our-")) 
        		&&(!currentUrl.contains("preferences")) 
        		&&(!currentUrl.contains("Logon"))
        		&&(!currentUrl.contains("guest-author")) 
        		&&(!currentUrl.contains("/au/"))
        		&&(!currentUrl.contains("test"))
        		&&(!currentUrl.contains("/jp/ja"))		  
        		&&(!currentUrl.contains("/is/"))		  
        		&&(!currentUrl.contains("/ie/"))
        		&&(!currentUrl.contains("/gb/"))		  
        		&&(!currentUrl.contains("/not-listed/"))			  
        		&&(!currentUrl.contains("Login"))	
        		&&(!currentUrl.contains("about"))	
        		&&(!currentUrl.contains("privecy"))	
        		&&(!currentUrl.contains("/pt/"))	
        		&&(!currentUrl.contains("/job/"))
        		&&(!currentUrl.contains("/go/"))
        		&&(!currentUrl.contains("/content/"))
        		&&(!currentUrl.contains("individual"))
        		&&(!currentUrl.contains("/pe"))
        		&&(!currentUrl.contains(".au"))
        		&&(!currentUrl.startsWith("http://brokercheck.finra.org"))
        		&&(!currentUrl.startsWith("https://jobs"))
        		&&(!currentUrl.startsWith("http://info"))
        		&&(!currentUrl.contains("/investments/"))
        		&&(!currentUrl.contains("/pcs/"))
        		&&(!currentUrl.contains("/employer/"))
        		&&(!currentUrl.endsWith(".pdf"))
        		&&(!currentUrl.contains("twitter"))
        		&&(!currentUrl.contains("_jcr_content"))
        		&&(!currentUrl.endsWith("europe"))
        		&&(!currentUrl.endsWith("europe"))
        		&&(!currentUrl.endsWith("/tpa/"))
        				  )) 
          {
        	  		   	leg.crawl(currentUrl); // Lots of stuff happening here. Look at the crawl method in
                                 // SpiderLeg
				          boolean success = leg.searchForWord(searchWord);
				          if(success)
				          {
				             // System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
				             // break;
				          }
				          this.pagesToVisit.addAll(leg.getLinks());
          }
          else
        	  continue;
      }
      System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
  }


  /**
   * Returns the next URL to visit (in the order that they were found). We also do a check to make
   * sure this method doesn't return a URL that has already been visited.
   * 
   * @return
   */
  private String nextUrl()
  {
      String nextUrl;
      do
      {
          nextUrl = this.pagesToVisit.remove(0);
      } while(this.pagesVisited.contains(nextUrl));
      this.pagesVisited.add(nextUrl);
      return nextUrl;
  }
}