package com.com.store_management_stm.service;

import java.util.List;

import com.com.store_management_stm.dto.UserRequestDto;
import com.com.store_management_stm.dto.UserResponseDto;

public interface UserService {

    UserResponseDto save(UserRequestDto userRequestDto);
    UserResponseDto findById(long id);
    UserResponseDto findByName(String name);
    void deleteById(long id);
    UserResponseDto update(long id, UserRequestDto userRequestDto);
    List<UserResponseDto> findAll();
    long countUsers();
}
