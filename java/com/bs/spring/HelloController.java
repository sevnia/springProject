package com.bs.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	// <- 컨트롤러가 스프링 빈으로 등록함
public class HelloController {
	
	public HelloController() {}	// 기본생성자

	@RequestMapping("/")
	public String mainpage() {
//		System.out.println("mainpage method 실행");
		// /WEB-INF/views/index.jsp
		return "index";
	}
	
	@RequestMapping("/main")
	public String met() {
//		System.out.println("잘 작동함");
		return "main";	// <- 문자열의 뒤에 .jsp라는 확장자를 붙여줌
	}
	
	
	
	
	
	
	
	
}
