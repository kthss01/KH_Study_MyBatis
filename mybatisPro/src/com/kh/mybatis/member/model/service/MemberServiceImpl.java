package com.kh.mybatis.member.model.service;

import static com.kh.mybatis.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao = new MemberDao();

	@Override
	public Member loginMember(Member m) throws Exception {
		SqlSession sqlSession = getSqlSession();

		Member loginUser = memberDao.loginMember(sqlSession, m);

		sqlSession.close();

		return loginUser;
	}

	@Override
	public void insertMember(Member m) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int result = memberDao.insertMember(sqlSession, m);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
			throw new Exception();
		}

		sqlSession.close();
	}

	@Override
	public Member updateMember(Member m) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int result = memberDao.updateMember(sqlSession, m);

		Member updateMem = null;

		if (result > 0) {
			sqlSession.commit();
			updateMem = memberDao.selectMember(sqlSession, m.getUserId());
		} else {
			sqlSession.rollback();
			throw new Exception();
		}

		sqlSession.close();

		return updateMem;
	}

	@Override
	public Member updatePwd(String userId, String userPwd, String newPwd) throws Exception {
		SqlSession sqlSession = getSqlSession();

		Member updateMem = null;

		int result = memberDao.updatePwd(sqlSession, userId, userPwd, newPwd);

		if (result > 0) {
			sqlSession.commit();
			updateMem = memberDao.selectMember(sqlSession, userId);
		} else {
			sqlSession.rollback();
			throw new Exception();
		}

		sqlSession.close();

		return updateMem;
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int result = memberDao.deleteMember(sqlSession, userId);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
			throw new Exception();
		}

		sqlSession.close();
	}

}
