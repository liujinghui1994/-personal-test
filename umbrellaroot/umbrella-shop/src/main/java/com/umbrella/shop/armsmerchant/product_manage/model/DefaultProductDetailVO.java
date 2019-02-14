package com.umbrella.shop.armsmerchant.product_manage.model;
/**
 * @program: com.umbrella.armsmerchant.product_manage.model
 * @description:
 * @author: liujinghui
 * @create: 2018-11-18 21:19
 **/
public class DefaultProductDetailVO extends DefaultProductVO{
    private String productName;
    private String productDescription;
    private String saleNum;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(String saleNum) {
        this.saleNum = saleNum;
    }

    @Override
    public String toString() {
        return  super.toString() + "DefaultProductDetailVO{" +
                "productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", saleNum='" + saleNum + '\'' +
                "} ";
    }
}
