package com.Tja.boot001.myjpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter

public class Team {
	@Id //1. 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//2. 숫자 자동증가
	private Long id;
	
	private String name;
	
	@Column(updatable = false) //수정못하게
	private LocalDateTime createDate = LocalDateTime.now();

	//@Transient //3. 컬럼 인식못하게 알아만 두세오
	//private String email;
	
	@OneToMany
	List<Mamber> member = new ArrayList<>();
	
	
}
