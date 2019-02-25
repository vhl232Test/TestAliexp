import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseSite {

    public String parseSite(String  ali_Url) {
        //URL ali;
        String jeson_line = null ;
        HttpURLConnection connection = null;
        BufferedReader bufferedReader_in = null;
        try {
            //ali = new URL(ali_Url);
            //URLConnection urlConnection = ali.openConnection();
            connection = (HttpURLConnection) new URL(ali_Url).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);
            connection.connect();

            // BufferedReader bufferedReader_in = new BufferedReader(new InputStreamReader(ali.openStream()));
             bufferedReader_in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine= bufferedReader_in.readLine();
            /*while ((inputLine = bufferedReader_in.readLine()) != null) {
                System.out.println(inputLine);
                fetch_String(inputLine);
            }*/
            jeson_line = fetch_String(inputLine);

            bufferedReader_in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jeson_line;
    }



    protected String createUri(int offset) throws URISyntaxException {


        String url = new String();

          URI urlB =  new URIBuilder()
                .setScheme("https")
                .setHost("gpsfront.aliexpress.com")
                .setPath("/queryGpsProductAjax.do")
                .setParameter("callback", "jQuery18309481817588303088_1550828463051")
                .setParameter("widget_id", "5547572")
                .setParameter("platform", "pc")
                .setParameter("limit", "12")
                .setParameter("offset", String.valueOf(offset))
                .setParameter("phase", "1")
                .setParameter("productIds2Top", "")
                .setParameter("postback", offset==0 ?"":"c7e67e06-6ff5-4561-a44a-2c161d9fc4a7")
                .setParameter("_", String.valueOf(System.currentTimeMillis()))
                .build();

        return  url = urlB.toString();
    }

    protected String fetch_String(String json){
        String subString_Json = json.substring(json.indexOf("[")+1,json.lastIndexOf("]"));
        System.out.println(subString_Json);
        return subString_Json;
    }




        /*WebClient client = new WebClient();
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
        }*/

}
