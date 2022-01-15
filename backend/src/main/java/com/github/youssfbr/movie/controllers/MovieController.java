package com.github.youssfbr.movie.controllers;

import com.github.youssfbr.movie.dto.request.MovieDTO;
import com.github.youssfbr.movie.services.interfaces.IMovieService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {

    private final IMovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(movieService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }
}
