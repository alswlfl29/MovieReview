package org.tukorea.free.domain;

import lombok.Data;

@Data
public class MovieVO {
	private int movie_id; // 영화 번호
	private String title; // 영화 제목
	private String image; // 영화 포스터
	private String actor; // 영화 배우
	private String content;  // 영화 줄거리
	private String open_date; // 영화 개봉일
}
