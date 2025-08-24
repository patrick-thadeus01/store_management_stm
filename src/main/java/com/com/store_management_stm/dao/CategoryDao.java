package com.com.store_management_stm.dao;

import com.com.store_management_stm.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {


}
