package com.example.AtlAcademy.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "bill")
    private TableEntity tableEntity;

    @OneToMany(mappedBy = "bill")
    private List<Product> products;

    public Bill() {
    }

    public Bill(Long id, TableEntity tableEntity, List<Product> products) {
        this.id = id;
        this.tableEntity = tableEntity;
        this.products = products;
    }
}
