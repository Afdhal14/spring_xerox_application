package com.web.xeroxApp.controller;

import com.web.xeroxApp.model.Seller;
import com.web.xeroxApp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService SService;

    @PostMapping("/register")
    public String register(@RequestBody Seller seller)
    {
        return SService.register(seller);
    }
}
