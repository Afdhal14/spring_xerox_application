package com.web.xeroxApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Buyer {

    @Id
    private int rollNo;
    private String name;
    private String username;

    public Buyer(int rollNo, String name,String username) {
        this.rollNo = rollNo;
        this.name = name;
        this.username = username;
    }

    public Buyer() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
