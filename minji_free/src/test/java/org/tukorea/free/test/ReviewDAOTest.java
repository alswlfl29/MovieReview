package org.tukorea.free.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.persistence.ReviewDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ReviewDAOTest {

	@Autowired
	private ReviewDAO dao;
	private static Logger logger = LoggerFactory.getLogger(ReviewDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		ReviewVO vo;
		vo = dao.read(2);
		logger.info(vo.toString());
	}
	@Test
	public void testReadList() throws Exception {
		List<ReviewVO> voList;
		voList = dao.readList(1);
		for(ReviewVO svo : voList) {
			logger.info(svo.toString());
		}
	}
}
