package com.entrevista.attusDemo.movie.base.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "movie_base")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieBase {
    @id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String imdb_id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date launch_date;
    private int review_stars;
    private int duration;
    private int views;
}
