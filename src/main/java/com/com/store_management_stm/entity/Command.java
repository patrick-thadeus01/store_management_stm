package com.com.store_management_stm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "command")
@ToString
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 255)
    @NotNull
    private String name;

    @Column(name = "price")
    @NotNull
    private double price;

    @Column(name = "quantity")
    @NotNull
    private int qty;

    @OneToOne()
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductOrdered> productOrdereds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
