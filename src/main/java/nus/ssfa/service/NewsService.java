package nus.ssfa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);

    public List<Article> getArticles(){
        List<Article> news = utilities.getListOfArticlesLocal();
        return news;
    }

    public void saveArticles(List<Article> news){
        for(Article article: news){
            template.opsForValue().set(article.getId(), article.toString());
            Article result = (Article)template.opsForValue().get(article.getId());
            if(result!= null)
                logger.info("%s failed to save", article.getId());
        }

    }

    public Article findById(String Id){
        Article article = (Article)template.opsForValue().get(Id);
        return article;
    }
}
