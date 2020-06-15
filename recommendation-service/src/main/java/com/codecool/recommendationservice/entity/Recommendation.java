package com.codecool.recommendationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Recommendation {
    @Id
    @GeneratedValue
    private Long Id;
    private Integer rating;
    private String comment;
    private Long videoId;
    public Recommendation(Integer rating, String comment, Long videoId) {
        this.rating = rating;
        this.comment = comment;
        this.videoId = videoId;
    }
}
