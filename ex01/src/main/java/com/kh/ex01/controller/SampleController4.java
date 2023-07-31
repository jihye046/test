package com.kh.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	// http://localhost/doE -> doF > doF.jsp
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public String doE(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg", "hello");
		// session.setAttribute("msg", "hello")
		//      -> session.removeAttribute("msg")
		return "redirect:/doF";
	}
	
	@RequestMapping(value = "/doF" , method = RequestMethod.GET)
	public void doF() {
		
	}
}
