package com.bs.spring.my;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {
	public MyController() {
		System.out.println("잘 작동하는 지 확인 (MyController)");
	}
	
//	@Bean
//	@RequestMapping("/mypage")
//	public String n() {
//		return "mypage";
//	}
	
	@RequestMapping("/mypage")
	public void mypage() {}
	
}
