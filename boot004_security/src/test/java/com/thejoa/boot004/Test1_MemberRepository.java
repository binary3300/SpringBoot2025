package com.thejoa.boot004;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot004.member.Member;
import com.thejoa.boot004.member.MemberRepository;

@SpringBootTest
class Test1_MemberRepository {
	@Autowired MemberRepository memberRepository;
	
	// insert, update - save
	// select - findAll  , findById
	// delete - delete
	@Disabled @Test void insert() { 
		Member member=new Member();
		member.setUsername("first");
		member.setPassword("1111");
		member.setEmail("first@gmail.com");
		memberRepository.save(member); 
	}
	@Disabled @Test void findAll() { 
		List<Member> list = memberRepository.findAll();
		System.out.println(list);
	}
	@Disabled @Test void findId()  { 
		System.out.println( memberRepository.findById(1L).get() );
	}
	
	@Disabled @Test void findUsername()  { 
		System.out.println( memberRepository.findByUsername("first").get());
	}
	
	
	@Disabled @Test void update()  { 
		Member member = memberRepository.findById(1L).get();
		member.setUsername("one");
		memberRepository.save(member);
	}
	@Disabled @Test void updatePassword()  { 
		memberRepository.updateByIdAndPassword("1234", "1111", 1L); 
	}
	@Disabled @Test void delete()  { 
		Member member = memberRepository.findById(1L).get();
		memberRepository.delete(member);
	}
}


//Q1. crud - sql구문적기
//insert into member (username, password, email) values (?,?,?)  - save
//select * from member               - findAll
//select * from member where id=?    - findById
//update member set email=? , username=?, password=? where id=?   - save
//delete from member where id=?

//Q2. @Query 아이디와 비번이 같은 유저의 비밀번호 변경  - 위에 repository 작성!
//2-1  @Modifying  @Transactional  @Query
//update Member m  set m.password=?  where m.password =?  and m.id=?