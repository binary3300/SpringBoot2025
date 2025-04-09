package com.Tja.boot003;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Tja.boot003.board.Board;
import com.Tja.boot003.board.BoardRepository;
import com.Tja.boot003.member.Member;
import com.Tja.boot003.member.MemberRepository;

@SpringBootTest
public class Test001_Board {
	@Autowired MemberRepository memberRepository;
	@Autowired BoardRepository boardRepository;
	
	
	@Test
	public void insertMember() {
		Member member = new Member();
		member.setName("fourth");
		member.setAge(44);
		memberRepository.save(member);
	}
	
	
	
	
	
	//유저(OneToMany:mappedby="member")는 많은 글(ManyToOne)을 쓸 수 있다.
	@Disabled //@Test
	public void insertBoard() {
		Member member = new Member(); member.setId(1L);  
		Board board = new Board();
		board.setBtitle("title-2");
		board.setBcontent("content-2");
		board.setBpass("2222");
		board.setBfile("2.jpg");
		
		try {
			board.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) { e.printStackTrace(); }
		board.setMember(member);
		boardRepository.save(board);
		
	}
	
	
	
	
	
//	select * from board
	@Disabled //@Test
	public void findAllBoard() {
		List<Board> list = boardRepository.findAll();
		System.out.println(list.get(0).getBtitle());
	}
	
	
	
	
	
	
	//editView
//	select * from board where id=?
	@Disabled //@Test
	public void findByIdBoard() {
		Optional<Board> findBoard = boardRepository.findById(1L);
		
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			System.out.println(board.getBfile());
		}
	}//find- select / save- insert,update / delete- delete
	
	
	
	
	
	
//	crud3. update board set btitle=?, bcontent=?, bfile=?  where id=?
	@Disabled //@Test
	public void updateBoard() {
		Optional<Board> findBoard = boardRepository.findById(1L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			board.setBtitle("title-new");
			board.setBcontent("content-new");
			boardRepository.save(board);
		}
		
	}
	
	//delete from board where id-?
	@Disabled //@Test
	public void deleteBoard() {
		Optional<Board> findBoard = boardRepository.findById(4L);
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			boardRepository.delete(board);
		}
	}
	
	
	
	
	
}//end class
