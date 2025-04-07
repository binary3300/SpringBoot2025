package com.Tja.boot001.myjpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long>{
}//JpaRepository<Team, Long> 테이블, 기본값자료형

/*
mysql> desc team;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | YES  |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

crud1. insert into team(name) values (?)
crud2. select * from team / select * from team where id=?
crud3. update team set name=? where id=?
crud3. delete from team where id=?

*/