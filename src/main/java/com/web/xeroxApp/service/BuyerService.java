package com.web.xeroxApp.service;

import com.web.xeroxApp.Repository.BuyerRepo;
import com.web.xeroxApp.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepo BRepo;

    public String register(int rollNo, String name, String userName, String password) {
        Buyer buyer = new Buyer(rollNo,name,userName,password);
        BRepo.save(buyer);
        return "Buyer Registered Successfully";
    }
}
