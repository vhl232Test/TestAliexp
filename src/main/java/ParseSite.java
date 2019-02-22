import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseSite {


    public void parseSite(String ali_Url) {
        WebClient client = new WebClient();
        client.setCssErrorHandler(new SilentCssErrorHandler());
        client.getOptions().setJavaScriptEnabled(false);

        //String ali_Url = "https://flashdeals.aliexpress.com/en.htm";
        HtmlPage htmlPage = null;
        try {
            htmlPage = client.getPage(ali_Url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<HtmlElement> elements = htmlPage.getByXPath("//div[@class='deals-item-inner']");
        for (int i = 0; i <100 ; i++) {
            for (HtmlElement elem:elements) {
                HtmlAnchor anchor =elem.getFirstByXPath(".//a");
                String name = anchor.asText();
                String url = anchor.getHrefAttribute();

                HtmlElement price_HTML = elem.getFirstByXPath("/p[@class='current-price']");
                String price = price_HTML.asText();

                HtmlElement orig_PriceElem = elem.getFirstByXPath("/p[@class='original-price']");
                String original_Price = orig_PriceElem.asText();

                HtmlElement soldItemElem = elem.getFirstByXPath("//span[@class='solder']");
                String sold_item = soldItemElem.asText();

                HtmlElement claimedElement = elem.getFirstByXPath("//span[@class='float-r']");
                String claimed = claimedElement.asText();

                HtmlElement discountElem = elem.getFirstByXPath("//span[@class='folatR']");
                String discount = discountElem.asText();

                HtmlElement itemDetailsElem = elem.getFirstByXPath("//h3[@class='item-details-title']");
                String item_Details = itemDetailsElem.asText();

                System.out.println(name + " "+ url+" "+price+" "+original_Price+" "+ sold_item+" "+claimed+" "+discount+
                        " "+ item_Details);
            }
        }



    }



}
