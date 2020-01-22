package com.techprimers.security.securitydbexample.repository;

import com.techprimers.security.securitydbexample.model.Users;
import java.util.Optional;

public interface UsersRepository {
    Optional<Users> findByUserName(String username);
}
