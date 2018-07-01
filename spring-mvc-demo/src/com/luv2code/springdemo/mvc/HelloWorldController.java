package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//Need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//Need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String thename=request.getParameter("studentname");
		thename=thename.toUpperCase();
		String result="YO -- " +thename+" !";
		model.addAttribute("message",result);
		return "helloworld";
	}
	// @RequestParam Annotation 
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentname")String thename, Model model) {
		thename=thename.toUpperCase();
		String result="Hey this is Request Param " +thename+" !";
		model.addAttribute("message",result);
		return "helloworld";
	}
}
