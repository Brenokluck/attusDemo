package com.entrevista.attusDemo.movie.base.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieBaseDTO {
    private Long id;
    private String title;
    private String description;
    private String imdb_id;
    private Date launch_date;
    private int review_stars;
    private int duration;
    private int views;
    private boolean watched;
    private boolean watchLater;
    private boolean blackList;
}
