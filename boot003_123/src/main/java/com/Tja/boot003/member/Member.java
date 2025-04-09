package com.Tja.boot003.member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.Tja.boot003.board.Board;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id// 기본값
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private long id;
	
	//name="USERNAME" 필드명 수정, not null설정
	/*
	 * @Column(name="USERNAME", nullable=false) //@Transiend private String name;
	 */
	
	private String name;
	private int age;
	
	@Column(updatable = false )
	private LocalDateTime createDate = LocalDateTime.now();
	
	//유저(member:one)은 많은 글(board:many)을 쓸 수 있다.
	@OneToMany(mappedBy = "member")
	List<Board> board = new ArrayList<>();

}

/*
관계1
	팀은 많은 멤버를 가진다.
	멤버는 하나의 팀을 가진다.
	
 team -|---------∈ member


 * */


