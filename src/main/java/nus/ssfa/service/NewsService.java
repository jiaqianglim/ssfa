package nus.ssfa.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import nus.ssfa.model.Article;


@Service
public class NewsService {
    
    @Autowired RedisTemplate template;
    @Autowired nus.ssfa.utilities.utilities utilities;
    
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);

    public List<Article> getArticles(){
        List<Article> news = utilities.getListofArticles();
        return news;
    }

    public void saveArticle(Article article){
        template.opsForValue().set(article.getId(), article.toString());
        Article result = (Article)template.opsForValue().get(article.getId());
        if(result!= null)
            logger.info("%s failed to save", article.getId());
    }

    public Article findById(String Id){
        Article article = (Article)template.opsForValue().get(Id);
        return article;
    }

    public List<Article> getAll(){
        List<Article> news = new LinkedList<>();
        Set<String> allArticles = template.keys("*");
        for(String id: allArticles){
            Article result = (Article) template.opsForValue().get(id);
            news.add(result);
        }

        return news;
    }
}
