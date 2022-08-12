package nus.ssfa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nus.ssfa.model.Article;
import nus.ssfa.service.NewsService;

@Controller
public class NewsController {

    @Autowired NewsService newsService;
    
    @GetMapping(path="/", produces="text/html")
    public String shownews(Model model){
        List<Article> news = newsService.getArticles();
        model.addAttribute("news", news);
        return "index";
    }

}
