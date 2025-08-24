package com.com.store_management_stm.dao;

import com.com.store_management_stm.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByName(String name);
}
