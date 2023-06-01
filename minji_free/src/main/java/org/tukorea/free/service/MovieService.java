package org.tukorea.free.service;

import java.util.List;

import org.tukorea.free.domain.MovieVO;

public interface MovieService {
	public MovieVO readMovie(int id) throws Exception;
	public List<MovieVO> readMovieList() throws Exception;
	public void addMovie(MovieVO movie) throws Exception;
	public void deleteMovie(int id) throws Exception;
	public void updateMovie(MovieVO movie) throws Exception;

}
