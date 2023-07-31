package com.kh.ex01.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.ex01.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoTest {
	
	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void testGetTime() throws Exception{
		String time = memberDao.readTime();
		System.out.println("time:" + time);
	}
	
	@Test
	public void testCreateMember() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setUserid("han");
		vo.setUserpw("1234");
		vo.setUsername("한길동");
		vo.setEmail("han@email.com");
		memberDao.createMember(vo);
	}
	
	@Test
	public void testSelectMember() throws Exception{
		MemberVo memberVo = memberDao.readMember("hong");
		System.out.println("memberVo:" + memberVo);
	}
	
	@Test
	public void testMembers() throws Exception{
		MemberVo memberVo = memberDao.readWithPw("hong", "1234");
		System.out.println("memberVo:" + memberVo);
	} 
	
	
}
