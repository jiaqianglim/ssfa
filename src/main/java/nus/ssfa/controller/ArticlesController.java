package nus.ssfa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import nus.ssfa.model.Article;
import nus.ssfa.service.NewsService;

@Controller
@RequestMapping("/articles")
public class ArticlesController {
    
    @Autowired NewsService newsService;

    @PostMapping(consumes = "", produces = "text/html")
    public String returnNews(@RequestBody List<Article> news, Model model){
        newsService.saveArticles(news);
        news = newsService.getAll();
        model.addAttribute("news", news);
        return "index";
    }

}
