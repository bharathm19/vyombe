package com.instaclone.instaclone.interfaces;

import com.instaclone.instaclone.entity.Posts;

import jakarta.validation.Valid;

public interface IPostsService {
    Boolean save(@Valid Posts post);
}
