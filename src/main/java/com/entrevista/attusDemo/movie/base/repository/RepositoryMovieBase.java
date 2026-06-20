package com.entrevista.attusDemo.movie.base.repository;

import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryMovieBase extends JpaRepository<MovieBase, Long> {

    @Query(value = "SELECT * FROM movie_base where black_list = true", countQuery = "select count(*) movie_base where black_list = true")
    Page<MovieBase> getBlackList(Pageable pageable);
}
