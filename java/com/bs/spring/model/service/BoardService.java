package com.bs.spring.model.service;

import java.util.List;

import com.bs.spring.model.vo.Board;

public interface BoardService {
	List<Board> selectBoardList();
	Board selectBoardByNo(int boardNo);
	List<Board> selectBoardByTitle(String title);
	
	List<Board> selectBoardPage(int cPage, int unmPerPage);
	
	int insertBoard(Board newBoard);
	int updateBoard(Board board);
	int deleteBoard(int boardNo);
	int selectBoardCount();
	
}
