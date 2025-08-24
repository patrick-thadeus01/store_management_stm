package com.com.store_management_stm.service;

import com.com.store_management_stm.dto.ClientRequestDto;
import com.com.store_management_stm.dto.ClientResponseDto;
import com.com.store_management_stm.dto.UserResponseDto;

import java.util.List;

public interface ClientService {

    ClientResponseDto save(ClientRequestDto clientRequestDto);
    ClientResponseDto findById(long id);
    ClientResponseDto findByName(String name);
    void delete(long id);
    ClientResponseDto update(long id, ClientRequestDto clientRequestDto);
    List<ClientResponseDto> findAll();
}
