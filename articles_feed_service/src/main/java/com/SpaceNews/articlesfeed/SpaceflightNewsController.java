package com.SpaceNews.articlesfeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpaceflightNewsController {

    @Autowired
    private SpaceflightNewsService spaceflightNewsService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/articles")
    public String getArticles(Model model) throws Exception {
        List<article> articles = spaceflightNewsService.getArticles();
        for (article art : articles) {
            System.out.println("Article Title: " + art.getTitle());
            System.out.println("Article Image URL: " + art.getImageUrl());
        }
        model.addAttribute("articles", articles);
        return "articles";
    }

}
