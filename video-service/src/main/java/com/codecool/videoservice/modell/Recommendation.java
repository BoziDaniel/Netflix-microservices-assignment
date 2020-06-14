package com.codecool.videoservice.modell;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Recommendation {
    private Long Id;
    private Integer rating;
    private String comment;
    private Long videoId;
}
