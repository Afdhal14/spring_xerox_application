package com.web.xeroxApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Buyer {

    @Id
    private int rollNo;
    private String name;
    private String userName;
    private String password;

    public Buyer(int rollNo, String name, String userName, String password) {
        this.rollNo = rollNo;
        this.name = name;
        this.userName = userName;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
