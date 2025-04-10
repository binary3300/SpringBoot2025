package com.thejoa.boot004.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

 @Getter  @Setter
public class MemberForm { // memberForm
	@NotEmpty(message="사용자 ID는 필수 항목 입니다.")
	@Size(min=4, max=20)
	private String username;
	
	@NotEmpty(message="비밀번호는 필수 항목 입니다.")
	private String password;
	
	@NotEmpty(message="비밀번호 확인을 입력 해 주세요.")
	private String password2;
	
	@NotEmpty(message="이메일은 필수 항목 입니다.")
	private String email;
}







