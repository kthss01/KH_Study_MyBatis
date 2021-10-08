package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.common.Pagination;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount = 0;
		try {
			listCount = boardService.getListCount();
//			System.out.println(listCount);
			
			int currentPage = 1;
			
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int pageLimit = 10;
			int boardLimit = 5;
			
			PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
			
			ArrayList<Board> list = boardService.selectList(pi);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
