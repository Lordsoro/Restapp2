package com.example.AtlAcademy.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@jakarta.persistence.Table(name = "mesas")
@ToString
@EqualsAndHashCode
public class TableEntity {
    @Getter
    @Setter
    @Column(name = "id")
    @Id
    private Long id;

    @Getter @Setter @Column(name = "clients")
    private Integer clients;
    @Getter @Setter @Column(name = "products")
    private List<Product> products;
    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public TableEntity(){}

    public TableEntity(Long id,Integer clients, Bill bill, List<Product> products) {
        this.id = id;
        this.clients = clients;
        this.bill = bill;
        this.products = products;
    }
}
