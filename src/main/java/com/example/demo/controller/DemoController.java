package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienInterface;
import com.example.demo.dao.AlienRepo;
import com.example.demo.otherClass.Alien;

@Controller
public class DemoController {
	
	@Autowired
	AlienRepo repo;
	
	public Iterable<AlienInterface> getAll() {
		return repo.findAll();
	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		Iterable<AlienInterface> ai=getAll();
		ModelAndView mv=new ModelAndView();
		mv.addObject("alienRecord",ai);
		mv.setViewName("home");
		return mv;
	}
	
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
	
	@RequestMapping("home3")
	public ModelAndView home3(Alien alien) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("obj",alien);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("addAlien")
	public ModelAndView addAlien(AlienInterface alien) {
		repo.save(alien);
		ModelAndView mv=new ModelAndView();
		mv.addObject("obj",alien);
		Iterable<AlienInterface> ai=getAll();
		mv.addObject("alienRecord",ai);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("getDetails/{id}")
	public ModelAndView getDetails(@PathVariable("id")Integer id) {
		Optional<AlienInterface> detail = repo.findById(id);
		ModelAndView mv=new ModelAndView();
		if(detail.isPresent())
		{
			mv.addObject("detail",detail.get());
		}
		else {
			var err="Nothing found";
			mv.addObject("err",err);
		}
		mv.setViewName("getDetail");
		return mv;
	}
	
}
