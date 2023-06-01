package org.tukorea.free.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.free.mapper.ReviewMapper";

	public ReviewVO read(int id) throws Exception{
		ReviewVO vo = sqlSession.selectOne(namespace+".selectByid",id);
		String nickname = sqlSession.selectOne(namespace+".selectByid2", vo.getUser_id());
		vo.setNickname(nickname);
		return vo;
	}
	public List<ReviewVO> readList(int id) throws Exception{
		List<ReviewVO> reviewlist = new ArrayList<ReviewVO>();
		reviewlist = sqlSession.selectList(namespace+".selectAll",id);
		for (ReviewVO review : reviewlist) {
			String nickname = sqlSession.selectOne(namespace+".selectByid2", review.getUser_id());
			review.setNickname(nickname);
		}	
		return reviewlist;
	}
	public void add(ReviewVO vo) throws Exception{
		sqlSession.insert(namespace+".insert",vo);
	}
	public void delete(int id) throws Exception{
		sqlSession.delete(namespace+".delete",id);
	}
	public void update(ReviewVO review) throws Exception{
		sqlSession.update(namespace+".update", review);
	}
}
