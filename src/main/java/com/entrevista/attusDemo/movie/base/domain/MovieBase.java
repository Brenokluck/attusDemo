package com.entrevista.attusDemo.movie.base.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String plot;
    private String imdb_id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date released;
    private String imdbRating;
    private String runtime;
    private Boolean watched;
    private Boolean watchLater;
    private Boolean blackList;
}
