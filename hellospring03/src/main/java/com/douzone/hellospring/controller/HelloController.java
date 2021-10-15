package com.douzone.hellospring.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	
	 @RequestMapping("/hello")
     public String hello() {
    	 return "/WEB-INF/views/hello.jsp";
     }
	 
	 @RequestMapping("/hello2")
 //    public String hello2(@RequestParam("n") String name) {  //파라미터지정가능
	 public String hello2( String name) {  //name 이름의 파라미터 넘어옴
		 System.out.println(name);
    	 return "/WEB-INF/views/hello2.jsp";
     }
	 
	 @RequestMapping("/hello3")
     public ModelAndView hello3(String name) { //모델 뷰 같이 담긴 mav  반환 
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("name", name);
		 mav.setViewName("/WEB-INF/views/hello3.jsp");
		 	 
    	 return mav;
     }
	 
	 @RequestMapping("/hello4")
     public String hello4(String name, Model model) { //모델을 따로  받음
		 model.addAttribute("name",name);
		 	 
    	 return "/WEB-INF/views/hello3.jsp";
     }
	 
	 
	 @ResponseBody                                   //이 메소드가 직접 리스폰스  메세지컨버터가 받아서 처리
	 @RequestMapping("/hello5")
     public String hello5() {
    	 return "<h1>한글 hello message test</h1>";
     }
	 
	                                
	 @RequestMapping("/hello6")
     public String hello6() { 
		 System.out.println("hello6() called");
    	 return "redirect:/hello";                    //스프링이 알아서 hellospring03 붙인다 기술기술기술
     }
}
