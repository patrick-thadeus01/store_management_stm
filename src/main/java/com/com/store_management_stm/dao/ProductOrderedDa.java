package com.com.store_management_stm.dao;

import com.com.store_management_stm.entity.ProductOrderedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderedDa extends JpaRepository<ProductOrderedEntity, Long> {

}
