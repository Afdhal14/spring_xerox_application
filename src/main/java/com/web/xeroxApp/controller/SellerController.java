package com.web.xeroxApp.controller;

import com.web.xeroxApp.model.Seller;
import com.web.xeroxApp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

import static com.web.xeroxApp.model.Role.SELLER;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService SService;

    @PostMapping("/register")
    public String register(@RequestParam String shopName,@RequestParam String shopOwner,
                           @RequestParam LocalTime openingTime,@RequestParam LocalTime closingTime,
                           @RequestParam String phoneNo, @RequestParam boolean isClosed,
                           @RequestParam String username ,@RequestParam String password)
    {
        return SService.register(shopName,shopOwner
                ,openingTime,closingTime,phoneNo
                ,isClosed,username,password,SELLER);
    }
}
