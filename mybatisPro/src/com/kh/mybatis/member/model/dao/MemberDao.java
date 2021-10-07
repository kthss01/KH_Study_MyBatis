package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) throws Exception {
		Member loginUser = null;
		
		loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		
		return loginUser;
	}

}
