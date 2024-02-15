package com.instaclone.instaclone.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instaclone.instaclone.Repository.MemberRepository;
import com.instaclone.instaclone.Requests.FollowRequest;
import com.instaclone.instaclone.Requests.LoginRequest;
import com.instaclone.instaclone.Requests.PostRequest;
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
        Date date = new Date();
        member.setLastUpdated(date.getTime());
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
        ArrayList<HashMap<String,String>> posts = member.getPosts();
        HashMap<String,String> post = new HashMap<>();
        Long time = uploadRequest.getDate();
        post.put("caption", uploadRequest.getCaption());
        post.put("fileLink", uploadRequest.getFileLink());
        post.put("date", Long.toString(time));
        post.put("username", member.getUserName());
        posts.add(post);
        member.setPosts(posts);
        memberRepository.save(member);
        return true;
    }

    @Override
    public ArrayList<HashMap<String, String>> getPosts(String id) {
        Member currMember = memberRepository.findById(id).get();
        Long lastUpdated = currMember.getLastUpdated();
        ArrayList<String> followers = currMember.getFollowers();
        ArrayList<HashMap<String,String>> posts = new ArrayList<>();
        for (String follower : followers) {
            @SuppressWarnings("null")
            Member currFollower = memberRepository.findById(follower).get();
            ArrayList<HashMap<String,String>> currPosts = currFollower.getPosts();
            int i = currFollower.getPosts().size()-1;
            Boolean check = true;
            while(i>=0 && check){
                Long postTime = Long.valueOf(currPosts.get(i).get("date"));
                if(lastUpdated.compareTo(postTime)==-1 || lastUpdated.compareTo(postTime)==0){
                    posts.add(currPosts.get(i));
                }else{
                    check=false;
                }
                i-=1;
            }
        }
        Date now = new Date();
        currMember.setLastUpdated(now.getTime());
        memberRepository.save(currMember);
        return posts;
    }

    @Override
    public List<Member> getUsers(String id) {
        List<Member> users = memberRepository.findAll();
        Member currMember = memberRepository.findById(id).get();
        List<Member> notFollowing = new ArrayList<>();
        ArrayList<String> followers = memberRepository.findById(id).get().getFollowers();
        for (Member member : users) {
            if(followers.contains(member.getId()) || member.getId().equals(currMember.getId())){
                continue;
            }else{
                notFollowing.add(member);
            }
        }
        return notFollowing;

    }

    @Override
    public Boolean followRequest(@Valid FollowRequest followRequest, String id) {
        Member currMember = memberRepository.findById(id).get();
        ArrayList<String> followers = currMember.getFollowers();
        if(followers.size()==0){
            followers.add(id);
        }
        followers.add(followRequest.getUserId());
        currMember.setFollowers(followers);
        memberRepository.save(currMember);
        return true;
    }
    
}
