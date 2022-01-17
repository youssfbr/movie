package com.github.youssfbr.movie.controllers;

import com.github.youssfbr.movie.dto.request.MovieDTO;
import com.github.youssfbr.movie.dto.request.ScoreDTO;
import com.github.youssfbr.movie.services.interfaces.IScoreService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/scores")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ScoreController {

    private final IScoreService scoreService;

    @PutMapping
    public ResponseEntity<MovieDTO> saveScore(final @RequestBody ScoreDTO scoreDTO) {

        MovieDTO movieDTO = scoreService.saveScore(scoreDTO);

        return ResponseEntity.ok(movieDTO);
    }
}
