package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String join(UserVo vo) {                          //스프링이 알아서 셋팅해준다 request안에 셋팅된 속성의 이름이 같아야한다
		System.out.println(vo);
		
		//new UserDao.insert(vo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/**
		 * 만일 n이라는 이름의 파라미터가 없는 경우
		 * 400 bad request 에러가 발생한다.
		 */
		System.out.println(name);
		return "UserController.update()";
	}

	@ResponseBody
	@RequestMapping("/update2")
	//public String update2(@RequestParam(value="n", required=false) String name) {  //required=false 값이 없어도 된다
	public String update2(
			@RequestParam(value="n", required=true, defaultValue="") String name, 
			@RequestParam(value="a", required=true, defaultValue="0") int age) {  //디폴트값지정	
		System.out.println(name);
		System.out.println(age);
		return "UserController.update()";
	}
}
