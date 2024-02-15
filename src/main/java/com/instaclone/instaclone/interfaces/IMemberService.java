package com.instaclone.instaclone.interfaces;

import java.util.*;

import com.instaclone.instaclone.Requests.FollowRequest;
import com.instaclone.instaclone.Requests.LoginRequest;
import com.instaclone.instaclone.Requests.PostRequest;
import com.instaclone.instaclone.Requests.UploadRequest;
import com.instaclone.instaclone.entity.Member;

import jakarta.validation.Valid;

public interface IMemberService {
    Boolean save(@Valid Member member);
    Member login(@Valid LoginRequest loginRequest);
    Boolean upload(@Valid UploadRequest uploadRequest, String id);
    ArrayList<HashMap<String,String>> getPosts(String id);
    List<Member> getUsers(String id);
    Boolean followRequest(@Valid FollowRequest followRequest, String id);
}

