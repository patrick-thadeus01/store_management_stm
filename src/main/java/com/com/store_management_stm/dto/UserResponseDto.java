package com.com.store_management_stm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    
    private long id;
    private String name;
    private String phone;
    private String email;

}
