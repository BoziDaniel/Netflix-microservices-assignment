package com.codecool.videoservice.service;


import com.codecool.videoservice.modell.Recommendation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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
        Recommendation[] recommendations = response.getBody();
        List<Recommendation> recommendationList = Arrays.asList(recommendations);
        return recommendationList;
    }

    public void addRecommendation(Long id, Recommendation recommendation) {
        String url = "http://localhost:8091/recommendations";
        HttpEntity<Recommendation> request = new HttpEntity<>(recommendation);
        restTemplate.postForObject(url + "/" + id, request, Recommendation.class);
    }
}
