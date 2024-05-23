package com.SpaceNews.blogsfeed;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BlogsService {

    private static final Logger logger = LoggerFactory.getLogger(BlogsService.class);
    private static final String Blogs_API_URL = "https://api.spaceflightnewsapi.net/v4/blogs";

    @Autowired
    private RestTemplate restTemplateBlogs;

    public List<blog> getBlogs() {
        try {
            ResponseEntity<ApiResponseBlogs<blog>> response = restTemplateBlogs.exchange(
                    Blogs_API_URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ApiResponseBlogs<blog>>() {
                    }
            );
            return response.getBody().getResults();
        } catch (Exception e) {
            logger.error("Error fetching Blogs", e);
            throw e;
        }
    }
}
