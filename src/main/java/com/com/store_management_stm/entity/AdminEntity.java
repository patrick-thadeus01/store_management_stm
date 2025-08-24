package com.com.store_management_stm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "administrator")
public class AdminEntity extends UserEntity {
    @Column(name = "role", length = 255)
    @NotNull
    private String role;
}
