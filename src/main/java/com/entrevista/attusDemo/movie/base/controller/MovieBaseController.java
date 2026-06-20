package com.entrevista.attusDemo.movie.base.controller;

import com.entrevista.attusDemo.core.controller.CrudController;
import com.entrevista.attusDemo.core.service.CrudService;
import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import com.entrevista.attusDemo.movie.base.service.MovieBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieBaseController extends CrudController<MovieBase, Long> {
    private final MovieBaseService movieBaseService;

    protected MovieBaseController(CrudService<MovieBase, Long> service, MovieBaseService movieBaseService) {
        super(service);
        this.movieBaseService = movieBaseService;
    }

    @PostMapping("/IMDB/import/{movieID}")
    public ResponseEntity<String> populateDBWithMovies(@PathVariable String movieID) {
        try {
            movieBaseService.createNewMovieInDB(movieID);
            return new ResponseEntity<>("Filme salvo com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
