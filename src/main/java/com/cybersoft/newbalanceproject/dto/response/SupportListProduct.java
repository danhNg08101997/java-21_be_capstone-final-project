package com.cybersoft.newbalanceproject.dto.response;
import java.util.List;
public class SupportListProduct {
    private int id ;
    private String fullname;
    private String SupportName;
    private List<ProductResponse> productSupportList;

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setProductSupportList(List<ProductResponse> productSupportList) {
        this.productSupportList = productSupportList;
    }

    public void setSupportName(String supportName) {
        SupportName = supportName;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public List<ProductResponse> getProductSupportList() {
        return productSupportList;
    }

    public String getSupportName() {
        return SupportName;
    }
}
