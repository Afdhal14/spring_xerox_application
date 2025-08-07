package com.web.xeroxApp.service;

import com.web.xeroxApp.Repository.SellerRepo;
import com.web.xeroxApp.Repository.UsersRepo;
import com.web.xeroxApp.model.Role;
import com.web.xeroxApp.model.Seller;
import com.web.xeroxApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SellerService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private SellerRepo SRepo;

    @Autowired
    private UsersRepo URepo;

    public String register(String shopName, String shopOwner,
                           LocalTime openingTime, LocalTime closingTime, String phoneNo,
                           boolean isClosed,String username ,String password , Role role) {

        Seller seller = new Seller(shopName,shopOwner,openingTime,closingTime,phoneNo,isClosed);
        password = encoder.encode(password);
        Users users = new Users(username,password,role);
        SRepo.save(seller);
        URepo.save(users);
        return "Seller Registered Successfully";
    }
}
