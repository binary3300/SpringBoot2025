package com.Tja.boot004;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Tja.boot004.member.Member;
import com.Tja.boot004.member.MemberRepository;

@SpringBootTest
class Test1_MemberRepository {
	@Autowired MemberRepository memberRepository;
	
	/*
	 insert, update - save
	 select 		- findAll, findById
	 delete 		- delete
	 */
	
	
	@Test void insert() {
		Member member=new Member();
		member.setUsername("first");
		member.setPassword("1111");
		member.setEmail("first@gmail.com");
		memberRepository.save(member);
	}
	
	@Disabled  void findAll() {
		List<Member> list = memberRepository.findAll();
		System.out.println(list);
	}
	
	@Disabled void findId() { 
		System.out.println(memberRepository.findById(1L).get());
	}
	
	@Disabled void findUsername() {
		System.out.println(memberRepository.findByUsername("first").get());
	}
	
	@Disabled void update() { 
		Member member = memberRepository.findById(1L).get();
		member.setUsername("one");
		memberRepository.save(member);
	}
	
	@Disabled void updatePassword() { 
		memberRepository.updateByIdAndPassword("1234", "1111", 1L);
	}
	
	@Disabled void delete() { 
		Member member = memberRepository.findById(1L).get();
		memberRepository.delete(member);
	}

}
