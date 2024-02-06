package com.instaclone.instaclone.Repository;

import org.springframework.stereotype.Repository;

import com.instaclone.instaclone.entity.Posts;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PostsRepository extends MongoRepository<Posts,String>{
  
}
