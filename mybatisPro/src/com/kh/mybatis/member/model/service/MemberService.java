package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {

	Member loginMember(Member m) throws Exception;

	void insertMember(Member m) throws Exception;

	Member updateMember(Member m) throws Exception;
	
	Member updatePwd(String userId, String userPwd, String newPwd) throws Exception;

	void deleteMember(String userId) throws Exception;

}
