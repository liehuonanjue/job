package com.entity;

import java.io.Serializable;


public class Product implements Serializable {
    private Integer id;     //商品id
    private String productName;        //商品名称
    private Integer quantity;        //商品库存

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
