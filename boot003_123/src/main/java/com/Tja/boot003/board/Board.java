package com.Tja.boot003.board;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Tja.boot003.member.Member;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter

public class Board {
	@Id //1. 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String btitle;
	
	@Column(columnDefinition = "text")
	private String bcontent;
	
	private String bfile;
	private String bip;
	private String bpass;
	private Long bhit=0L;

	@Column(updatable = false) //수정못하게
	private LocalDateTime createDate = LocalDateTime.now();
	

	//@Transient //3. 컬럼 인식못하게 알아만 두세오
	//private String email;
	
	@ManyToOne @JoinColumn(name = "MEMBER_ID")
	private Member member;
	
	
	
}
