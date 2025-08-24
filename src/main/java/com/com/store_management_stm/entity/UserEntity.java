package com.com.store_management_stm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50)
    @NotNull
    private String name;

    @Column(name = "phone_number",length = 50)
    @NotNull
    private String phone;

    @Column(name = "email",length = 50)
    @NotNull
    private String mail;

    @Column(name = "password",length = 50)
    @NotNull
    private String pwd;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommandEntity> commandEntities;
}
