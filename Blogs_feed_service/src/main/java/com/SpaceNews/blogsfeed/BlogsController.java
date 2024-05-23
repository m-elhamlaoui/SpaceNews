package com.SpaceNews.blogsfeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogsController {

    @Autowired
    private BlogsService spaceflightNewsService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/blogs")
    public String getBlogs(Model model) throws Exception {
        List<blog> blogs = spaceflightNewsService.getBlogs();
        for (blog art : blogs) {
            System.out.println("Blog Title: " + art.getTitle());
            System.out.println("Blog Image URL: " + art.getImageUrl());
        }
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

}
