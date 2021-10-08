package com.kh.mybatis.board.model.service;

import org.apache.ibatis.session.SqlSession;
import static com.kh.mybatis.common.Template.*;

import java.util.ArrayList;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDao();
	
	@Override
	public int getListCount() throws Exception {
		SqlSession sqlSession = getSqlSession();

		int listCount = boardDao.getListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) throws Exception {
		SqlSession sqlSession = getSqlSession();

		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}

}
