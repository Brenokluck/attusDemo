package com.entrevista.attusDemo.movie.base.service;

import com.entrevista.attusDemo.core.service.CrudServiceImpl;
import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import com.entrevista.attusDemo.movie.base.repository.RepositoryMovieBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieBaseService extends CrudServiceImpl<MovieBase, Long> {
    public MovieBaseService(RepositoryMovieBase repository) {
        super(repository);
    }
}
