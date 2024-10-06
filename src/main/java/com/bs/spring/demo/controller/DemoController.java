package com.bs.spring.demo.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.spring.demo.model.vo.Address;
import com.bs.spring.demo.model.vo.DemoVO;

import lombok.Builder;


@Controller
public class DemoController {
	public DemoController() {}
	
	@RequestMapping("/demo/demo.do")	// <- 맵핑 메소드
	public String demo() {
		// ViewResolver로 인해 자동으로 앞에는 "/WEB-INF/views/"가 붙고, 뒤에는 .jsp가 붙는다.
		return "demo/demo";
	}
	
	
	// 클라이언트가 보낸 데이터는 매핑메소드의 매개변수를 선언해서 처리함
	// 1. HttpServletRequest : 요청정보를 저장하고 있는 객체
	// 2. HttpServletResponse : 응답정보를 저장하고 있는 객체 -> 응답처리
	// 3. HttpSession : Session 정보를 저장하는 객체(로그인처리 할때)
	// 4. java.util.Locale : 서버에 로케일 정보를 저장하는 객체 -> 실행하는 지역에 대한 ko_KR
	// 5. InputStream/Reader : 데이터를 서버로 읽어오는 객체 -> read()
	// 6. OutputStream/Writer : 데이터를 서버에서 클라이언트에 보내는 객체 -> write()
	// 7. 기본 자료형 변수(int, double, String) : 클라이언트가 보내는 데이터 name값과 일치하게 선언 -> 자동으로 저장시켜줌
	// 8. VO클래스타입 : 클라이언트가 보낸 다수의 데이터를 저장하는 객체 -> 필드명하고 name값이 일치할 때 자동저장
	// * Date, 다른 클래스들... spring이 처리하지 못하는 것은 403 BadRequest에러를 발생!
	// 9. java.util.Map : 클라이언트가 보낸 데이터를 key:value 형식으로 데이터를 저장해줌
	// * 주의! 단일값으로 저장 -> 복수값은 해결이 안됨.
	// 매개변수 앞에 사용하는 annotation
	// @RequestParam : 클라이언트가 보낸 데이터를 저장할 때 추가 옵션을 설정할 수 있는 어노테이션
	// @RequestBody : 클라이언트가 보낸 데이터 방식이 JSON방식일때 자바클래스로 변경해서 저장해주는 어노테이션
	// @SessionAttribute : HttpSession에 저장된 특정값을 가져올 때
	// @ModelAttribute : Model 객체에 데이터를 저장
	// @CookieValue : Cookie에 저장된 특정값을 가져올 때
	// @RequestHeader : RequestHeader에 특정 헤더값을 가져올 때 사용
	
	// 서블릿 방식대로 처리하기
	@RequestMapping("/demo/demo1.do")
	public String servletParamTest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		System.out.println(request);
//		System.out.println(response);
//		System.out.println(session);
		
		String name = request.getParameter("devName");
		int age = Integer.parseInt(request.getParameter("devAge"));
		String email = request.getParameter("devEmail");
		String gender = request.getParameter("devGender");
		
		// 다중값을 가져올 때는 getParamterValues() 메소드를 이용
		// String[]를 반환
		
		String [] hobby = request.getParameterValues("devLang");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("이메일 : " + email);
		System.out.println("개발 언어 : " + Arrays.toString(hobby));
		
		DemoVO demo = new DemoVO();
		demo.setDevName(name);
		demo.setDevAge(age);
		demo.setDevGender(gender);
		demo.setDevLang(hobby);
		
		request.setAttribute("demo", demo);
		return "demo/demoResult";
	}
	
	// 클라이언트 요청주소 /demo/demo2 인 서비스 만들기
	// /WEB-INF/views/demo/demo
	// Spring 방식으로 request를 받아서 출력함
	@RequestMapping("/demo/demo2")
	public String demo2_1(String devName, int devAge, String devEmail, String devGender, String[] devLang) {
		System.out.println(devName);
		System.out.println(devAge);
		System.out.println(devEmail);
		System.out.println(devGender);
		System.out.println(Arrays.toString(devLang));
		
		DemoVO d = DemoVO.builder().devName(devName).devAge(devAge).devEmail(devEmail).build();
			
		Model model = null;
		model.addAttribute("demo", d);
		
		return "demo/demo";
	}
	
	// 파라미터값에 대한 상세설정하기
	// @RequestParam annotation을 이용
	// 파라미터값을 매핑, 기본값 필수값여부를 설정
//	@RequestMapping("/demo/demo3")
//	public String demo3(
//			@RequestParam(name="name") String devName,
//			@RequestParam(defaultValue = "10", required = false) int devAge,
//			@RequestParam String devEmail,
//			@RequestParam String[] devLang,
//			@RequestParam double devHeight,
//			@RequestParam Date brithDay
//	) {
//		 // DemoVO demoVO = new DemoVO(devName, devAge, devEmail, devLang, devHeight, brithDay);
//		 System.out.println();
//		
//		return "demo/demo";
//	}
	
	// 객체자체로 마라미터값을 받아오기
	// 파라미터의 name값과 class의 필드값이 일치해야 함.
	@RequestMapping("/demo/demo4")
	public String demo4(DemoVO demoVO, Address address) {	
		System.out.println(demoVO + ", " + address);
		demoVO.getMyaddress();
		System.out.println(demoVO.getMyaddress());
		return "demo/demo";
	}
	
	// 파라미터 데이터 Map형식으로 받아서 처리하기
	// jsp에 출력할 데이터 전달하기
	@RequestMapping("/demo/demo5")
	public String demo5(@RequestParam Map param) {
		System.out.println(param);
		return "demo/demo";
	}

	
	
}
