package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
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
    private VideoRepository videoRepository;

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable("id") Long id) {
        return videoRepository.getVideoById(id);
    }
    @GetMapping("/all")
    public List<Video> getAllVideos() {
        System.out.println(videoRepository.findAll());
        return videoRepository.findAll();
    }
}
