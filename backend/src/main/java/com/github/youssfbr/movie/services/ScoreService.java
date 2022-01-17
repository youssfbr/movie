package com.github.youssfbr.movie.services;

import com.github.youssfbr.movie.dto.request.MovieDTO;
import com.github.youssfbr.movie.dto.request.ScoreDTO;
import com.github.youssfbr.movie.entities.Movie;
import com.github.youssfbr.movie.entities.Score;
import com.github.youssfbr.movie.entities.User;
import com.github.youssfbr.movie.mapper.IMovieMapper;
import com.github.youssfbr.movie.repositories.IMovieRepository;
import com.github.youssfbr.movie.repositories.IScoreRepository;
import com.github.youssfbr.movie.repositories.IUserRepository;
import com.github.youssfbr.movie.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.movie.services.interfaces.IScoreService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ScoreService implements IScoreService {

    private final IMovieRepository movieRepository;
    private final IUserRepository userRepository;
    private final IScoreRepository scoreRepository;

    private static final IMovieMapper movieMapper = IMovieMapper.INSTANCE;
    private static final String MESSAGE_ID = "Recurso não encontrado. Id: ";

    @Override
    @Transactional
    public MovieDTO saveScore(final ScoreDTO scoreDTO) {

        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository
                .findById(scoreDTO.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE_ID + scoreDTO.getMovieId()));

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore()); //scoreDTO

        scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return movieMapper.toDTO(movie);
    }

}
