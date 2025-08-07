package com.web.xeroxApp.controller;

import com.web.xeroxApp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService SService;

    @PostMapping("/register")
    public String register(@RequestParam int shopId,@RequestParam String shopName,@RequestParam String shopOwner,
                           @RequestParam LocalTime openingTime,@RequestParam LocalTime closingTime,@RequestParam String phoneNo,
                           @RequestParam boolean isClosed,@RequestParam String userName,@RequestParam String password)
    {
        return SService.register(shopId,shopName,shopOwner,openingTime,closingTime,phoneNo,isClosed,userName,password);
    }
}
