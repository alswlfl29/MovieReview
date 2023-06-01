package org.tukorea.free.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.tukorea.free.domain.MovieVO;
import org.tukorea.free.persistence.MovieDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MovieDAOTest {

	@Autowired
	private MovieDAO dao;
	private static Logger logger = LoggerFactory.getLogger(MovieDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		MovieVO vo;
		vo = dao.read(1);
		logger.info(vo.toString());
	}
	@Test
	public void testReadList() throws Exception {
		List<MovieVO> voList;
		voList = dao.readList();
		for(MovieVO svo : voList) {
			logger.info(svo.toString());
		}
	}
}
