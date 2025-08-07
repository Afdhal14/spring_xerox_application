package com.web.xeroxApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Buyer {

    @Id
    private int rollNo;
    private String name;

    public Buyer(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public Buyer() {
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
