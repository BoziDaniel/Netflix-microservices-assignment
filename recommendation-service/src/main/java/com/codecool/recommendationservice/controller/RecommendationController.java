package com.codecool.recommendationservice.controller;

import com.codecool.recommendationservice.entity.Recommendation;
import com.codecool.recommendationservice.repository.RecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/video/")
public class RecommendationController {
    @Autowired
    private Environment env;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @GetMapping("/{id}")
    public List<Recommendation> getRecommendationsForVideo(@PathVariable("id") Long videoId) {
        return recommendationRepository.getRecommendationsByVideoId(videoId);
    }

    @PostMapping("/{id}/add")
    public void addNewRecommendation(@PathVariable("id") Long id, Recommendation recommendation) {
        recommendationRepository.save(recommendation);
    }
}

