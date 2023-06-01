package org.tukorea.free.persistence;

import java.util.List;

import org.tukorea.free.domain.MovieVO;

public interface MovieDAO {
	public void add(MovieVO movie) throws Exception;
	public List<MovieVO> readList() throws Exception;
	public MovieVO read(int id) throws Exception;
	public void delete(int id) throws Exception;
	public void update(MovieVO movie) throws Exception;
}
