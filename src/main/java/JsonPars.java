import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class JsonPars {

    public List item_List = new LinkedList();


    public List getItemJeson(String response){


        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("gpsProductDetails");

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject aJson_Item = (JSONObject)jsonArray.get(i);

            item_List.add(new Item(

        aJson_Item.getInt("productId"),
        aJson_Item.getInt("sellerId"),
        aJson_Item.getString("productImage"),
        aJson_Item.getString("productDetailUrl"),
        aJson_Item.getString("productTitle"),
        aJson_Item.getString("minPrice"),
        aJson_Item.getString("maxPrice"),
        aJson_Item.getString("oriMinPrice"),
        aJson_Item.getString("oriMaxPrice"),
        aJson_Item.getString("discount"),
        aJson_Item.getInt("promotionId"),
        aJson_Item.getInt("startTime"),
        aJson_Item.getInt("endTime"),
        aJson_Item.getInt("phase"),
        aJson_Item.getString("totalStock"),
        aJson_Item.getString("stock"),
        aJson_Item.getBoolean("soldout"),
        aJson_Item.getString("orders"),
        aJson_Item.getString("shopName"),
        aJson_Item.getString("shopUrl"),
        aJson_Item.getString("trace")
        ));
        }

        return item_List;
    }
}
