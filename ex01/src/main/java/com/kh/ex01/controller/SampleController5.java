package com.kh.ex01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ex01.vo.ProductVo;

@Controller
public class SampleController5 {
	
	// 주소 : localhost/doJSON
	@RequestMapping(value = "/doJSON", method = RequestMethod.GET)
	@ResponseBody // fom.xml에 dependency 마지막 태그 부분 추가 후 사용
	public ProductVo doJSON() {
		ProductVo productVo = new ProductVo("샘플 상품", 30000);
		return productVo; 
	}
	
	// 주소 : localhost/doJSONList
	@RequestMapping(value = "/doJSONList", method = RequestMethod.GET)
	@ResponseBody  
	public List<ProductVo> doJSONList() {
		List<ProductVo> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			ProductVo productVo = new ProductVo("샘플 상품 - " + i, (i * 10000));
			list.add(productVo);
		}
		return list; 
	}
}
