package org.tukorea.free.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tukorea.free.domain.MovieVO;

@Repository
public class MovieDAOImpl implements MovieDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.free.mapper.MovieMapper";

	public MovieVO read(int id) throws Exception{
		MovieVO vo = sqlSession.selectOne(namespace+".selectByid",id);
		return vo;
	}
	public List<MovieVO> readList() throws Exception{
		List<MovieVO> movielist = new ArrayList<MovieVO>();
		movielist = sqlSession.selectList(namespace+".selectAll");
		return movielist;
	}
	public void add(MovieVO vo) throws Exception{
		sqlSession.insert(namespace+".insert",vo);
	}
	public void delete(int id) throws Exception{
		sqlSession.delete(namespace+".delete",id);
	}
	public void update(MovieVO movie) throws Exception{
		sqlSession.update(namespace+".update", movie);
	}

}
