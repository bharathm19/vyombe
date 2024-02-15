package com.instaclone.instaclone.Requests;

public class UploadRequest {
    public String caption;
    public String fileLink;
    public long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

}
