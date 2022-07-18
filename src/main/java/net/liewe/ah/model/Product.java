package net.liewe.ah.model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String productName;
    private Double price;
    private String unit;
    private String discount;
    private String imgUrl;
    private String productUrl;

    public Product() {
    }

    public Product(String productName, Double price, String unit, String discount, String imgUrl, String productUrl) {
        this.productName = productName;
        this.price = price;
        this.unit = unit;
        this.discount = discount;
        this.imgUrl = imgUrl;
        this.unit = unit;
        this.productUrl = productUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                " productName='" + productName + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", discount='" + discount + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", productUrl='" + productUrl + '\'' +
                '}';
    }
}
