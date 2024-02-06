package com.instaclone.instaclone.Repository;

import org.springframework.stereotype.Repository;

import com.instaclone.instaclone.entity.Member;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface MemberRepository extends MongoRepository<Member,String>{

}
