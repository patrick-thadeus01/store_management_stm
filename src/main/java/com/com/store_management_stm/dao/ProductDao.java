package com.com.store_management_stm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.com.store_management_stm.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {


}
