package com.entrevista.attusDemo.movie.base.controller;

import com.entrevista.attusDemo.core.controller.CrudController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieBaseController extends CrudController<MovieBase, UUID> {
}
