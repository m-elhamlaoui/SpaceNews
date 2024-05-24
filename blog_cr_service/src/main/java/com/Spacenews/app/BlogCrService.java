package com.Spacenews.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogCrService {

    @Autowired
    private BlogCrRepository blogRepository;

    public BlogCrModel createBlog(BlogCrModel blog) {
        return blogRepository.save(blog);
    }

    public List<BlogCrModel> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<BlogCrModel> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public BlogCrModel updateBlog(Long id, BlogCrModel blogDetails) {
        BlogCrModel blog = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Blog not found"));
        blog.setTitle(blogDetails.getTitle());
        blog.setContent(blogDetails.getContent());
        blog.setUserId(blogDetails.getUserId());
        return blogRepository.save(blog);
    }

    public boolean deleteBlog(Long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
