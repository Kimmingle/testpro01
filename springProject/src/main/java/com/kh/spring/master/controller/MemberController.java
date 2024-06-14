package com.kh.spring.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.extern.slf4j.Slf4j;


//@controller: 범용적인 컨트롤러

@Controller
@Slf4j
public class MemberController {
	
	@RequestMapping("/login.do")  //request mapping 타입의 handlermapping 등록
	public void login() {
		log.info("로그인 요청 보냄?");
	}
	
}