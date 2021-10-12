package com.kh.mybatis.board.model.service;

import org.apache.ibatis.session.SqlSession;
import static com.kh.mybatis.common.Template.*;

import java.util.ArrayList;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.SearchCondition;

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

	@Override
	public ArrayList<Board> selectListCon(SearchCondition sc, PageInfo pi) throws Exception {
		SqlSession sqlSession = getSqlSession();

		ArrayList<Board> list = boardDao.selectListCon(sqlSession, sc, pi);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public int getListCountCon(SearchCondition sc) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int listCount = boardDao.getListCountCon(sqlSession, sc);
		
		sqlSession.close();
		
		return listCount;
	}


	@Override
	public Board selectBoard(int bno) throws Exception {
		SqlSession sqlSession = getSqlSession();

		int result = boardDao.updateCount(sqlSession, bno);
		
		Board b = null;
		if (result > 0) {
			sqlSession.commit();
			b = boardDao.selectBoard(sqlSession, bno);
		} else {
			sqlSession.rollback();
			throw new Exception("updateCount error");
		}
		
		sqlSession.close();
		
		return b;
	}

}
