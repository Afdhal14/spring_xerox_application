package com.web.xeroxApp.model;

import jakarta.persistence.*;

@Entity
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int shopId;
    private int rollNo;
    @Lob
    private byte[] pdfData;
    private int copies;
    private boolean colour;
    private boolean frontAndBack;
    private boolean binding;
    private boolean payed;
    private boolean printed;
    private int cost;

    public OrderList(int shopId, int rollNo,
                     byte[] pdfData, int copies, boolean colour,
                     boolean frontAndBack, boolean binding, boolean payed, boolean printed , int cost) {
        this.shopId = shopId;
        this.rollNo = rollNo;
        this.pdfData = pdfData;
        this.copies = copies;
        this.colour = colour;
        this.frontAndBack = frontAndBack;
        this.binding = binding;
        this.payed = payed;
        this.printed = printed;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public byte[] getPdfData() {
        return pdfData;
    }

    public void setPdfData(byte[] pdfData) {
        this.pdfData = pdfData;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public boolean isColour() {
        return colour;
    }

    public void setColour(boolean colour) {
        this.colour = colour;
    }

    public boolean isFrontAndBack() {
        return frontAndBack;
    }

    public void setFrontAndBack(boolean frontAndBack) {
        this.frontAndBack = frontAndBack;
    }

    public boolean isBinding() {
        return binding;
    }

    public void setBinding(boolean binding) {
        this.binding = binding;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }
}
