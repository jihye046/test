package com.kh.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public void doA() {
		System.out.println("doA 실행됨");
		// return "doA"; // /WEB-INF/views/doA.jsp
	}
	
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB() {
		System.out.println("doB 실행됨");
		return "do_b"; // value와 jsp 파일명이 일치해야하나, 불일치할 경우 String 타입으로 해주고 return은 jsp파일명으로 기재해줌, void 타입으로해주면 스프링이 알아서 value와 jsp의 파일명이 일치하는것으로 연동해줌
						// lib대신 pom.xml --> dependency에 기재
						// sevlet - context.xml --> beans 부분에서 객체 생성을 알아서 해줌
	}
}
