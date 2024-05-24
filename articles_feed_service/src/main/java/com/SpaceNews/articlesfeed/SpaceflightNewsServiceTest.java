package com.SpaceNews.articlesfeed;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpaceflightNewsServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SpaceflightNewsService spaceflightNewsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetArticles() {
        // Création de données simulées
        article article1 = new article();
        article1.setTitle("Article 1");
        article1.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg");

        article article2 = new article();
        article2.setTitle("Article 2");
        article2.setImageUrl("https://static.wikia.nocookie.net/space/images/0/03/Andromeda-galaxy.jpg/revision/latest?cb=20110813083639");

        List<article> articleList = Arrays.asList(article1, article2);
        ApiResponse<article> apiResponse = new ApiResponse<>();
        apiResponse.setResults(articleList);

        ResponseEntity<ApiResponse<article>> responseEntity = ResponseEntity.ok(apiResponse);

        // Mock the RestTemplate exchange method
        when(restTemplate.exchange(
                eq("https://api.spaceflightnewsapi.net/v4/articles"),
                eq(HttpMethod.GET),
                isNull(),
                any(ParameterizedTypeReference.class)
        )).thenReturn(responseEntity);

        // Call the method under test
        List<article> articles = spaceflightNewsService.getArticles();

        // Verify the results
        assertNotNull(articles);
        assertEquals(2, articles.size());
        assertEquals("Article 1", articles.get(0).getTitle());
        assertEquals("https://upload.wikimedia.org/wikipedia/commons/c/c3/NGC_4414_%28NASA-med%29.jpg", articles.get(0).getImageUrl());
        assertEquals("Article 2", articles.get(1).getTitle());
        assertEquals("https://static.wikia.nocookie.net/space/images/0/03/Andromeda-galaxy.jpg/revision/latest?cb=20110813083639", articles.get(1).getImageUrl());
    }
}