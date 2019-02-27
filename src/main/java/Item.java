import java.util.Objects;

public class Item {
    public Item() {
    }

    private long productId;
    private long sellerId;
    private String productImage;
    private String productDetailUrl;
    private String productTitle;
    private String minPrice;
    private String maxPrice;
    private String oriMinPrice;
    private String oriMaxPrice;
    private String discount;
    private long promotionId;
    private long startTime;
    private long endTime;
    private long phase;
    private String totalStock;
    private String stock;
    private boolean soldout;
    private String orders;
    private String shopName;
    private String shopUrl;


    public Item(long productId, long sellerId, String productImage, String productDetailUrl,
                String productTitle, String minPrice, String maxPrice, String oriMinPrice,
                String oriMaxPrice, String discount, long promotionId, long startTime, long endTime,
                long phase, String totalStock, String stock, boolean soldout, String orders,
                String shopName, String shopUrl) {
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

    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
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

    public long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(long promotionId) {
        this.promotionId = promotionId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getPhase() {
        return phase;
    }

    public void setPhase(long phase) {
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
                getShopUrl().equals(item.getShopUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getSellerId(),
                getProductImage(), getProductDetailUrl(), getProductTitle(),
                getMinPrice(), getMaxPrice(), getOriMinPrice(), getOriMaxPrice(),
                getDiscount(), getPromotionId(), getStartTime(), getEndTime(), getPhase(),
                getTotalStock(), getStock(), isSoldout(), getOrders(), getShopName(), getShopUrl());
    }

    @Override
    public String toString() {
        return  productId +", " + sellerId+", " + productImage+", " +
                 productDetailUrl+", " +  productTitle+", " +  minPrice+", " + maxPrice+", " + oriMinPrice+", " +
                oriMaxPrice+", " +  discount+", " + promotionId+", " + startTime+", " + endTime+", " + phase +
                 totalStock+", " +  stock+", " + soldout+", " +
                 orders+", " +  shopName+", " + shopUrl;
    }
}
