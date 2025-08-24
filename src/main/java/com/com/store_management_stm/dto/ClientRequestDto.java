package com.com.store_management_stm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

    private String name;
    private String phone;
    private String email;
    private String client_num;
    private String pwd;
}
