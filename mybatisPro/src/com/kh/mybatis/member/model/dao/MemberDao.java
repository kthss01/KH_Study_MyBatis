package com.kh.mybatis.member.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) throws Exception {
		Member loginUser = null;
		
		loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		
		return loginUser;
	}

	public int insertMember(SqlSession sqlSession, Member m) throws Exception {
		return sqlSession.insert("memberMapper.insertMember", m);
	}

	public int updateMember(SqlSession sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMember", m);
	}

	public Member selectMember(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.selectMember", userId);
	}

	public int updatePwd(SqlSession sqlSession, String userId, String userPwd, String newPwd) {
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		map.put("newPwd", newPwd);
		return sqlSession.update("memberMapper.updatePwd", map);
	}

	public int deleteMember(SqlSession sqlSession, String userId) {
		return sqlSession.delete("memberMapper.deleteMember", userId);
	}

}
