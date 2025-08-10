package com.web.xeroxApp.Repository;

import com.web.xeroxApp.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository<Seller,Integer> {

    public Seller findByUsername(String username);

    public Seller findByShopId(int shopId);
}
