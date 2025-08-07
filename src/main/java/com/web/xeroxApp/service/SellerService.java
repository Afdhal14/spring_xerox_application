package com.web.xeroxApp.service;

import com.web.xeroxApp.Repository.SellerRepo;
import com.web.xeroxApp.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SellerService {

    @Autowired
    private SellerRepo SRepo;

    public String register(Seller seller) {
        SRepo.save(seller);
        return "Seller Registered Successfully";
    }
}
