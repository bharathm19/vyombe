package com.instaclone.instaclone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

@Entity
public class Member {
    @Id
    public String id;
    public String fullName;
    public String email;
    public String userName;
    public String password;
    public long lastUpdated;
    public ArrayList<String> followers = new ArrayList<>();
    public ArrayList<HashMap<String,String>> posts = new ArrayList<>();

    public long getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<String> getFollowers() {
        return followers;
    }
    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }
    public ArrayList<HashMap<String, String>> getPosts() {
        return posts;
    }
    public void setPosts(ArrayList<HashMap<String, String>> posts) {
        this.posts = posts;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }    
}
