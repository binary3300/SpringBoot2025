package com.Tja.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Tja.boot001.myjpa.Mamber;
import com.Tja.boot001.myjpa.MamberRepository;
import com.Tja.boot001.myjpa.Team;

@SpringBootTest
public class Test002_Mamber {
	@Autowired MamberRepository mamberrepository;
	
	@Disabled //@Test
	public void insert() {
		Team team= new Team();
		team.setId(1L);
		//team.setId(2L);//##1 2L로 하면 에러난다,..,, team의 id중에 없는 번호라서.....
		
		Mamber member= new Mamber();
		member.setName("second");
		member.setAge(22);
		member.setTeam(team);//##2
		mamberrepository.save(member);//## insert, update - save
	}
	// Q2. findAll 유저들 출력 //## select = findAlll, findById
	@Disabled //@Test
	public void selectAll() {
		List<Mamber> list = mamberrepository.findAll();
		for(Mamber m: list) {System.out.println(m);}
		System.out.println(list.get(0).getName());
	}
	
	// Q3. update 이용해서 유저번호가 1l인 데이터값 수정
	@Disabled //@Test
	public void update() {
		Optional<Mamber> findMamber = mamberrepository.findById(1L);
		if(findMamber.isPresent()) {
			Mamber member =findMamber.get();
			member.setName("one");
			member.setAge(1);
			//member.setTeam(null); team값 설정안하면 기존에 있었던 값
			mamberrepository.save(member);
		}
	}
	
	// Q4. delete 이용해서 1L유저 삭제
	@Test public void delete() {
		Optional<Mamber> findMamber = mamberrepository.findById(1L);
		if(findMamber.isPresent()) {//유저가 있다면
			Mamber member =findMamber.get(); //유저 꺼내오기
			mamberrepository.delete(member);
		}
	}
	
	
	
	//insert into member(name, age, create_date, team_id) value(?,?,?,?)
	



	
	
	
}
