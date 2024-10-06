package com.bs.spring.sign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignIn {
	public SignIn() {}
	
	@RequestMapping("/member/sign-in.do")
	public String sign_In() {
		System.out.println("sign in 함수 실행 완료");
		return "member/sign-in";
	}
	
	@RequestMapping("/member/sign-up.do")
	public String sign_Up() {
		System.out.println("sign up 함수 실행 완료");
		return "member/sign-up";
	}
}
