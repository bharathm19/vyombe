package com.instaclone.instaclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instaclone.instaclone.Repository.PostsRepository;
import com.instaclone.instaclone.entity.Posts;
import com.instaclone.instaclone.interfaces.IPostsService;

import jakarta.validation.Valid;

@Service
public class PostsService implements IPostsService{

    @Autowired
    PostsRepository postsRepository;

    @Override
    public Boolean save(@Valid Posts post) {
        postsRepository.save(post);
        return true;
    }
    
}
