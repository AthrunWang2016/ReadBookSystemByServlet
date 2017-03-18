package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.imp.BookInfoSerImp;
import com.servise.BookInfoServise;
import com.tool.SystemLogOut;

public class BookInofServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookInofServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SystemLogOut.getInstance().setPrintOut(false);
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		
		String servletPath=request.getServletPath();
		
		SystemLogOut.getInstance().printOut(servletPath);
		
		if("/book/allInfo".equals(servletPath))
			askAll(request,response);
		else if("/book/theInfo".equals(servletPath))
			askOne(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void askOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookInfoSerImp bookInfoSerImp = new BookInfoServise();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		
		HashMap<String, String> which = new HashMap<String, String>();
		//which.put("1", "1");
		
		if(id!=null){
			which.put("id", id);
		}
		if(name!=null){
			which.put("name", name);
		}
		if(num!=null){
			which.put("num", num);
		}
		String msg = bookInfoSerImp.queryInfo(which);
		
		SystemLogOut.getInstance().printOut(msg);
		
		PrintWriter out = response.getWriter();
		out.println(msg);
		out.flush();
		out.close();
	}

	private void askAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookInfoSerImp bookInfoSerImp = new BookInfoServise();
		String msg = bookInfoSerImp.queryInfo(null);
		
		PrintWriter out = response.getWriter();
		out.println(msg);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
