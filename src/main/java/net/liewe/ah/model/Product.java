package net.liewe.ah.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Product.class)
@Table
public class Product implements Serializable {
    @Id
    private String productName;
    private Double price;
    @Id
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
