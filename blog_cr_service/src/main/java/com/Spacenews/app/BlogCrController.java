package com.Spacenews.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/blogCr")
public class BlogCrController {

    @Autowired
    private BlogCrService blogService;

    @PostMapping
    public String createBlog(@ModelAttribute BlogCrModel blog) {
        blogService.createBlog(blog);

        return "redirect:/blogCr";
    }

    @GetMapping
    public String showBlogList(Model model) {
        List<BlogCrModel> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        model.addAttribute("newBlog", new BlogCrModel());
        return "blog-list";
    }


    @GetMapping("/{id}")
    public String getBlogById(@PathVariable Long id, Model model) {
        BlogCrModel blog = blogService.getBlogById(id).orElse(null);
        model.addAttribute("blog", blog);
        return "blog-list";
    }

    @PutMapping("/{id}")
    public String updateBlog(@PathVariable Long id, @RequestBody BlogCrModel blogDetails) {
        blogService.updateBlog(id, blogDetails);
        return "redirect:/blogCr";
    }

    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "redirect:/blogCr";
    }
}
