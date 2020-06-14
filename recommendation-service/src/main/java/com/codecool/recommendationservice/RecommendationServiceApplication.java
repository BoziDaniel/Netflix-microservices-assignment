package com.codecool.recommendationservice;

import com.codecool.recommendationservice.entity.Recommendation;
import com.codecool.recommendationservice.repository.RecommendationRepository;
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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RecommendationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendationServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant("/video/**"))
                .build();
    }

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Bean
    @Profile("dev")
    public CommandLineRunner init() {
		return args -> {
			Recommendation recommendation1 = Recommendation.builder()
					.rating(5)
					.comment("nice video")
					.videoId((long) 1)
					.build();
			Recommendation recommendation2 = Recommendation.builder()
					.rating(4)
					.comment("nice but wont be my favorite")
					.videoId((long) 1)
					.build();
			Recommendation recommendation3 = Recommendation.builder()
					.rating(5)
					.comment("best")
					.videoId((long) 2)
					.build();
			recommendationRepository.save(recommendation1);
			recommendationRepository.save(recommendation2);
			recommendationRepository.save(recommendation3);
		};

    }
}
