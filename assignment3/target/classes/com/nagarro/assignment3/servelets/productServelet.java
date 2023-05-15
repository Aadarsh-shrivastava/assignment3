package com.nagarro.assignment3.servelets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nagarro.assignment3.Entities.Product;
import com.nagarro.assignment3.dao.FactoryProvider;
import com.nagarro.assignment3.dao.ProductDao;

/**
 * Servlet implementation class productServelet
 */
@MultipartConfig(maxFileSize = 162342)
public class productServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String quantity = request.getParameter("quantity");
		String size = request.getParameter("size");
		String image = request.getParameter("image");
		System.out.println();
		Product product=new Product();
		

		Part part=request.getPart("image");
		String img=(part.getSubmittedFileName());
		product.setTitle(title);
		product.setSize(Integer.parseInt(size));
		product.setQuantiity(Integer.parseInt(quantity));
		product.setImage(img);
		
		ProductDao pdao=new ProductDao(FactoryProvider.Productfactory());
		pdao.saveProduct(product);
		try {
			
			String path="C:/Users/aadarshshrivastava/eclipse-workspace/assignment3/src/main/webapp/images/"+part.getSubmittedFileName();
			System.out.println(path);
			FileOutputStream fos= new FileOutputStream(path);
			
			InputStream is= part.getInputStream();
			
			
			byte[] data=new byte[is.available()];
			is.read(data);
			
			//writing the data
			fos.write(data);
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> list=pdao.listAllProducts();
		request.setAttribute("list", list);
		request.getRequestDispatcher("products.jsp").forward(request, response);
//		response.sendRedirect("products.jsp");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
