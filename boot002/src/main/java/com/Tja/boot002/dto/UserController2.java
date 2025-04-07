package com.Tja.boot002.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController2 {

	@RequestMapping("/ex1")
	@ResponseBody
	public String basic1() {return"springboot";}
		//localhost:8282/boot2/ex1
	
	//@GetMapping("/ex2") 
	@RequestMapping("/ex2")
	public String basic2(Model model) {
	model.addAttribute("say","HI");
	return "HtmlEx";
	//localhost:8282/boot2/ex2
	}
	
	@RequestMapping("/test")
	public String basic3() {
		return "test";
	}
}
