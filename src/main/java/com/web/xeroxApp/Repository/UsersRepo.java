package com.web.xeroxApp.Repository;

import com.web.xeroxApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

}
