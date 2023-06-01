package org.tukorea.free.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	public int loginCheck(UserVO vo, HttpSession session) throws Exception{
		int user_id;
		
		if (userDAO.loginCheck(vo) == null) {
			 user_id = 0;
		} else {
			 user_id = Integer.parseInt(userDAO.loginCheck(vo));
			 session.setAttribute("user_id", user_id);
		}
		return user_id;
	}
	public void logout(HttpSession session) throws Exception{
		session.invalidate(); // 세션 초기화
	}
	public void addUser(UserVO user) throws Exception{
		userDAO.add(user);
	}
	public List<ReviewVO> readMyList(int id) throws Exception{
		return userDAO.readMyList(id);
	}
	// 트랜잭션 -> 유저가 영화 리뷰 2개 이상의 제목을 수정할 때, 제목 길이가 길면 예외 발생
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10)
	public void updateReviewList(List<ReviewVO> reviewList) throws Exception{
		for (ReviewVO review : reviewList) {
	        userDAO.updateTitle(review);
	    }
	}
}
