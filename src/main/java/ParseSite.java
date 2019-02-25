
import org.apache.http.client.utils.URIBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class ParseSite {

    public String parseSite(String  ali_Url) {

        String jeson_line = null ;
        HttpURLConnection connection = null;
        BufferedReader bufferedReader_in = null;
        try {
            connection = (HttpURLConnection) new URL(ali_Url).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);
            connection.connect();

             bufferedReader_in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine= bufferedReader_in.readLine();
            /*while ((inputLine = bufferedReader_in.readLine()) != null) {
                System.out.println(inputLine);
                fetch_String(inputLine);
            }*/
            jeson_line = fetch_String(inputLine);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader_in.close();
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
        url = urlB.toString();
        return  url;
    }

    protected String fetch_String(String json){
        String subString_Json = json.substring(json.indexOf("{"),json.lastIndexOf("]"));
        System.out.println(subString_Json);
        return subString_Json;
    }

}
