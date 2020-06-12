package com.codecool.videoservice;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class VideoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Autowired
    private VideoRepository videoRepository;

    @Bean
    @Profile("dev")
    public CommandLineRunner init() {
        return args -> {
            Video video1 = Video.builder()
                    .name("Rev Theory - Hell Yeah ")
                    .url("https://www.youtube.com/watch?v=7LuSP4QaXiQ&list=FLSAeGSMHm3a_66aLfeKCq8g&index=2")
                    .build();
            Video video2 = Video.builder()
                    .name("NB - LOL")
                    .url("https://www.youtube.com/watch?v=AuaOppdNCkM&list=FLSAeGSMHm3a_66aLfeKCq8g&index=62")
                    .build();
            Video video3 = Video.builder()
                    .name("Caravan Palace - Lone Digger")
                    .url("https://www.youtube.com/watch?v=UbQgXeY_zi4")
                    .build();
            Video video4 = Video.builder()
                    .name("Seven Nation Army")
                    .url("https://www.youtube.com/watch?v=GYFJjwXtsU4")
                    .build();
            videoRepository.save(video1);
            videoRepository.save(video2);
            videoRepository.save(video3);
            videoRepository.save(video4);
        };
    }
}
