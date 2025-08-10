package com.web.xeroxApp.controller;

import com.web.xeroxApp.model.OrderList;
import com.web.xeroxApp.model.Users;
import com.web.xeroxApp.service.BuyerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @GetMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password)
    {
        Users user = new Users(username,password,BUYER);
        return BService.verify(user);
    }

    @GetMapping("/placeOrder")
    public String order(@RequestParam int shopId,@RequestParam MultipartFile file,
                        @RequestParam int copies,@RequestParam boolean colour,
                        @RequestParam boolean frontAndBack,@RequestParam boolean binding)
    {
        if(BService.checkShopClosed(shopId))
        {
            return "Shop Currently closed";
        }
        else
        {
            byte[] pdfData;
            try {
                pdfData = file.getBytes();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String username = BService.extractToken();
            int rollNo = BService.findRollNo(username);
            int noOfPages = BService.calculatePages(file);
            return BService.order(shopId, rollNo, pdfData, copies, colour,
                    frontAndBack, binding, noOfPages);
        }
    }

    @GetMapping("/orderList")
    public List<OrderList> orderList()
    {
        String username = BService.extractToken();
        int rollNo = BService.findRollNo(username);
        return BService.orderList(rollNo);
    }
}
