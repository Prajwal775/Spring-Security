package com.security.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class User {

    @Id
    @Column(name="UserId")
    private String uid;
    private String userName;
    private String email;

    public User() {
    }

    public User(String uid, String userName, String email) {
        this.uid = uid;
        this.userName = userName;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
