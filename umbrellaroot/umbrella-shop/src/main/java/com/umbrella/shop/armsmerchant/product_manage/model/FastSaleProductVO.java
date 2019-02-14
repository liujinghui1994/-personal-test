package com.umbrella.shop.armsmerchant.product_manage.model;

/**
 * @program: com.umbrella.armsmerchant.product_manage.model
 * @description:
 * @author: liujinghui
 * @create: 2018-11-18 21:11
 **/
public class FastSaleProductVO extends DefaultProductVO{
    private double fastSalePrice;
    private Integer fastSaleStockCount;
    private long fastSaleStartTime;
    private long fastSaleEndTime;

    public double getFastSalePrice() {
        return fastSalePrice;
    }

    public void setFastSalePrice(double fastSalePrice) {
        this.fastSalePrice = fastSalePrice;
    }

    public Integer getFastSaleStockCount() {
        return fastSaleStockCount;
    }

    public void setFastSaleStockCount(Integer fastSaleStockCount) {
        this.fastSaleStockCount = fastSaleStockCount;
    }

    public long getFastSaleStartTime() {
        return fastSaleStartTime;
    }

    public void setFastSaleStartTime(long fastSaleStartTime) {
        this.fastSaleStartTime = fastSaleStartTime;
    }

    public long getFastSaleEndTime() {
        return fastSaleEndTime;
    }

    public void setFastSaleEndTime(long fastSaleEndTime) {
        this.fastSaleEndTime = fastSaleEndTime;
    }

    @Override
    public String toString() {
        return super.toString() + "FastSaleProductVO{" +
                "fastSalePrice=" + fastSalePrice +
                ", fastSaleStockCount=" + fastSaleStockCount +
                ", fastSaleStartTime=" + fastSaleStartTime +
                ", fastSaleEndTime=" + fastSaleEndTime +
                "} ";
    }
}
