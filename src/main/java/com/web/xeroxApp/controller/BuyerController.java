package com.web.xeroxApp.controller;

import com.web.xeroxApp.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService BService;

    @PostMapping("/register")
    public String register(@RequestParam int rollNo,@RequestParam String name,
                           @RequestParam String userName,@RequestParam String password)
    {
        return BService.register(rollNo,name,userName,password);
    }
}
