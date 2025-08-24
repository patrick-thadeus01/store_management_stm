package com.com.store_management_stm.service;

import com.com.store_management_stm.dao.UserDao;
import com.com.store_management_stm.dto.UserRequestDto;
import com.com.store_management_stm.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import com.com.store_management_stm.dto.UserRequestDto;
import com.com.store_management_stm.dto.UserResponseDto;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        UserEntity userEntity = modelMapper.map(userRequestDto, UserEntity.class);
        UserEntity saved = userDao.save(userEntity);
        return modelMapper.map(saved, UserResponseDto.class);
    }

    @Override
    public UserResponseDto findById(long id) {
        UserEntity userEntity = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(userEntity, UserResponseDto.class);
    }

    @Override
    public UserResponseDto findByName(String name) {
        UserEntity userEntity = userDao.findByName(name);
        return modelMapper.map(userEntity, UserResponseDto.class);
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public UserResponseDto update(long id, UserRequestDto userRequestDto) {
 
        Optional<UserEntity> optionalUser = userDao.findById(id);
        if (!optionalUser.isPresent()) {
            UserEntity userEntity = modelMapper.map(userRequestDto, UserEntity.class);
            userEntity.setId(id);
            UserEntity  update = userDao.save(userEntity);
            return modelMapper.map(update, UserResponseDto.class);
        }
        else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<UserResponseDto> findAll() {
        List<UserEntity> users = userDao.findAll();
        return users.stream()
                .map(el -> modelMapper.map(el, UserResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public long countUsers() {
        return userDao.count();
    }

}
