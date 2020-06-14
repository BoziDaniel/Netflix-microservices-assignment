package com.codecool.recommendationservice.repository;

import com.codecool.recommendationservice.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    public List<Recommendation> getRecommendationsByVideoId(Long id);
}
