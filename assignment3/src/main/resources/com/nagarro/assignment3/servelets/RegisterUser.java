package com.nagarro.assignment3.servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.assignment3.Entities.User;
import com.nagarro.assignment3.dao.FactoryProvider;
import com.nagarro.assignment3.dao.ProductDao;
import com.nagarro.assignment3.dao.UserDao;

/**
 * Servlet implementation class AddProduct
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    private Session session;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User newUser=new User();
		newUser.setName(request.getParameter("name"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setType(request.getParameter("type"));

		UserDao userDao=new UserDao(FactoryProvider.Userfactory());
		userDao.saveUser(newUser);
		response.sendRedirect("login.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
