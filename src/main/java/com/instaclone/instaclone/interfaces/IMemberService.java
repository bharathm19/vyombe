package com.instaclone.instaclone.interfaces;

import java.util.HashMap;

import com.instaclone.instaclone.Requests.LoginRequest;
import com.instaclone.instaclone.Requests.UploadRequest;
import com.instaclone.instaclone.entity.Member;

import jakarta.validation.Valid;

public interface IMemberService {
    Boolean save(@Valid Member member);
    Member login(@Valid LoginRequest loginRequest);
    Boolean upload(@Valid UploadRequest uploadRequest, String id);
}

