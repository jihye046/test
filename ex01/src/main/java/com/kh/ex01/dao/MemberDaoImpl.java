package com.kh.ex01.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ex01.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	private static String NAMESPACE = "com.kh.ex01.memberMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public String readTime() throws Exception {
		String time = sqlSession.selectOne(NAMESPACE + "getTime");
		return time;
	}

	@Override
	public void createMember(MemberVo vo) throws Exception {
		int count = sqlSession.insert(NAMESPACE + "insertMember", vo); // mapper에서 매개변수를 필요로 하는 경우 해당 구문에서 넘겨주는 역할(현재 상황은 vo를 넘겨주고 있음)
		System.out.println("count:" + count);
	}

	@Override
	public MemberVo readMember(String userid) throws Exception {
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE + "selectMember", userid); // 한 명의 데이터(한 행) 반환 --> selectOne을 사용, 여러 행 반환 --> selectList
		return memberVo;
	}

	@Override
	public MemberVo readWithPw(String userid, String userpw) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE + "readWithPw", map);
		return memberVo;
	}

}
