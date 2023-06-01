package org.tukorea.free.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	private int review_id; // 리뷰 번호
	private int user_id; // 유저 아이디
	private String nickname; // 유저 닉네임
	private int movie_id; // 영화 아이디
	private String title; // 리뷰 제목
	private String content; // 리뷰 내용
	private Date createAt; // 등록 일자
	private Date updateAt; // 업데이트 일자
	private Boolean is_delete; // 삭제여부
}
