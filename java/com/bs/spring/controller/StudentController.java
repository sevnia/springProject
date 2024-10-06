package com.bs.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.spring.model.service.StudentService;
import com.bs.spring.model.vo.Student;

@Controller
public class StudentController {
	public StudentController() {}
	
	@Autowired
	private StudentService service;
	
//	@RequestMapping("/login.do")
//	public String studentTest() {
//		// DB의 student 테이블에 있는 데이터를 조회에서 응답하는 기능
//		
//		Student s = service.selectStudentById("admin");
//		System.out.println(s);	
//		
//		return "";
//	}
	
	@RequestMapping("/login.do")
	public String login(String userId, String pw, HttpSession session) {		
//		System.out.println(userId + ", " + pw);
		Student s = service.selectStudnetById(userId);
//		System.out.println(s);
		
		if (s != null && s.getStudentPwd().equals(pw)) {
			System.out.println("성공");
			session.setAttribute("loginStudent", s);
		} else {
			System.out.println("실패");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();	// session 삭제
		return "redirect:/";	// 화면 반전
	}
	
	@RequestMapping("/enrollstudent.do")
	public String enrollstudentPage() {
		return "student/enrollstudent";
	}
	
	@RequestMapping("/enrollendstudent.do")
	public String enrollEndStudent(Student student) {
		System.out.println(student);
		int result=service.insertStudent(student);
		System.out.println(result);		
		
		return "redirect:/";
	}
	
	@RequestMapping("/student/studentview.do")
	public String studentView(String id, Model m) {
		System.out.println("이름은 " + id);
		Student s = service.selectStudnetById(id);
		m.addAttribute("student", s);
		return "student/studentView";
	}
	
	@RequestMapping("/studnet/studnetList.do")
	public String studentListView(
			@RequestParam(defaultValue = "1") int cPage,
			@RequestParam(defaultValue = "5") int numPerPage,
			Model model
	) {
		List<Student> list = service.selectStudentAll();
		System.out.println(list);
		List<Student> totalBoard = service.selectStudentPage(cPage, numPerPage);
		
		String pageBar = "";
		int totalPage = (int)Math.ceil((double)numPerPage / numPerPage);
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
		model.addAttribute("pageBar1", pageBar);
		model.addAttribute("student", list);
		return "student/studentlist";
	}
	
}
