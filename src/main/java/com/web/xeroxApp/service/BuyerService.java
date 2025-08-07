package com.web.xeroxApp.service;

import com.web.xeroxApp.Repository.BuyerRepo;
import com.web.xeroxApp.Repository.UsersRepo;
import com.web.xeroxApp.model.Buyer;
import com.web.xeroxApp.model.Role;
import com.web.xeroxApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepo BRepo;
    @Autowired
    private UsersRepo URepo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String register(int rollNo, String name, String username , String password, Role role)
    {

        Buyer buyer = new Buyer(rollNo,name);
        password = encoder.encode(password);
        Users users = new Users(username,password,role);
        BRepo.save(buyer);
        URepo.save(users);
        return "Buyer Registered Successfully";
    }
}
