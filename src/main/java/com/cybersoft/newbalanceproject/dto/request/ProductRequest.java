package com.cybersoft.newbalanceproject.dto.request;

public class ProductRequest {
    private int productId ;
    private String product_name;
    private String product_desc;
    private int categoryId;

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
