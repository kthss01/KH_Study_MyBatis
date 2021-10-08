package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.model.service.MemberService;
import com.kh.mybatis.member.model.service.MemberServiceImpl;
import com.kh.mybatis.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdatePwdServlet
 */
@WebServlet("/updatePwd.me")
public class MemberUpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberService memberService = new MemberServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
		
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
		
		Member updateMem;
		try {
			updateMem = memberService.updatePwd(userId, userPwd, newPwd);
			
			request.getSession().setAttribute("loginUser", updateMem);
			request.setAttribute("msg", "비밀번호 변경 성공");
			request.setAttribute("sTag", "Y");
			request.getRequestDispatcher("WEB-INF/views/member/pwdUpdateForm.jsp").forward(request, response);
		} catch (Exception e) {			
			request.setAttribute("msg", "비밀번호 변경 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			
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
