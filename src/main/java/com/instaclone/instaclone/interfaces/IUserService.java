package com.instaclone.instaclone.interfaces;
import java.util.*;

import com.instaclone.instaclone.entity.Users;

import jakarta.validation.Valid;

public interface IUserService {
    HashMap<String,Boolean> save(@Valid Users user);
}
