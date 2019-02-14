package com.umbrella.shop.armsmerchant.product_manage.model;
/**
 * @program: com.umbrella.armsmerchant.product_manage.model
 * @description:
 * @author: liujinghui
 * @create: 2018-11-18 21:11
 **/
public class DefaultProductVO {

    private long productId;
    private double originalPrice;
    private String productTitle;
    private String productImg;
    private int stockCount;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "productId=" + productId +
                ", originalPrice=" + originalPrice +
                ", productTitle='" + productTitle + '\'' +
                ", productImg='" + productImg + '\'' +
                ", stockCount=" + stockCount +
                '}';
    }
}
