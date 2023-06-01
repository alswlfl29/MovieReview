package org.tukorea.free.controller;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.free.domain.ReviewVO;
import org.tukorea.free.service.ReviewService;

@RestController
@RequestMapping(value="/review/rest")
public class ReviewRestController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewRestController.class);
	
	@Autowired(required=true)
	private ReviewService reviewService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ReviewVO> readReview(@PathVariable int id) throws Exception{
		ReviewVO review = reviewService.readReview(id);
		logger.info("/review/rest/{id} REST-API GET method called. then method executed");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
		headers.set("My-Header","MyHeaderValue");
		return new ResponseEntity<ReviewVO>(review, headers, HttpStatus.OK);
	}
	

}
