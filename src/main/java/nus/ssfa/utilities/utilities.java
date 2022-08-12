package nus.ssfa.utilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import nus.ssfa.model.Article;

@Component
public class utilities {
    
    public List<Article> getListofArticles(){

        final String apikey = "0d4421fe3733298386f01ba6def48d8a1bbebadb0baff5cc1884449200632f54";

        String websiteurl = "min-api.cryptocompare.com/data/v2/news/";
        
        String url = UriComponentsBuilder
        .fromUriString(websiteurl)
        .queryParam("api_key", apikey)
        .toUriString();

        RequestEntity req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);

        List<Article> news = new LinkedList<>();

        try (InputStream in = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(in);
            JsonObject data = reader.readObject();
            JsonArray articleList = data.getJsonArray("Data");
            for(int i =0; i < articleList.size(); i++){
                JsonObject o = articleList.getJsonObject(i);
                Article article = Article.createArticleFromJson(o);
                news.add(article);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return news;
    }
}
