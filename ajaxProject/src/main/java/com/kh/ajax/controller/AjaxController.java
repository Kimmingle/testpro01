package com.kh.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	//HttpServletResponse 객체로 응답데이터응 응랍하기
	/*
	
	@GetMapping("ajax1.do")
	public void calSum(String menu, int amount, HttpServletResponse response) throws IOException {
		
		System.out.println("사용자가 입력한 메뉴 :" +menu);
		System.out.println("사용자가 입력한 수량 :" +amount);
		
		
		int price = 0;
		
		
		switch(menu) {
			
		case "알밥" : price=1000; break;
		case "돈까스" : price=2000; break;
		case "서브웨이" : price=3000; break;
		case "김치찜" : price=4000; break;
		case "막국수" : price=5000; 
		
		
		}
		
		price *= amount;
		//System.out.println(price);
		
		//서비스 다녀와서 요청처리 끝남
		//price 반환할 데이터임
		
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(price);
	}
	
	
	*
	*/
	
	
	@ResponseBody
	@GetMapping(value="ajax1.do", produces="text/html; charset=UTF-8")
	public String calSum(String menu, int amount) {

		int price = 0;
		
		
		switch(menu) {
			
		case "알밥" : price=1000; break;
		case "돈까스" : price=2000; break;
		case "서브웨이" : price=3000; break;
		case "김치찜" : price=4000; break;
		case "막국수" : price=5000; 
		
		
		}
		
		price *= amount;
		
		//price는 int지만 return을 String으로 해야함
		return String.valueOf(price);
		
	}
	
	
	
}
