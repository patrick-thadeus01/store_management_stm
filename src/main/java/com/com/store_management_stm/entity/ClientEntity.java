package com.com.store_management_stm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "client")

public class ClientEntity extends UserEntity {

    @Column(name = "client_number")
    @NotNull
    @Size(min = 11, max = 11)
    private String client_num;
}
