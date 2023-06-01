package org.tukorea.free.persistence;

import java.util.List;

import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.domain.UserVO;

public interface UserDAO {
	public void add(UserVO user) throws Exception;
	public String loginCheck(UserVO user) throws Exception;
	public List<ReviewVO> readMyList(int id) throws Exception;
	public void updateTitle(ReviewVO review) throws Exception;
}
