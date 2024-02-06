package com.instaclone.instaclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instaclone.instaclone.entity.Users;
import com.instaclone.instaclone.interfaces.IUserService;

import jakarta.validation.Valid;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/signin")
public class UsersController {
    
    @Autowired 
    IUserService userService;

    @PostMapping
    HashMap<String,Boolean> save(@Valid Users user){
        return userService.save(user);
    }
}
