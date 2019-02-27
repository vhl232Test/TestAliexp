
import org.apache.http.client.utils.URIBuilder;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class ParseSite {
    public List<Item> parseSite(String  ali_Url) {
        String jeson_line = null ;
        HttpURLConnection connection = null;
        BufferedReader bufferedReader_in = null;
        List<Item> items = null;
        while (true) {
            if (!Main.ifWeHaveSomeTime()) return null;
            try {
                connection = (HttpURLConnection) new URL(ali_Url).openConnection();
                connection.setRequestMethod("GET");
                connection.setUseCaches(false);
                connection.setConnectTimeout(250);
                connection.setReadTimeout(250);
                connection.connect();


                bufferedReader_in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine = bufferedReader_in.readLine();
            /*while ((inputLine = bufferedReader_in.readLine()) != null) {
                System.out.println(inputLine);
                getItems(inputLine);
            }*/
                close(bufferedReader_in);

                items = getItems(inputLine);
                break;


            } catch (Exception e) {
                System.out.print(".");
                try {
                    Thread.sleep(283);
                } catch (InterruptedException e1) {
                    return null;
                }
            } finally {
                close(bufferedReader_in);
            }
        }
        return items;
    }

    private  void  close(Closeable close){
        try {
            close.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
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

    protected List<Item> getItems(String json) throws Exception {
        //validate json
        if(!json.startsWith("jQuery18309481817588303088_1550828463051")){
            throw new  Exception("wrong json");
        }
        String subString_Json = json.substring(json.indexOf("["),json.lastIndexOf("]")+1);

        List<Item> items = new LinkedList<>();
        for(String itemString : fetchItemStrings(subString_Json)) {
            items.add(parseItem(itemString));
        }
        return items;
    }

    private Item parseItem(String itemString) {
        Item item = new Item();
        String[] split = itemString.split(",");
        item.setProductId(getLongFromJsonString(split[0]));
        item.setSellerId(getLongFromJsonString(split[1]));
        item.setProductImage(getStringFromJsonString(split[2]));
        item.setProductDetailUrl(getStringFromJsonString(split[3]));
        item.setProductTitle(getStringFromJsonString(split[4]));
        item.setMinPrice(getStringFromJsonString(split[5]));
        item.setMaxPrice(getStringFromJsonString(split[6]));
        item.setOriMinPrice(getStringFromJsonString(split[7]));
        item.setOriMaxPrice(getStringFromJsonString(split[8]));
        item.setDiscount(getStringFromJsonString(split[9]));
        item.setPromotionId(getLongFromJsonString(split[10]));
        item.setStartTime(getLongFromJsonString(split[11]));
        item.setEndTime(getLongFromJsonString(split[12]));
        item.setPhase(getLongFromJsonString(split[13]));
        item.setTotalStock(getStringFromJsonString(split[14]));
        item.setStock(getStringFromJsonString(split[15]));
        item.setSoldout(getStringFromJsonString(split[16]).equalsIgnoreCase("true"));
        item.setOrders(getStringFromJsonString(split[17]));
        item.setShopName(getStringFromJsonString(split[18]));
        item.setShopUrl(getStringFromJsonString(split[19]));

        return item;
    }

    private long getLongFromJsonString(String s){
        return Long.parseLong(s.substring(s.indexOf(":")+1));
    }
    private String getStringFromJsonString(String s){
        return s.substring(s.indexOf(":\"")+2,s.length()-1);
    }

    public List<String> fetchItemStrings(String line){

        List <String> itemsStings = new LinkedList<>();
        String[] split = line.split("},\\{");
        for (int i = 0; i <split.length ; i++) {
            String curent = split[i];
            if (i==0)split[i] = curent.substring(curent.indexOf("{")+1);
            if (i==split.length-1)split[i] = curent.substring(0, curent.lastIndexOf("}"));
            itemsStings.add(split[i]);
        }


        return itemsStings;
    }

}
