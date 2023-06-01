package org.tukorea.free.domain;

import lombok.Data;

@Data
public class UserVO {
	private int user_id; // 유저 번호
	private String email; // 유저 이메일 
	private String nickname; // 유저 닉네임
	private String passwd; // 유저 패스워드
}
