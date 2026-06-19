package com.entrevista.attusDemo.movie.base.controller;

import com.entrevista.attusDemo.core.controller.CrudController;
import com.entrevista.attusDemo.core.service.CrudService;
import com.entrevista.attusDemo.movie.base.domain.MovieBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieBaseController extends CrudController<MovieBase, Long> {
    protected MovieBaseController(CrudService<MovieBase, Long> service) {
        super(service);
    }
}
