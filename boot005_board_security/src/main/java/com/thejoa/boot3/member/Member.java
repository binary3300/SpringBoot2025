package com.thejoa.boot3.member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.thejoa.boot3.board.Board;

import lombok.Getter;
import lombok.Setter;

@Entity  @Getter  @Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)   //유일한값 설정
	private String username;
	private String password;

	@Column(unique=true)  
	private String email;

	@Column(updatable = false)  
	private LocalDateTime udate = LocalDateTime.now();
	
	//유저(Member:One)는 많은 글(Many:board)을 쓸수 있다. 
	@OneToMany
	List<Board> board = new ArrayList<>();
	
}







