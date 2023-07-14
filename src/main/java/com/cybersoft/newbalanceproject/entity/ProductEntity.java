package com.cybersoft.newbalanceproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_des")
    private String productDesc;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "listImage")
    private String listImage;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorEntity color;
    @ManyToOne
    @JoinColumn(name = "fit_id")
    private FitEntity fit;
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private GenderEntity gender;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;
    @ManyToOne
    @JoinColumn(name = "productType_id")
    private ProductTypeEntity productType;
    @ManyToOne
    @JoinColumn(name = "size_id")
    private SizeEntity size;
    @ManyToOne
    @JoinColumn(name = "tech_id")
    private TechnologyEntity tech;
    @ManyToOne
    @JoinColumn(name = "width_id")
    private WidthEntity width;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<ProductCartEntity> productCarts;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getListImage() {
        return listImage;
    }

    public void setListImage(String listImage) {
        this.listImage = listImage;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    public FitEntity getFit() {
        return fit;
    }

    public void setFit(FitEntity fit) {
        this.fit = fit;
    }

    public GenderEntity getGender() {
        return gender;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public ProductTypeEntity getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeEntity productType) {
        this.productType = productType;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }

    public TechnologyEntity getTech() {
        return tech;
    }

    public void setTech(TechnologyEntity tech) {
        this.tech = tech;
    }

    public WidthEntity getWidth() {
        return width;
    }

    public void setWidth(WidthEntity width) {
        this.width = width;
    }

    public Set<ProductCartEntity> getProductCarts() {
        return productCarts;
    }

    public void setProductCarts(Set<ProductCartEntity> productCarts) {
        this.productCarts = productCarts;
    }
}
