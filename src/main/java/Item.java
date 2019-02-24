import java.util.Objects;

public class Item {

    int productId;
    int sellerId;
    String productImage;
    String productDetailUrl;
    String productTitle;
    String minPrice;
    String maxPrice;
    String oriMinPrice;
    String oriMaxPrice;
    String discount;
    int promotionId;
    int startTime;
    int endTime;
    int phase;
    String totalStock;
    String stock;
    boolean soldout;
    String orders;
    String shopName;
    String shopUrl;
    String trace;

    public Item(int productId, int sellerId, String productImage, String productDetailUrl,
                String productTitle, String minPrice, String maxPrice, String oriMinPrice,
                String oriMaxPrice, String discount, int promotionId, int startTime, int endTime,
                int phase, String totalStock, String stock, boolean soldout, String orders,
                String shopName, String shopUrl, String trace) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.productImage = productImage;
        this.productDetailUrl = productDetailUrl;
        this.productTitle = productTitle;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.oriMinPrice = oriMinPrice;
        this.oriMaxPrice = oriMaxPrice;
        this.discount = discount;
        this.promotionId = promotionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.phase = phase;
        this.totalStock = totalStock;
        this.stock = stock;
        this.soldout = soldout;
        this.orders = orders;
        this.shopName = shopName;
        this.shopUrl = shopUrl;
        this.trace = trace;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDetailUrl() {
        return productDetailUrl;
    }

    public void setProductDetailUrl(String productDetailUrl) {
        this.productDetailUrl = productDetailUrl;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getOriMinPrice() {
        return oriMinPrice;
    }

    public void setOriMinPrice(String oriMinPrice) {
        this.oriMinPrice = oriMinPrice;
    }

    public String getOriMaxPrice() {
        return oriMaxPrice;
    }

    public void setOriMaxPrice(String oriMaxPrice) {
        this.oriMaxPrice = oriMaxPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public String getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(String totalStock) {
        this.totalStock = totalStock;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public boolean isSoldout() {
        return soldout;
    }

    public void setSoldout(boolean soldout) {
        this.soldout = soldout;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getProductId() == item.getProductId() &&
                getSellerId() == item.getSellerId() &&
                getPromotionId() == item.getPromotionId() &&
                getStartTime() == item.getStartTime() &&
                getEndTime() == item.getEndTime() &&
                getPhase() == item.getPhase() &&
                isSoldout() == item.isSoldout() &&
                getProductImage().equals(item.getProductImage()) &&
                getProductDetailUrl().equals(item.getProductDetailUrl()) &&
                getProductTitle().equals(item.getProductTitle()) &&
                getMinPrice().equals(item.getMinPrice()) &&
                getMaxPrice().equals(item.getMaxPrice()) &&
                getOriMinPrice().equals(item.getOriMinPrice()) &&
                getOriMaxPrice().equals(item.getOriMaxPrice()) &&
                getDiscount().equals(item.getDiscount()) &&
                getTotalStock().equals(item.getTotalStock()) &&
                getStock().equals(item.getStock()) &&
                getOrders().equals(item.getOrders()) &&
                getShopName().equals(item.getShopName()) &&
                getShopUrl().equals(item.getShopUrl()) &&
                getTrace().equals(item.getTrace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getSellerId(),
                getProductImage(), getProductDetailUrl(), getProductTitle(),
                getMinPrice(), getMaxPrice(), getOriMinPrice(), getOriMaxPrice(),
                getDiscount(), getPromotionId(), getStartTime(), getEndTime(), getPhase(),
                getTotalStock(), getStock(), isSoldout(), getOrders(), getShopName(), getShopUrl(), getTrace());
    }

    @Override
    public String toString() {
        return  productId + sellerId + productImage +
                 productDetailUrl +  productTitle +  minPrice + maxPrice + oriMinPrice +
                oriMaxPrice +  discount + promotionId + startTime + endTime + phase +
                 totalStock +  stock + soldout +
                 orders +  shopName + shopUrl +  trace;
    }
}
