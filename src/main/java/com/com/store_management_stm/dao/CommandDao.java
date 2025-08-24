package com.com.store_management_stm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.com.store_management_stm.entity.CommandEntity;

@Repository
public interface CommandDao extends JpaRepository<CommandEntity, Long> {

}
