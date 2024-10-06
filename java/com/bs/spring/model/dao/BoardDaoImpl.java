package com.bs.spring.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.spring.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> selectBoardList(SqlSession session) {
		return session.selectList("board.selectBoardList");
	}

	@Override
	public Board selectBoardByNo(SqlSession session, int boardNo) {
		return session.selectOne("board.selectBoardByNo", boardNo);
	}

	@Override
	public List<Board> selectBoardByTitle(SqlSession session, String title) {
		return null;
	}

	@Override
	public int insertBoard(SqlSession session, Board newBoard) {
		return 0;
	}

	@Override
	public int updateBoard(SqlSession session, Board board) {
		return 0;
	}

	@Override
	public int deleteBoard(SqlSession session, int boardNo) {
		return 0;
	}
	
	@Override
	public int selectBoardCount(SqlSession session) {
		return session.selectOne("board.selectBoardCount");
	}
	
	@Override
	public List<Board> selectBoardPage(SqlSession session, int cPage, int numPerPage) {
		Map<String, Integer> pageNum = new HashMap<>();
		pageNum.put("start", (cPage - 1) * numPerPage + 1);
		pageNum.put("end", cPage * numPerPage);
		return session.selectList("board.selectBoardPage", pageNum);
	}
	
}
