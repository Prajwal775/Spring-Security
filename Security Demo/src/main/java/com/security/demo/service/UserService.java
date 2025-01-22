package com.security.demo.service;

import com.security.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> userList=new ArrayList<>();

    public UserService() {
        userList.add(new User(UUID.randomUUID().toString(),"Piyush Bharti","piyushsays123@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(),"Prajwal Bharti","prajwal3@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(),"Rohan","rohansays123@gmail.com"));

    }

    public List<User> getUsers() {
        return this.userList;
    }
}
