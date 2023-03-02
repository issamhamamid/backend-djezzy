package com.example.issamhamamid.demo.jwtsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authrequest {

    private String username ;
    private String password;
}
