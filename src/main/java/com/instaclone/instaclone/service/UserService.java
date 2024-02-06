package com.instaclone.instaclone.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instaclone.instaclone.Repository.UsersRepository;
import com.instaclone.instaclone.entity.Users;
import com.instaclone.instaclone.interfaces.IUserService;

import jakarta.validation.Valid;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired UsersRepository usersRepository;

    @Override
    public HashMap<String, Boolean> save(@Valid Users user) {
        HashMap<String,Boolean> Response = new HashMap<>();
        usersRepository.save(user);

        return Response;
    }
    
}
