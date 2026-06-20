package com.entrevista.attusDemo.movie.base.service;

import com.entrevista.attusDemo.core.service.CrudServiceImpl;
import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import com.entrevista.attusDemo.movie.base.repository.RepositoryMovieBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class MovieBaseService extends CrudServiceImpl<MovieBase, Long> {
    public MovieBaseService(RepositoryMovieBase repository) {
        super(repository);
    }

    public void createNewMovieInDB(String movieID) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String teste = requestIMDBMovieData(movieID);
            MovieBase movieBaseDTO = mapper.readValue(requestIMDBMovieData(movieID), MovieBase.class);

            log.info("aqui: {}", movieBaseDTO);

//        create(newMovieBase);
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
}
