package nus.ssfa.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import nus.ssfa.config.RedisRepository;
import nus.ssfa.model.Article;


@Service
public class NewsService {
    
    @Autowired RedisRepository redisRepository;
    @Autowired RedisTemplate template;
    @Autowired nus.ssfa.utilities.utilities utilities;
    
    public List<Article> getArticles(){
        List<Article> news = utilities.getListofArticles();
        return news;
    }

    public void saveArticles(List<Article> news){
        for(Article article: news){
            template.opsForValue().set(article.getId(), article.toString());
        }
    }

    public Article findById(String Id){
        Article article = (Article)template.opsForValue().get(Id); //TODO
        return article;
    }
}
