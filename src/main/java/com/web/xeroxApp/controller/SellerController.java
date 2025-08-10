package com.web.xeroxApp.controller;

import com.web.xeroxApp.model.OrderList;
import com.web.xeroxApp.model.Users;
import com.web.xeroxApp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

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

    @GetMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password)
    {
        Users user = new Users(username,password,SELLER);
        return SService.verify(user);
    }

    @GetMapping("/orderList")
    public List<OrderList> orderList()
    {
        return SService.orderList();
    }

    @GetMapping("/takePrint")
    public String takePrint(@RequestParam int orderId)
    {
        return SService.takePrint(orderId);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadPDF(@RequestParam int orderId)
    {
        return SService.downloadPDF(orderId);
    }

    @GetMapping("/changeCost")
    public String changeCost(@RequestParam int colourCost,@RequestParam int singleSideCode,
                             @RequestParam int frontAndBackCost,@RequestParam int bindingCost)
    {
        return SService.changeCost(colourCost,singleSideCode,frontAndBackCost,bindingCost);
    }

    @GetMapping("/close")
    public String closeShop()
    {
        return SService.closeShop();
    }

    @GetMapping("/open")
    public String openShop()
    {
        return SService.openShop();
    }
}
