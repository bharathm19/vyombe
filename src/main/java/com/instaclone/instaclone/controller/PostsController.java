package com.instaclone.instaclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instaclone.instaclone.entity.Posts;
import com.instaclone.instaclone.interfaces.IPostsService;
import com.mongodb.lang.NonNull;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostsController {
    
    @Autowired
    IPostsService postsService;

    @PostMapping
    Boolean save(@RequestBody @Valid @NonNull Posts post){
        return postsService.save(post);
    }


}
