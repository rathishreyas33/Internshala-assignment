package com.shreyasrathi.internshala;

public class album {
    public String id;
    public String title;
    public String url;
    public  String thumbnailurl;

    public album(){}
    public album(String id,String title,String url,String thumbnailurl){
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailurl= thumbnailurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }
}
