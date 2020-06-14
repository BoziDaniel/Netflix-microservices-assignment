package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.modell.Recommendation;
import com.codecool.videoservice.modell.VideoWithRecommendation;
import com.codecool.videoservice.repository.VideoRepository;
import com.codecool.videoservice.service.RecommendationServiceCaller;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private Environment env;
    @Autowired
    private RecommendationServiceCaller recommendationServiceCaller;
    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/{id}")
    public VideoWithRecommendation getVideoWithRecommendationsById(@PathVariable("id") Long id) {
        List<Recommendation> recommendations = recommendationServiceCaller.getRecommendationForVideo(id);
        System.out.println(recommendations.toString());
        Video video= videoRepository.getVideoById(id);
        log.info(video.toString());
        VideoWithRecommendation videoWithRecommendation = VideoWithRecommendation.builder()
                .video(video)
                .recommendations(recommendations)
                .build();
        return videoWithRecommendation;

    }
    @GetMapping("/all")
    public List<Video> getAllVideos() {
        System.out.println(videoRepository.findAll());
        return videoRepository.findAll();
    }
}
