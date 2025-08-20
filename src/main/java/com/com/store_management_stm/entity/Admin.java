package com.com.store_management_stm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "administrator")
public class Admin extends User {

    @Column(name = "role", length = 255)
    @NotNull
    private String role;
}
