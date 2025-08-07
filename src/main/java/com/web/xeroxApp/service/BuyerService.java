package com.web.xeroxApp.service;

import com.web.xeroxApp.Repository.BuyerRepo;
import com.web.xeroxApp.Repository.UsersRepo;
import com.web.xeroxApp.model.Buyer;
import com.web.xeroxApp.model.Role;
import com.web.xeroxApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepo BRepo;
    @Autowired
    private UsersRepo URepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService JService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String register(int rollNo, String name, String username , String password, Role role)
    {

        Buyer buyer = new Buyer(rollNo,name);
        password = encoder.encode(password);
        Users users = new Users(username,password,role);
        BRepo.save(buyer);
        URepo.save(users);
        return "Buyer Registered Successfully";
    }

    public String verify(Users user) {
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
        {
            Users dbUser = URepo.findByUsername(user.getUsername());
            return JService.generateToken(dbUser);
        }
        else return "Please Register first";
    }
}
