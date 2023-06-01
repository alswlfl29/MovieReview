package org.tukorea.free.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.free.mapper.UserMapper";
	
	public void add(UserVO vo) throws Exception{
		sqlSession.insert(namespace+".insert",vo);
	}
	public String loginCheck(UserVO user) throws Exception{
		return sqlSession.selectOne(namespace+".loginCheck",user);
	}
	public List<ReviewVO> readMyList(int id) throws Exception{
		List<ReviewVO> reviewmylist = new ArrayList<ReviewVO>();
		reviewmylist = sqlSession.selectList(namespace+".selectAll",id);
		return reviewmylist;
	}
	public void updateTitle(ReviewVO review) throws Exception{
		sqlSession.update(namespace+".update", review);
	}
}
