package com.com.store_management_stm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", length = 255)
    @NotNull
    private String name;


    @Column(name = "product_designation", length = 255)
    @NotNull
    private String designation;

    @Column(name = "price")
    @NotNull
    private double price;

    @Column(name = "quantity")
    @NotNull
    private int qty;

    @ManyToMany
    @JoinTable(name = "product_distributor")
    private List<DistributorEntity> distributorEntities;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<CategoryEntity> categories;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<ProductOrderedEntity> productOrderedEntities;
}
