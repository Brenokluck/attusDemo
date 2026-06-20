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
    private String Title;
    private String Plot;
    private String imdbID;
    private Date Released;
    private String imdbRating;
    private String Runtime;
    private String BoxOffice;
    private Boolean watched;
    private Boolean watchLater;
    private Boolean blackList;
}
