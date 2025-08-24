package com.com.store_management_stm.dao;

import com.com.store_management_stm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    UserEntity  findByName(String name);
}
