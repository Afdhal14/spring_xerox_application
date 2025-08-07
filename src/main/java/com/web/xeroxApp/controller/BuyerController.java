package com.web.xeroxApp.controller;

import com.web.xeroxApp.model.Buyer;
import com.web.xeroxApp.model.Role;
import com.web.xeroxApp.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.web.xeroxApp.model.Role.BUYER;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService BService;

    @PostMapping("/register")
    public String register(@RequestParam int rollNo,@RequestParam String name,
                           @RequestParam String username,@RequestParam String password)
    {
        return BService.register(rollNo,name,username,password, BUYER);
    }
}
