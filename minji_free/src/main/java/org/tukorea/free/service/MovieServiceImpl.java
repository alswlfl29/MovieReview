package org.tukorea.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.free.domain.MovieVO;
import org.tukorea.free.persistence.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDAO movieDAO;
	public MovieVO readMovie(int id) throws Exception{
		return movieDAO.read(id);
	}
	public List<MovieVO> readMovieList() throws Exception{
		return movieDAO.readList();
	}
	public void addMovie(MovieVO movie) throws Exception{
		movieDAO.add(movie);
	}
	public void deleteMovie(int id) throws Exception{
		movieDAO.delete(id);
	}
	public void updateMovie(MovieVO movie) throws Exception{
		movieDAO.update(movie);
	}

}
