package com.nagarro.assignment3.servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.assignment3.Entities.User;
import com.nagarro.assignment3.dao.FactoryProvider;
import com.nagarro.assignment3.dao.ProductDao;
import com.nagarro.assignment3.dao.UserDao;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("working");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao(FactoryProvider.Userfactory());
		User curUser = userDao.getUserByEmailAndPassword(email, password);

		HttpSession httpSession = request.getSession();
		System.out.println(curUser);
		if (curUser == null) {
			httpSession.setAttribute("message", "*Invalid Details !! Try with another one*");
			response.sendRedirect("login.jsp");
			return;
		} else {
			httpSession.setAttribute("current-user", curUser);
			if (curUser.getType().toLowerCase().equals("admin")) {
//				List<User> list=userDao.listAllUsers();
				response.sendRedirect("products.jsp");

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
