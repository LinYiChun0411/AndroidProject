package com.example.superuser.productlistview;

public class Product {

    private long productId;
    private int productImage;
    private String productName;
    private double productPrice;

    public Product(long productId, int productImage, String productName, double productPrice) {
        this.productPrice = productPrice;
        this.productId = productId;
        this.productImage = productImage;
        this.productName = productName;
    }


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "商品名稱:"+ productName + '\''
                +"價格:"+ productPrice;
    }
}
