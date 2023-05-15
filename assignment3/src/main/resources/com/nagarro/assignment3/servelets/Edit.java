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
 * Servlet implementation class Edit
 */
@MultipartConfig(maxFileSize = 162342)
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
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
		System.out.println("its working till here");
		String title = request.getParameter("title");
		String image = request.getParameter("image");
		int id=Integer.parseInt(request.getParameter("id")) ;
		int quantity=Integer.parseInt(request.getParameter("quantity")) ;
		int size=Integer.parseInt(request.getParameter("size")) ;
		System.out.println(title+quantity+id+image+size);
	

		Part part = request.getPart("image");
		String img = (part.getSubmittedFileName());
		Product product=new Product();
		product.setTitle(title);
		product.setId(id);
		product.setSize(size);
		product.setQuantiity(quantity);
		product.setImage(img);
		
		ProductDao pdao=new ProductDao(FactoryProvider.Productfactory());
		pdao.saveProduct(product);

		try {

			String path = "C:/Users/aadarshshrivastava/eclipse-workspace/assignment3/src/main/webapp/images/"
					+ part.getSubmittedFileName();
			System.out.println(path);
			FileOutputStream fos = new FileOutputStream(path);

			InputStream is = part.getInputStream();

			byte[] data = new byte[is.available()];
			is.read(data);

			// writing the data
			fos.write(data);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Product> list = pdao.listAllProducts();
		response.sendRedirect("products.jsp");
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("products.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
