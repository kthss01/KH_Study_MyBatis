package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;

public interface BoardService {

	int getListCount() throws Exception;

	ArrayList<Board> selectList(PageInfo pi) throws Exception;

}
