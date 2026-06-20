package com.entrevista.attusDemo.movie.base.controller;

import com.entrevista.attusDemo.core.controller.CrudController;
import com.entrevista.attusDemo.core.service.CrudService;
import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import com.entrevista.attusDemo.movie.base.service.MovieBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/favorite")
    public ResponseEntity<Page<MovieBase>> getFavorite(@RequestParam int page, @RequestParam(defaultValue = "12", required = false) int size){
        Pageable pageable = PageRequest.of(page, size);
        try {
            return new ResponseEntity<>(movieBaseService.getFavorite(pageable), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/blacklist")
    public ResponseEntity<Page<MovieBase>> getBlackList(@RequestParam int page, @RequestParam(defaultValue = "12", required = false) int size){
        Pageable pageable = PageRequest.of(page, size);
        try {
            return new ResponseEntity<MovieBase>(movieBaseService.getBlackList(pageable), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/watched")
    public ResponseEntity<Page<MovieBase>> getWatched(@RequestParam int page, @RequestParam(defaultValue = "12", required = false) int size){
        Pageable pageable = PageRequest.of(page, size);
        try {
            return new ResponseEntity<>(movieBaseService.getWatched(pageable), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
