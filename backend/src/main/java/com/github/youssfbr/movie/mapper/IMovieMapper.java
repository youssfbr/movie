package com.github.youssfbr.movie.mapper;

import com.github.youssfbr.movie.dto.request.MovieDTO;
import com.github.youssfbr.movie.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMovieMapper {

    IMovieMapper INSTANCE = Mappers.getMapper(IMovieMapper.class);

    Movie toModel(MovieDTO movieDTO);

    MovieDTO toDTO(Movie movie);

}
