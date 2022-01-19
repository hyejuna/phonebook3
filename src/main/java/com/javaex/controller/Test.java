package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 톰캣에게 이 파일이 컨토를러임을 알려줌. -> 이걸 미리 확인해서 주소 확인
@RequestMapping (value = "/board")
public class Test {
	//메소드 일반
	@RequestMapping( value = "/list", method= {RequestMethod.GET, RequestMethod.POST}) // 주소 정함. 약식은 ("/list"), 
	public String TestPrint(){
		System.out.println("TestPrint");	
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	
	@RequestMapping( value="/writeForm", method=RequestMethod.GET)
	public String TestPrint2(){
		System.out.println("TestPrint2");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping( value="/write", method=RequestMethod.GET)
	public String TestPrint3(){
		System.out.println("TestPrint3");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
}
