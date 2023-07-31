package com.kh.ex01.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {
	
//	@Inject
	@Autowired // 자동 주입
	private WebApplicationContext wac;
	
	private MockMvc mockMvc; // 웹 서버 역할(ex.톰캣)
	
	// testDoA()를 진행하기 전 사전 작업, Before 지정해주어야함
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		System.out.println("mockMvc:" + mockMvc);
	}
	
	@Test // 테스트를 할 때 지정
	public void testWac() { // 파라미터가 있으면 안됨
		System.out.println("wac:" + wac);
	}
	
	@Test
	public void testDoA() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
	}
}
