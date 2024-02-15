package com.instaclone.instaclone.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.instaclone.instaclone.Requests.FollowRequest;
import com.instaclone.instaclone.Requests.LoginRequest;
import com.instaclone.instaclone.Requests.PostRequest;
import com.instaclone.instaclone.Requests.UploadRequest;
import com.instaclone.instaclone.entity.Member;
import com.instaclone.instaclone.interfaces.IMemberService;
import com.mongodb.lang.NonNull;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping()
public class MemberController {

    @Autowired
    IMemberService memberService;

    @PostMapping("/signup")
    Boolean save(@Valid @RequestBody @NonNull Member member){
        return memberService.save(member);
    }

    @PostMapping("/login")
    Member login(@Valid @RequestBody @NonNull LoginRequest loginRequest){
        return memberService.login(loginRequest);
    }

    @PutMapping("/{id}/upload")
    Boolean upload(@PathVariable String id,@Valid @RequestBody UploadRequest uploadRequest){
        return memberService.upload(uploadRequest,id);
    }

    @GetMapping("/{id}/getposts")
    ArrayList<HashMap<String,String>> getPosts(@PathVariable String id){
        return memberService.getPosts(id);
    }

    @GetMapping("/{id}/getusers")
    List<Member> getUsers(@PathVariable String id){
        return memberService.getUsers(id);
    }

    @PutMapping("/{id}/followrequest")
    Boolean followRequest(@RequestBody @Valid FollowRequest followRequest, @PathVariable String id){
        return memberService.followRequest(followRequest,id);
    }
}
