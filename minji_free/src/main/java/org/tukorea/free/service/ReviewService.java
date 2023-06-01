package org.tukorea.free.service;

import java.util.List;

import org.tukorea.free.domain.ReviewVO;

public interface ReviewService {
	public ReviewVO readReview(int id) throws Exception;
	public List<ReviewVO> readReviewList(int id) throws Exception;
	public void addReview(ReviewVO review) throws Exception;
	public void deleteReview(int id) throws Exception;
	public void updateReview(ReviewVO review) throws Exception;
}
