package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//컨트롤러가 해야할 일
//1. 데이터 가공
//2. 응답하여 지정

//@controller: 범용적인 컨트롤러

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
//	@RequestMapping("/login.do")  //request mapping 타입의 handlermapping 등록
//	public void login() {
//		log.info("로그인 요청 보냄?");
//	}
//	





/*
 * spring에서 Handler가 전달값을 받는 방법
 *  1.HttpServletRequest를 이용해서 전달받기 (기존의 JSP/Servlet방식)
 *  
 *  @RequestMapping("/login.do") 
	public String login(HttpServletRequest request){
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");
		
		log.info("회원이 입력한 아이디 값 : {}", userId);
		log.info("회원이 입력한 비밀번호 값 : {}", userPwd);
  		
  
  		return "main";
	}
 * 
 *  2.RequestParam 애노테이션을 이용하는 방법
 *   -- request.getParameter("키값")로 value를 뽑아오는 역할을 대신 해주는 애노테이션
 *   
 *  3. RequestParam애노테이션을 생략하는 방법
 *  -- 단, 매개변수 식별자를 jsp의 name속성값(요청시 전달하는 값의 키값)과 동일하게 작성해주어야만 자동으로 같이 주입됨
 *  	단점이라고한다면 2의 defaultValue속성을 사용할 수 없음
 *  
 *  
 *  @RequestMapping("/login.do") 
	public String login(String id, String pwd){
		
		log.info("회원이 입력한 아이디 값 : {}", id);
		log.info("회원이 입력한 비밀번호 값 : {}", pwd);
  		return "main";
	}
 *  
 */
//	@RequestMapping("/login.do") 
//	public String login(String id, String pwd){
//		
//		log.info("회원이 입력한 아이디 값 : {}", id);
//		log.info("회원이 입력한 비밀번호 값 : {}", pwd);
//		//1. 데이터 가공 -> DTO에 데이터를 담아서 보냄 member.java
//		Member member = new Member(); //Member타입으로 변수를 생성하여 기본 생성자로  
//		member.setUserId(id);
//		member.setUserPwd(pwd);
//		
//		//1.5 서비스 호출
//		memberService.login(id, pwd);
//		
//		//응답화면 지정
//  		return "main";
//	}
//	
	
	/*
	4. 커멘드 객체
	- 요청시 전달값을 담고자하는 클래스의 타입을 지정한 뒤
	- 요청 시 전달값의 키값(jsp의 name속성값) 을 클래스의 담고자하는 필드명과 동일하게 작성
	- 스프링 컨테이너가 해당 객체를 기본 생성자로 생성한 후 내부적으로 setter메소드를 찾아서 요청 시 
	*/
	
//	@RequestMapping("login.do")
//	public String login(Member member) {
//		log.info("가공된 멤버 객체 : {}", member);
//		
//		Member loginMember = memberService.login(member);  //member객체의 메모리 주소를 넘김
//		
//		return "main";
//	}
//	
	/*
	REST방식의 URL만들기
	-  localhost/spring/member/12
	
	
	@GetMapping("member/{id}")
	public void restTest(@PathVariable String id) {
		log.info("앞단에서 넘긴 값 : {}", id);
		
	}
	*/
	/*
	 * 요청 처리 후 응답 데이터를 담고 응답페이지로 포워딩 또는 리다이렉트 하는법
	 * 1. 스프링에서 제공하는 Model객체를 사용하는 방법
	 * - 포워딩할 응답뷰로 전달하고자하는 데이터를 키-벨류 형태로 담을 수 있는 영역
	 * - Model객체는 requestScope
	 * 
	@PostMapping("login.do")
	public String login(Member member, Model model, HttpSession session) {
		
		Member loginUser = memberService.login(member);
		if(loginUser == null) {  // 로그인 실패 =>에러문구 requestScope에 담아서 에러페이지로 포워딩
			model.addAttribute("errorMsg","로그인 실패");
			
			return "common/errorPage";
			
		} else {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}
		
		//실제로는 WEB-INF/views/main.jsp --접두사, 접미사 붙여짐
		//return "main";
		
	}
	*/


	@PostMapping("login.do")
	public ModelAndView login(Member member, ModelAndView mv, HttpSession session) {
		
		Member loginUser = memberService.login(member);
		
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		} else {
			session.setAttribute("errorMsg", "로그인 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
		
	}
	
	
	

}
