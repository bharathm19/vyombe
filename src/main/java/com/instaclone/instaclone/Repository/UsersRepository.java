package com.instaclone.instaclone.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.instaclone.instaclone.entity.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users,String>{

    
}
