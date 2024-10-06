package com.bs.spring.student.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.spring.demo.model.vo.DemoVO;
import com.bs.spring.model.service.StudentService;
import com.bs.spring.model.vo.Student;

@Controller
public class StudentController0 {
	public StudentController0() {}
	@Autowired
	private StudentService service;
	
	@RequestMapping("/testStudent")
	public String studentTest() {
		//DB의 Student테이블에 있는 데이터를 조회해서 응답하는 기능
		Student s= service.selectStudnetById("admin");
		System.out.println(s);
		return "";	
	}
	
	@RequestMapping("/student/student.do")
	public String studentCon() {
		return "student/student";
	}
	
//	@RequestMapping("/student/enrollstudent.do")
//	public String student(String name, String age, String agec, String cl, String c) {		
//		
//		StudentVO studentVO = new StudentVO();
//		studentVO.setName(name);
//		studentVO.setAge(age);
//		studentVO.setAgec(agec);
//		studentVO.setCl(cl);
//		studentVO.setC(c);
//		
//		return "/student/studentend";
//	}
	
	@RequestMapping("/student/enrollstudent.do")
	public String servletParamTest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String agec = request.getParameter("agec");
		String cl = request.getParameter("cl");
		String c = request.getParameter("c");
		
		StudentVO svo = new StudentVO();
		svo.setName(name);
		svo.setAge(age);
		svo.setAgec(agec);
		svo.setCl(cl);
		svo.setC(c);
		
		request.setAttribute("student", svo);
		return "student/studentend";
	}
	
	
}
