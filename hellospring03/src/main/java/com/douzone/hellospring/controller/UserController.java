package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author user
 * @RequestMapping 클래스(타입) + 핸들러(메소드)
 * */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVo vo) {                          //스프링이 알아서 셋팅해준다
		System.out.println(vo);
		
		//new UserDao.insert(vo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update() {
		return "UserController.update()";
	}

}
