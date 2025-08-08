package com.web.xeroxApp.service;

import com.web.xeroxApp.Repository.OrderListRepo;
import com.web.xeroxApp.Repository.SellerRepo;
import com.web.xeroxApp.Repository.UsersRepo;
import com.web.xeroxApp.model.OrderList;
import com.web.xeroxApp.model.Role;
import com.web.xeroxApp.model.Seller;
import com.web.xeroxApp.model.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class SellerService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private SellerRepo SRepo;

    @Autowired
    private UsersRepo URepo;

    @Autowired
    private OrderListRepo ORepo;

    @Autowired
    private JWTService JService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    AuthenticationManager authManager;

    public String register(String shopName, String shopOwner,
                           LocalTime openingTime, LocalTime closingTime, String phoneNo,
                           boolean isClosed,String username ,String password , Role role) {

        Seller seller = new Seller(shopName,shopOwner,openingTime,closingTime,phoneNo,isClosed,username);
        password = encoder.encode(password);
        Users users = new Users(username,password,role);
        SRepo.save(seller);
        URepo.save(users);
        return "Seller Registered Successfully";
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

    public List<OrderList> orderList() {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if(authHeader != null && authHeader.startsWith("Bearer "))
        {
            token = authHeader.substring(7);
            username = JService.extractUsername(token);
        }

        Seller seller = SRepo.findByUsername(username);
        int shopId = seller.getShopId();

        return ORepo.findByShopId(shopId);
    }

    public String takePrint(int orderId) {
        OrderList orderList = ORepo.findByOrderId(orderId);
        orderList.setPrinted(true);
        ORepo.save(orderList);
        return "Print taken";
    }
}
