package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {
	//메소드 일반
	@RequestMapping(value="/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() { // 포워드할 주소 리턴할꺼라 String
		System.out.println("PhoneController>writeForm");
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>write");
		
		System.out.println(personVo);

		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		//리스트로 리다이렉트
		return "redirect:/phone/list";
	}	
	
	
	/* 요 일을 @ModelAttribute가 함.
	@RequestMapping(value = "/phone/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name, 
						@RequestParam("hp") String hp, 
						@RequestParam("company") String company) {
		System.out.println("PhoneController>write");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name,hp,company);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "";
	}
	*/
	
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController>list");
		
		//Dao에서 리스트 가져옴
		PhoneDao phoneDao = new PhoneDao() ;
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList);
		
		//컨트롤러에서 ds로 데이터 보냄
		model.addAttribute("personList", personList); //model
		
		return "/WEB-INF/views/list.jsp"; //view
	}
	
	
	

}
