package com.web.xeroxApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopId;
    private String shopName;
    private String shopOwner;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String phoneNo;
    private boolean isClosed;
    private String username;
    private int colourCost;
    private int singleSideCost;
    private int frontAndBackCost;
    private int bindingCost;


    public Seller(String shopName, String shopOwner,
                  LocalTime openingTime, LocalTime closingTime, String phoneNo,
                  boolean isClosed,String username)
    {
        this.shopName = shopName;
        this.shopOwner = shopOwner;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.phoneNo = phoneNo;
        this.isClosed = isClosed;
        this.username = username;
        this.colourCost = 10;
        this.singleSideCost = 1;
        this.frontAndBackCost = 2;
        this.bindingCost = 50;
    }

    public Seller() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public int getColourCost() {
        return colourCost;
    }

    public void setColourCost(int colourCost) {
        this.colourCost = colourCost;
    }

    public int getSingleSideCost() {
        return singleSideCost;
    }

    public void setSingleSideCost(int singleSideCost) {
        this.singleSideCost = singleSideCost;
    }

    public int getFrontAndBackCost() {
        return frontAndBackCost;
    }

    public void setFrontAndBackCost(int frontAndBackCost) {
        this.frontAndBackCost = frontAndBackCost;
    }

    public int getBindingCost() {
        return bindingCost;
    }

    public void setBindingCost(int bindingCost) {
        this.bindingCost = bindingCost;
    }
}
