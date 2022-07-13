package net.liewe.ah.model;

import javax.persistence.*;

@Entity
@Table
public class Subscription {
    @Id
    @SequenceGenerator(
            name = "subscription_sequence",
            sequenceName = "subscription_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subscription_sequence"
    )
    private Long id;
    private String email;
    private String productName;
    private Double price;
    private String unit;
    private String discount;
    private String imgUrl;

    public Subscription() {

    }

    public Subscription(String email, String productName, Double price, String unit, String discount, String imgUrl) {
        this.email = email;
        this.productName = productName;
        this.price = price;
        this.unit = unit;
        this.discount = discount;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", discount='" + discount + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
