package com.entrevista.attusDemo.movie.base.service;

import com.entrevista.attusDemo.core.service.CrudServiceImpl;
import com.entrevista.attusDemo.movie.base.DTO.MovieBaseDTO;
import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import com.entrevista.attusDemo.movie.base.repository.RepositoryMovieBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MovieBaseService extends CrudServiceImpl<MovieBase, Long> {
    private final RepositoryMovieBase repositoryMovieBase;

    public MovieBaseService(RepositoryMovieBase repository, RepositoryMovieBase repositoryMovieBase) {
        super(repository);
        this.repositoryMovieBase = repositoryMovieBase;
    }

    public void createNewMovieInDB(String movieID) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            MovieBase movieBaseDTO = mapper.readValue(requestIMDBMovieData(movieID), MovieBase.class);
            create(movieBaseDTO);
        } catch (Exception e) {
            log.error("[createNewMovieInDB] - erro ao tentar salvar o filme do Banco de dados");
            throw e;
        }
    }

    public String requestIMDBMovieData(String movieID) {
        RestClient restClient = RestClient.create();

        return restClient.get()
                .uri("http://www.omdbapi.com/?i={movieIDArray}&apikey=46418951", movieID)
                .retrieve()
                .toEntity(String.class)
                .getBody();
    }

    public List<MovieBaseDTO> getBlackListList(Pageable pageable) {
        try {
            Page<MovieBase> movieBasePage = repositoryMovieBase.getBlackList(pageable);

            if(movieBasePage.isEmpty()) {
                throw new RuntimeException();
            }

            List<MovieBaseDTO> movieBaseDTOS = movieBasePage.getContent().stream()
                    .map(content -> {
                        return MovieBaseDTO.builder()
                                .id(content.getId())
                                .Title(content.getTitle())
                                .Plot(content.getPlot())
                                .imdbID(content.getImdbID())
                                .Released(content.getReleased())
                                .imdbRating(content.getImdbRating())
                                .Runtime(content.getRuntime())
                                .BoxOffice(content.getBoxOffice())
                                .watched(getWatched())
                                .watchLater(getWatchLater())
                                .blackList(getBlackList()).build();
                    }).collect(Collectors.toList());
            return movieBaseDTOS;
        } catch (RuntimeException e) {
            log.error("[getBlackListList] - erro ao tentar salvar o filme na blacklist");
            throw e;
        }
    }

    public MovieBase getFavoriteList(Pageable pageable) {

    }

    public MovieBase getWatchedList(Pageable pageable) {

    }
}
