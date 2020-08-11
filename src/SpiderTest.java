public class SpiderTest
{
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     * 
     * @param args
     *            - not used
     */
    public static void main(String[] args)
    {
        Spider spider = new Spider();
        System.out.println("------- Pet Octopus : V2 ------  ");
       //spider.search("https://www.capitalgroup.com/", "computer");
        spider.search(args[0], "computer");
        
    }
}