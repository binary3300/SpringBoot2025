package com.thejoa.boot3.member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.thejoa.boot3.board.Board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity  @Getter  @Setter  @ToString
public class Member {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int    age;
	
	@Column(updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
	//유저(Member:One)는 많은 글(Many:board)을 쓸수 있다. 
	@OneToMany(mappedBy = "member"  , fetch = FetchType.EAGER)
	List<Board> board = new ArrayList<>();
}

/*
>>3-1.    유저는 많은 글을 쓸수 있다.  
>>3-2.    member  -|-----------∈ board 
mysql>
mysql> desc member;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| age         | int          | NO   |     | NULL    |                |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | NO   |     | NULL    |                | 
+-------------+--------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)

mysql>
*/