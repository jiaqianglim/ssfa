package nus.ssfa.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import jakarta.json.JsonObject;

public class Article {
    private String id;
    private String published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;

    public static Article createArticleFromJson(JsonObject o){
        Article article = new Article();
        article.id = o.getJsonString("id").toString();
        article.published_on = o.getJsonString("published_on").toString();
        article.title = o.getJsonString("title").toString();
        article.url = o.getJsonString("url").toString();
        article.imageurl = o.getJsonString("imageurl").toString();
        article.body = o.getJsonString("body").toString();
        article.tags = o.getJsonString("tags").toString();
        article.categories = o.getJsonString("categories").toString();
        return article;
    }
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getPublished_on() {
        return published_on;
    }


    public void setPublished_on(String published_on) {
        this.published_on = published_on;
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


    public String getImageurl() {
        return imageurl;
    }


    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }


    public String getTags() {
        return tags;
    }


    public void setTags(String tags) {
        this.tags = tags;
    }


    public String getCategories() {
        return categories;
    }


    public void setCategories(String categories) {
        this.categories = categories;
    }
}
