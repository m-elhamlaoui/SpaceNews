package com.SpaceNews.reportsfeed;

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
public class ReportsService {

    private static final Logger logger = LoggerFactory.getLogger(ReportsService.class);
    private static final String REPORTS_API_URL = "https://api.spaceflightnewsapi.net/v4/reports";

    @Autowired
    private RestTemplate restTemplateReports;

    public List<report> getReports() {
        try {
            ResponseEntity<ApiResponseReports<report>> response = restTemplateReports.exchange(
                    REPORTS_API_URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ApiResponseReports<report>>() {}
            );
            return response.getBody().getResults();
        } catch (Exception e) {
            logger.error("Error fetching reports", e);
            throw e;
        }
    }
}
