package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class VideoController {
    @Autowired
    private Environment env;

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
