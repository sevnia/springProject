package com.bs.spring.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bs.spring.model.vo.Board;

public interface  BoardDao {
	List<Board> selectBoardList(SqlSession session);
	Board selectBoardByNo(SqlSession session, int boardNo);
	List<Board> selectBoardByTitle(SqlSession session, String title);
	List<Board> selectBoardPage(SqlSession session, int cPage, int numPerPage);
	
	int insertBoard(SqlSession session, Board newBoard);
	int updateBoard(SqlSession session, Board board);
	int deleteBoard(SqlSession session, int boardNo);
	int selectBoardCount(SqlSession session);
}
