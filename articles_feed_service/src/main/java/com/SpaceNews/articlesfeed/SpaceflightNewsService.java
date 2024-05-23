package com.SpaceNews.articlesfeed;

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
    public class SpaceflightNewsService {

        private static final Logger logger = LoggerFactory.getLogger(SpaceflightNewsService.class);
        private static final String ARTICLES_API_URL = "https://api.spaceflightnewsapi.net/v4/articles";

        @Autowired
        private RestTemplate restTemplate;

        public List<article> getArticles() {
            try {
                ResponseEntity<com.SpaceNews.articlesfeed.ApiResponse<article>> response = restTemplate.exchange(
                        ARTICLES_API_URL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<com.SpaceNews.articlesfeed.ApiResponse<article>>() {
                        }
                );
                return response.getBody().getResults();
            } catch (Exception e) {
                logger.error("Error fetching articles", e);
                throw e;
            }
        }

    }



