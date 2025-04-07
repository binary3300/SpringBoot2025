package com.Tja.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Tja.boot001.myjpa.Team;
import com.Tja.boot001.myjpa.TeamRepository;

@SpringBootTest
class Boot001ApplicationTests {
	@Autowired TeamRepository teamrepository;
	
	//teamrepository.save (insert, update) / teamrepository.delete - (delete)
	//teamrepository.findAll() select / teamrepository.findById (select)
	
	@Test 	//@Disabled 
	void insert() {
		Team team = new Team();
		team.setName("animal");
		teamrepository.save(team);
	}
	
	@Disabled //@Test 
	public void selectAll() {
		List<Team> list = teamrepository.findAll();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
	}
	
	@Disabled //@Test 
	public void update() {
		//1. 수정할 팀 찾기
		//Optional<Team> - null값 안전보장
		Optional<Team> findTeam = teamrepository.findById(1L);
		System.out.println(findTeam.isPresent());
		
		//2. 이름변경해서 수정 
		Team team = findTeam.get();
		team.setName("hello");
		teamrepository.save(team);
	}
	
	@Disabled @Test 
	public void delete() {
		//1. 수정할 팀 찾기
		Optional<Team> findTeam = teamrepository.findById(1L);
		System.out.println(findTeam.isPresent());
		
		Team team = findTeam.get();
		teamrepository.delete(team);
	}

}

/*
crud1. insert into team(name) values (?)
crud2. select * from team / select * from team where id=?
crud3. update team set name=? where id=?
crud3. delete from team where id=?

mysql> desc team;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | YES  |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
 */