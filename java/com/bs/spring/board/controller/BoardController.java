package com.bs.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.spring.model.service.BoardService;
import com.bs.spring.model.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/board/boardList.do")
	public String boardList(
			@RequestParam(defaultValue = "1") int cPage,
			@RequestParam(defaultValue = "5") int numPerPage,
			Model m
	) {
		// DB의 board테이블에 있는 데이터를 가져오기
//		List<Board> boardList = service.selectBoardList();
//		System.out.println(boardList);
		int totalBoard = service.selectBoardCount();
		System.out.println(totalBoard);
	
		// 페이지처리한 데이터 받아오기
		List<Board> boardList = service.selectBoardPage(cPage, numPerPage);
		
		// 화면구성하기
		m.addAttribute("boardCount", totalBoard);
		m.addAttribute("boardList", boardList);
		
		// 페이지바 생성하기
		String pageBar = "";
		int totalPage = (int)Math.ceil((double)totalBoard/ numPerPage);
		int pageBarSize = 5;
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize - 1;
		
		pageBar = "<ul class='pagination justify-content-center pagination-sm'>";
		if (pageNo == 1) {
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#'>이전</a>";
			pageBar += "</li>";
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href='javascript:fn_paging("+ (pageNo - 1) + ")'>이전</a>";
			pageBar += "</li>";
		}
		
		while (!(pageNo > pageEnd || pageNo > totalPage)) {
			if (pageNo == cPage) {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href='#'>"+ pageNo +"</a>";
				pageBar += "</li>";
			}
			else {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href='javascript:fn_paging("+ (pageNo) + ")'>"+ pageNo +"</a>";
				pageBar += "</li>";
			}
			pageNo++;
		}
		
		if (pageNo > totalPage) {
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#'>다음</a>";
			pageBar += "</li>";
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href='javascript:fn_paging("+ pageNo + ")'>다음</a>";
			pageBar += "</li>";
		}
		pageBar += "</ul>";
		pageBar += "<script>";
		pageBar += "function fn_paging(pageNo){";
		pageBar += "location.assign('/spring/board/boardList.do?cPage='+pageNo+'&numPerPage="+ numPerPage +"');";
		pageBar += "}";
		pageBar += "</script>";
		m.addAttribute("pageBar", pageBar);		
		
		return "board/boardlist";
	}
	
	@RequestMapping("/board/boardwriter.do")
	public String boardWriter() {
		return "board/boardwriter";
	}
	
	@RequestMapping("/boardView.do")
	public String boardView(int boardNo, Model model) {
		Board s = service.selectBoardByNo(boardNo);
		System.out.println(s);
		model.addAttribute("board", s);
		return "board/boardView";
	}
	
}
