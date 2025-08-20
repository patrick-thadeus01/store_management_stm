package com.com.store_management_stm.repository;

import com.com.store_management_stm.entity.ProductOrdered;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductOrderedRepository extends JpaRepository<ProductOrdered, Long> {

}
