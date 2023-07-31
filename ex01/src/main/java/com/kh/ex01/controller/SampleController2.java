package com.kh.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.ex01.vo.ProductVo;

@Controller
public class SampleController2 {

	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC(@ModelAttribute("msg")  String msg) {
		System.out.println("msg:" + msg);
		return "doC";
	}
	
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public String doD(Model model) {
		// Model: Request보다 크기가 작은 데이터 바구니
		ProductVo productVo = new ProductVo("Sample Product", 10000);
		model.addAttribute(productVo); // 키가 생략, 객체 데이터를 전달해야하는 경우 addAttribute()를 이용해서 보관/전달
		// -> 이름이 없으면 클래스의 첫글자를 소문자로 한 이름("productVo")으로 저장
		return "doD";
		
	}
}
