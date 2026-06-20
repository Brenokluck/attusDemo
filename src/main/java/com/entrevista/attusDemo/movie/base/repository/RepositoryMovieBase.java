package com.entrevista.attusDemo.movie.base.repository;

import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryMovieBase extends JpaRepository<MovieBase, Long> {

    @Query(value = "SELECT * FROM movie_base where blackList = true", countQuery = "select count(*) movie_base where blackList = true", nativeQuery = true)
    Page<MovieBase> getBlackList(Pageable pageable);

    @Query(value = "SELECT * FROM movie_base where watchLater = true", countQuery = "select count(*) movie_base where watchLater = true", nativeQuery = true)
    Page<MovieBase> getFavoriteList(Pageable pageable);

    @Query(value = "SELECT * FROM movie_base where watched = true", countQuery = "select count(*) movie_base where watched = true", nativeQuery = true)
    Page<MovieBase> getWatchedList(Pageable pageable);

    @Query(value = "UPDATE movie_base set " +
            "blackList = :blackList " +
            "watched = :watched " +
            "watcheLater = :watcheLater " +
            "where id = :id", nativeQuery = true)
    @Modifying
    void alterMovie(@Param("id") String id, @Param("blackList") Boolean blackList, @Param("watched") Boolean watched, @Param("watcheLater") Boolean watcheLater);
}
