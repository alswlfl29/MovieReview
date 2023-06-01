package org.tukorea.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.persistence.ReviewDAO;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDAO reviewDAO;
	public ReviewVO readReview(int id) throws Exception{
		return reviewDAO.read(id);
	}
	public List<ReviewVO> readReviewList(int id) throws Exception{
		return reviewDAO.readList(id);
	}
	public void addReview(ReviewVO review) throws Exception{
		reviewDAO.add(review);
	}
	public void deleteReview(int id) throws Exception{
		reviewDAO.delete(id);
	}
	public void updateReview(ReviewVO review) throws Exception{
		reviewDAO.update(review);
	}
}
