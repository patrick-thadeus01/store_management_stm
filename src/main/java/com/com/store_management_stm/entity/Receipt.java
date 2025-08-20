package com.com.store_management_stm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name = "amount")
    private double amount;

    @OneToOne(mappedBy = "receipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private Command command;
}
