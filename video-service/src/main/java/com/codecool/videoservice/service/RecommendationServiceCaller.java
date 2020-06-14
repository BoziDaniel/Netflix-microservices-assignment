package com.codecool.videoservice.service;


import com.codecool.videoservice.modell.Recommendation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class RecommendationServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendations.url}")
    private String baseUrl;

    public List<Recommendation> getRecommendationForVideo(Long id) {
        ResponseEntity<Recommendation[]> response = restTemplate.getForEntity(baseUrl + "/" + id, Recommendation[].class);
        log.info(String.format("response from recomendation service: %s", response.toString()));
        Recommendation[] recommendations = response.getBody();
        List<Recommendation> recommendationList = Arrays.asList(recommendations);
        log.info(String.format("recomendations from recomendation service: %s", recommendations));
        return recommendationList;
    }

}
