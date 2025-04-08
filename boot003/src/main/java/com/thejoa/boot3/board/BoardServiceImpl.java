package com.thejoa.boot3.board;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class BoardServiceImpl implements BoardService {
	@Autowired BoardRepository  boardRepository;
	
	//전체리스트
	@Override public List<Board> findAll() {
		return boardRepository.findAll();
	}
	
	//조회수올리고 상세보기
	@Transactional //commit(반영) / rollback(되돌리기)
	@Override public Board find(Long id) {
		Board board = boardRepository.findById(id).get();
		board.setBhit(board.getBhit()+1);//기존조회수+1
		boardRepository.save(board);
		return board;
	}

	//글쓰기 기능
	@Override public void insert(Board board) {
		try { board.setBip(InetAddress.getLocalHost().getHostAddress());}
		catch (UnknownHostException e) { e.printStackTrace(); }
		boardRepository.save(board);
	}

	//수정하기 폼
	@Override public Board update_view(Long id) {
		return boardRepository.findById(id).get();
	}

	//글수정기능
	@Override public void update(Board board) {
		boardRepository.save(board);
	}

	//글삭제기능
	@Override
	public void delete(Board board) {
		boardRepository.delete(board);
	}

}
