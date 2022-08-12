package nus.ssfa.model;

import java.math.BigDecimal;

import jakarta.json.JsonObject;

public class Article {
    private String id;
    private int published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;
    private boolean save=false;

    public Article(){
    }

    public Article(String id, int published_on, String title, String url, String imageurl, String body, String tags, String categories){
        this.id = id;
        this.published_on = published_on;
        this.title = title;
        this.url = url;
        this.imageurl = imageurl;
        this.body = body;
        this.tags = tags;
        this.categories = categories;
    }

    public static Article createArticleFromJson(JsonObject o){
        Article article = new Article();
        article.id = o.getJsonString("id").toString();
        article.published_on = o.getJsonNumber("published_on").bigDecimalValue().intValue();
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


    public int getPublished_on() {
        return published_on;
    }


    public void setPublished_on(int published_on) {
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

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    
}
