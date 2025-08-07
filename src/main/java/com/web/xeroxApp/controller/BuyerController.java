package com.web.xeroxApp.controller;

import com.web.xeroxApp.model.Buyer;
import com.web.xeroxApp.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService BService;

    @PostMapping("/register")
    public String register(@RequestBody Buyer buyer)
    {
        return BService.register(buyer);
    }
}
