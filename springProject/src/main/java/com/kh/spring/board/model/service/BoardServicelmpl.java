package com.kh.spring.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.repository.BoardRepository;
import com.kh.spring.board.model.vo.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServicelmpl implements BoardService{
	
	private final BoardRepository boardRepository;
	private final SqlSessionTemplate sqlSession;
	
	@Override
	public int boardCount() {
		return boardRepository.boardCount(sqlSession);
	}

	@Override
	public List<Board> findAll() {
		
		return boardRepository.findAll(sqlSession);
	}

	@Override
	public int searchCount() {
		return boardRepository.searchCount(sqlSession);
	}

	@Override
	public List<Board> searchAll() {
		return boardRepository.searchAll(sqlSession);
	}

	@Override
	public int insert(Board board) {
		return boardRepository.insert(sqlSession);
	}

	@Override
	public int increadeCount(int boardNo) {
		return boardRepository.increadeCount(sqlSession);
	}

	@Override
	public Board findbyId(int boardNo) {
		return null;
	}

	@Override
	public int delete(int boardNo) {
		return 0;
	}
	
}
