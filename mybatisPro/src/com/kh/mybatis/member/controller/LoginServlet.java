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
 * Servlet implementation class loginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService = new MemberServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		Member loginUser;
		
		try {
			loginUser = memberService.loginMember(m);
//			System.out.println(loginUser);
			
			if (loginUser != null) {
				request.getSession().setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath());
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			request.setAttribute("msg", "로그인 실패");
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
