package com.example.AtlAcademy.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@jakarta.persistence.Table(name = "productos")
@ToString
@EqualsAndHashCode
public class Product {
    @Getter
    @Setter
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "image")
    private String image;
    @Getter @Setter @Column(name = "price", columnDefinition = "DECIMAL(10,2)")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public Product(){

    }
    public Product(String name, Double price, String image, Bill bill) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.bill = bill;
    }
}
