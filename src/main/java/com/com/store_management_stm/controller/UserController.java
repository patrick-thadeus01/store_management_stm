package com.com.store_management_stm.controller;


import com.com.store_management_stm.dto.UserRequestDto;
import com.com.store_management_stm.dto.UserRequestDto;
import com.com.store_management_stm.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.com.store_management_stm.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/searchAll/")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> save( UserRequestDto userRequestDto){

        UserResponseDto userResponseDto = userService.save(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable long id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<UserResponseDto> findByName(@PathVariable String name) {
        UserResponseDto userResponseDto = userService.findByName(name);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDto> update(@PathVariable long id, @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.update(id, userRequestDto);
        return ResponseEntity.accepted().body(userResponseDto);
    }

    // @GetMapping("/count")
    // public ResponseEntity<Long> countUsers(){
    //     long userResponseDto = userService.countUsers();
    //     return ResponseEntity.ok(userResponseDto);
    // }

}
