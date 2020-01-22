package com.techprimers.security.securitydbexample.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    // public int id;

    public String email;

    public String password;

    public String username;

    public String lastName;
    
    public int active;
    
    public static Users toModel(UserDto dto){
        return new Users(dto);
    }

    // public Set<Role> roles;
}