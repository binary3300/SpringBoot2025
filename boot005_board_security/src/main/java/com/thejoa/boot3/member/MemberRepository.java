package com.thejoa.boot3.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository  extends JpaRepository<Member, Long>{
	Optional<Member>	  findByUsername(String username);
	
	@Modifying  
	@Transactional  
	@Query("update Member m set m.password=:password where m.password=:old  and m.id=:id")
	int updateByIdAndPassword(String password, String old, Long id);
	
}
/*
mysql> desc member;
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | bigint       | NO   | PRI | NULL    | auto_increment |
| email    | varchar(255) | YES  | UNI | NULL    |                |
| password | varchar(255) | YES  |     | NULL    |                |
| udate    | datetime(6)  | YES  |     | NULL    |                |
| username | varchar(255) | YES  | UNI | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)
 */
// Q1. crud - sql구문적기
// insert into member (username, password, email) values (?,?,?)  - save
// select * from member               - findAll
// select * from member where id=?    - findById
// update member set email=? , username=?, password=? where id=?   - save
// delete from member where id=?

// Q2. @Query 아이디와 비번이 같은 유저의 비밀번호 변경  - 위에 repository 작성!
// 2-1  @Modifying  @Transactional  @Query
// update Member m  set m.password=?  where m.password =?  and m.id=?







