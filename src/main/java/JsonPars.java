import org.json.JSONObject;

public class JsonPars {
    public Item getItemJeson(String response){

        JSONObject jsonObject = new JSONObject(response);

        int productId = jsonObject.getInt("productId");
        int sellerId = jsonObject.getInt("sellerId");
        String productImage = jsonObject.getString("productImage");
        String productDetailUrl = jsonObject.getString("productDetailUrl");
        String productTitle = jsonObject.getString("productTitle");
        String minPrice = jsonObject.getString("minPrice");
        String maxPrice = jsonObject.getString("maxPrice");
        String oriMinPrice = jsonObject.getString("oriMinPrice");
        String oriMaxPrice = jsonObject.getString("oriMaxPrice");
        String discount = jsonObject.getString("discount");
        int promotionId = jsonObject.getInt("promotionId");
        int startTime = jsonObject.getInt("startTime");
        int endTime = jsonObject.getInt("endTime");
        int phase = jsonObject.getInt("phase");
        String totalStock = jsonObject.getString("totalStock");
        String stock = jsonObject.getString("stock");
        boolean soldout = jsonObject.getBoolean("soldout");
        String orders = jsonObject.getString("orders");
        String shopName = jsonObject.getString("shopName");
        String shopUrl = jsonObject.getString("shopUrl");
        String trace = jsonObject.getString("trace");

        return new Item(productId,sellerId,productImage,productDetailUrl,productTitle,minPrice,maxPrice,oriMinPrice,
                oriMaxPrice,discount,promotionId,startTime,endTime,phase,totalStock,stock,soldout,orders,
                shopName,shopUrl,trace);
    }
}
