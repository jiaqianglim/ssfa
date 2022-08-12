package nus.ssfa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import nus.ssfa.model.Article;
import nus.ssfa.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/news")
public class NewsRESTController {

    @Autowired NewsService newsService;
    
    @GetMapping(path="{id}",consumes="application/json", produces="application/json")
    public ResponseEntity<String> getArticleById(@PathVariable String id) {
        JsonObject body;
        Article article = newsService.findById(id);
        if(id==null){
            String errormessage = "\"Error\" : \"Cannot find news article %s\"".formatted(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errormessage);
        }
        return ResponseEntity.ok().body(article.toString());
    }
    
}
