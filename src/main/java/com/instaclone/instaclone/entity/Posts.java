package com.instaclone.instaclone.entity;

import javax.persistence.Entity;

@Entity
public class Posts {
    public String id;
    public String mediaLink;
    public String caption;
    public String userName;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMediaLink() {
        return mediaLink;
    }
    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
}
