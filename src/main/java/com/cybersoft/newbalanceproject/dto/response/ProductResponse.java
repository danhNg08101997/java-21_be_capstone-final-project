package com.cybersoft.newbalanceproject.dto.response;

import com.cybersoft.newbalanceproject.entity.CategoryEntity;

public class ProductResponse {
    private int productId;
    private String product_name;
    private String product_desc;
    private CategoryEntity category;

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

    public void setCategoryId(CategoryEntity category) {
        this.category = category;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public String getProduct_name() {
        return product_name;
    }

    public CategoryEntity getCategory() {
        return category;
    }
}
