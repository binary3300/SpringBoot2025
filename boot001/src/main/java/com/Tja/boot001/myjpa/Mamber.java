package com.Tja.boot001.myjpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;import org.apache.el.parser.AstFalse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mamber {
	@Id// 기본값
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private long id;
	
	//name="USERNAME" 필드명 수정, not null설정
	/*
	 * @Column(name="USERNAME", nullable=false) //@Transiend private String name;
	 */
	@Column(nullable=false)
	private String name;
	
	private int age;
	
	@Column(updatable = false )
	private LocalDateTime createDate = LocalDateTime.now();
	
	@ManyToOne 
	private Team team; 
	//멤버는 하나의 팀을 가진다
	//team_id 컬럼 자동으로 생김 
}

/*
관계1
	팀은 많은 멤버를 가진다.
	멤버는 하나의 팀을 가진다.
	
 team -|---------∈ member


 * */


