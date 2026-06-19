package com.entrevista.attusDemo.movie.base.repository;

import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryMovieBase extends JpaRepository<MovieBase, Long> {
}
