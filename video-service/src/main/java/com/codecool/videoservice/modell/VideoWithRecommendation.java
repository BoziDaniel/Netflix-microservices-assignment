package com.codecool.videoservice.modell;

import com.codecool.videoservice.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoWithRecommendation {
    private Video video;
    private List<Recommendation> recommendations;
}
