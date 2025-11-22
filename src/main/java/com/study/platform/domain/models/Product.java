package com.study.platform.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {

    private String id;
    private String name;
    private String description;
    private String sku;
    private BigDecimal price;
    private String brand;
    private String model;
    private LocalDateTime createdAt;
    private boolean availability;

    public Product() {
    }

    private Product(String id, String name, String description, String sku,
                    BigDecimal price, String brand, String model, LocalDateTime createdAt, boolean availability) {

        this.id = id;
        this.name = validateName(name);
        this.description = description != null ? description : "";
        this.sku = validateSku(sku);
        this.price = validatePrice(price);
        this.brand = brand != null ? brand : "";
        this.model = model != null ? model : "";
        this.createdAt = createdAt;
        this.availability = availability;
    }

    public static Product create(String name, String sku, BigDecimal price) {

        return new Product(null, name, "", sku, price, "", "", LocalDateTime.now(), false);
    }

    private static String validateName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        return name.trim();
    }

    private static String validateSku(String sku) {

        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }
        return sku.trim();
    }

    private static BigDecimal validatePrice(BigDecimal price) {

        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be null or negative");
        }
        return price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
