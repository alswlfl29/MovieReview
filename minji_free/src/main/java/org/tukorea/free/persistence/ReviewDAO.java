package org.tukorea.free.persistence;

import java.util.List;

import org.tukorea.free.domain.ReviewVO;

public interface ReviewDAO {
	public void add(ReviewVO review) throws Exception;
	public List<ReviewVO> readList(int id) throws Exception;
	public ReviewVO read(int id) throws Exception;
	public void delete(int id) throws Exception;
	public void update(ReviewVO review) throws Exception;
}
