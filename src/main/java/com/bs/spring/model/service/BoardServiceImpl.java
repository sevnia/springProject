package com.bs.spring.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.spring.model.dao.BoardDao;
import com.bs.spring.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Board> selectBoardList() {
		return dao.selectBoardList(session);
	}

	@Override
	public Board selectBoardByNo(int boardNo) {
		return dao.selectBoardByNo(session, boardNo);
	}

	@Override
	public List<Board> selectBoardByTitle(String title) {
		return null;
	}

	@Override
	public int insertBoard(Board newBoard) {
		return 0;
	}

	@Override
	public int updateBoard(Board board) {
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		return 0;
	}

	@Override
	public int selectBoardCount() {
		return dao.selectBoardCount(session);
	}
	
	@Override
	public List<Board> selectBoardPage(int cPage, int unmPerPage) {
		return dao.selectBoardPage(session, cPage, unmPerPage);
	}
	
}
