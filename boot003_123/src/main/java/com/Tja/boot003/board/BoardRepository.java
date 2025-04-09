package com.Tja.boot003.board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{
}//JpaRepository<Team, Long> 테이블, 기본값자료형

/*
mysql> desc board;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| bcontent    | text         | YES  |     | NULL    |                |
| bfile       | varchar(255) | YES  |     | NULL    |                |
| bhit        | bigint       | YES  |     | NULL    |                |
| bip         | varchar(255) | YES  |     | NULL    |                |
| bpass       | varchar(255) | YES  |     | NULL    |                |
| btitle      | varchar(200) | YES  |     | NULL    |                |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| friends_id  | bigint       | YES  | MUL | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
9 rows in set (0.00 sec)
*/