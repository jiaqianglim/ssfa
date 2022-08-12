package nus.ssfa.utilities;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.MediaType;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import nus.ssfa.model.Article;

@Component
public class utilities {
    
    public List<Article> getListofArticles(){

        Map<String, String> env = System.getenv();
        String api_key = env.get("crypto_api");
        String websiteurl = "min-api.cryptocompare.com/data/v2/news/";
        
        String url = UriComponentsBuilder
        .fromUriString(websiteurl)
        .queryParam("api_key", api_key)
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

    public List<Article> getListOfArticlesLocal(){
        Article article1 = new Article("27933722", 1660256682, "Taiwan Turns to Ethereum IPFS Tech to Thwart Chinese Cyberattacks", "https://decrypt.co/107293/taiwan-turns-to-ipfs-tech-to-thwart-cyberattacks-from-china", "https://images.cryptocompare.com/news/default/decrypt.png", "As tensions with China heat up, Taipei officials leverage decentralized publishing and storage to stay online.", "ETH|Technology","Asia|ETH|Technology");
        Article article2 = new Article("27933722", 1660256682, "Taiwan Turns to Ethereum IPFS Tech to Thwart Chinese Cyberattacks", "https://decrypt.co/107293/taiwan-turns-to-ipfs-tech-to-thwart-cyberattacks-from-china", "https://images.cryptocompare.com/news/default/decrypt.png", "As tensions with China heat up, Taipei officials leverage decentralized publishing and storage to stay online.", "ETH|Technology","Asia|ETH|Technology");
        List<Article> news = new LinkedList<>();
        news.add(article1);
        news.add(article2);
        return news;
    }
}
