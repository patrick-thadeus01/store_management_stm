package com.com.store_management_stm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.com.store_management_stm.entity.Client;
public interface ClientRepository extends JpaRepository<Client, Long> {

}
