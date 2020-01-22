package com.techprimers.security.securitydbexample.service;

import com.techprimers.security.securitydbexample.model.CustomUserDetails;
import com.techprimers.security.securitydbexample.model.Users;
import com.techprimers.security.securitydbexample.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepositoryImpl usersRepository;

    @Autowired
    private CustomUserDetailsService(UserRepositoryImpl userRepositoryImpl) {
        this.usersRepository = userRepositoryImpl;
    }
    //Here is some comments

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<Users> optionalUsers = usersRepository.findByUserName(username);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers.map(CustomUserDetails::new).get();
        
    }
}
