package org.tukorea.free.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.domain.UserVO;

public interface UserService {
	public int loginCheck(UserVO vo, HttpSession session) throws Exception;
	public void logout(HttpSession session) throws Exception;
	public void addUser(UserVO user) throws Exception;
	public List<ReviewVO> readMyList(int id) throws Exception;
	public void updateReviewList(List<ReviewVO> reviewList) throws Exception;
}
