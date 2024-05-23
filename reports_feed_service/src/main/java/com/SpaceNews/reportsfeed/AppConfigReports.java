package com.SpaceNews.reportsfeed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigReports {

    @Bean
    public RestTemplate restTemplateReports() {
        return new RestTemplate();
    }
}
