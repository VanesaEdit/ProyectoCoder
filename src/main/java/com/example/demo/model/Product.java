package com.example.demo.model;

import jakarta.persistence.*;
//Acá vemos la MAGIA de Hibernate.
// Estamos utilizando el ORM, para transformar las tablas en clases de Java.

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String code;
    private double price;
    private int stock;

    //Getters y setters y override methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }


    public boolean description(String description) {
    }

    public boolean code(String code) {
    }

    public boolean stock(int stock) {
    }

    public boolean price(double price) {
    }
}
