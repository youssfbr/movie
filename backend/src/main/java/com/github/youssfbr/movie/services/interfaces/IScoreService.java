package com.github.youssfbr.movie.services.interfaces;

import com.github.youssfbr.movie.dto.request.MovieDTO;
import com.github.youssfbr.movie.dto.request.ScoreDTO;

public interface IScoreService {

    MovieDTO saveScore(ScoreDTO scoreDTO);

}
