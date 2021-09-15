package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	//same functionality with three different methods.
	@RequestMapping("home")
	public String home(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String name=req.getParameter("name");
		System.out.println("Hi " + name);
		
		session.setAttribute("name", name);
		return "home";
	}
	
	@RequestMapping("home1")
	public String home1(@RequestParam("name") String myName, HttpSession session) {
		session.setAttribute("name", myName);
		return "home";
	}
	
	@RequestMapping("home2")
	public ModelAndView home2(@RequestParam("name") String myName) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home");
		return mv;
	}
	
}
