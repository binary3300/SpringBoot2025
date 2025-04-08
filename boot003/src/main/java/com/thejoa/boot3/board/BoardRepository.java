package com.thejoa.boot3.board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{
}  // JpaRepository<Member, Long>   테이블, pk의 자료형

/*
mysql> desc member;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| age         | int          | NO   |     | NULL    |                |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | NO   |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)
*/