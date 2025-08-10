package com.web.xeroxApp.service;

import com.web.xeroxApp.Repository.BuyerRepo;
import com.web.xeroxApp.Repository.OrderListRepo;
import com.web.xeroxApp.Repository.SellerRepo;
import com.web.xeroxApp.Repository.UsersRepo;
import com.web.xeroxApp.model.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepo BRepo;

    @Autowired
    private UsersRepo URepo;

    @Autowired
    private SellerRepo SRepo;

    @Autowired
    private OrderListRepo ORepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService JService;

    @Autowired
    private HttpServletRequest request;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String register(int rollNo, String name, String username , String password, Role role)
    {

        Buyer buyer = new Buyer(rollNo,name,username);
        password = encoder.encode(password);
        Users users = new Users(username,password,role);
        BRepo.save(buyer);
        URepo.save(users);
        return "Buyer Registered Successfully";
    }

    public String verify(Users user)
    {
        try
        {
            Authentication authentication = authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            if (authentication.isAuthenticated())
            {
                Users dbUser = URepo.findByUsername(user.getUsername());

                if (dbUser.getRole() != user.getRole())
                    return "Access Denied.";

                return JService.generateToken(dbUser);
            }
            else
            {
                return "Invalid username or password";
            }
        }
        catch(Exception e)
        {
            return "Invalid username or password";
        }
    }

    public String extractToken() {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if(authHeader != null && authHeader.startsWith("Bearer "))
        {
            token = authHeader.substring(7);
            username = JService.extractUsername(token);
        }
        return username;
    }

    public int findRollNo(String username) {
        Buyer buyer = BRepo.findByUsername(username);
        return buyer.getRollNo();
    }

    public String order(int shopId, int rollNo, byte[] pdfData, int copies,
                        boolean colour, boolean frontAndBack, boolean binding,int noOfPages) {
        Seller seller = SRepo.findByShopId(shopId);
        int cost = calculateCost(seller,noOfPages,copies,colour,frontAndBack,binding);
        OrderList orderList = new OrderList(shopId,rollNo,pdfData,copies,colour,frontAndBack,binding,false,false,cost);
        ORepo.save(orderList);
        return String.valueOf(cost);
    }

    private int calculateCost(Seller seller,int noOfPages, int copies, boolean colour, boolean frontAndBack, boolean binding) {

        int cost = noOfPages*copies;
        if(colour) cost *= seller.getColourCost();
        if(frontAndBack) cost *= seller.getFrontAndBackCost();
        else cost *= seller.getSingleSideCost();
        if(binding) cost += seller.getBindingCost();
        return cost;
    }

    public int calculatePages(MultipartFile file)
    {
        try(PDDocument document = PDDocument.load(file.getInputStream())){
            return document.getNumberOfPages();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<OrderList> orderList(int rollNo) {
        return ORepo.findByRollNo(rollNo);
    }

    public boolean checkShopClosed(int shopId) {
        Seller seller = SRepo.findByShopId(shopId);
        return seller.isClosed();
    }
}
