package com.web.xeroxApp.Repository;

import com.web.xeroxApp.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer,Integer> {
}
