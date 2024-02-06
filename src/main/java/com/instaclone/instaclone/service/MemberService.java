package com.instaclone.instaclone.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instaclone.instaclone.Repository.MemberRepository;
import com.instaclone.instaclone.Requests.LoginRequest;
import com.instaclone.instaclone.Requests.UploadRequest;
import com.instaclone.instaclone.entity.Member;
import com.instaclone.instaclone.interfaces.IMemberService;

import jakarta.validation.Valid;

@Service
public class MemberService implements IMemberService{

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Boolean save(@Valid Member member) {
        List<String> usernames = memberRepository.findAll().stream().map(x->x.userName).collect(Collectors.toList());
        if(usernames.contains(member.getUserName())){
            return false;
        }
        ArrayList<HashMap<String,String>> posts = new ArrayList<>();
        member.setPosts(posts);
        memberRepository.save(member);
        return true;
    }

    @Override
    public Member login(@Valid LoginRequest loginRequest) {
        List<Member> allMembers = memberRepository.findAll();
        for (Member member : allMembers) {
            if(member.userName.equals(loginRequest.userName)){
                return member;
            }
        }
        return null;
    }

    @Override
    public Boolean upload(@Valid UploadRequest uploadRequest, String id) {
        Member member = memberRepository.findById(id).get();
        ArrayList posts = member.getPosts();
        HashMap<String,String> post = new HashMap<>();
        post.put("caption", uploadRequest.getCaption());
        post.put("fileLink", uploadRequest.getFileLink());
        posts.add(post);
        member.setPosts(posts);
        memberRepository.save(member);
        return true;
    }
    
}
