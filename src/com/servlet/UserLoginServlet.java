package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.factory.InfoDaoFactory;
import com.dao.imp.PeopleInfoDaoImp;
import com.dao.imp.PeopleInfoSerImp;
import com.entity.PeopleEntity;
import com.servise.UserInfoServise;
import com.tool.SystemLogOut;

public class UserLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserLoginServlet() {
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
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
		doPost(request, response);
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

		SystemLogOut.getInstance().setPrintOut(false);
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		PeopleInfoDaoImp peopleInfoDaoImp= InfoDaoFactory.getInstance().peopleCreator();
		/*PeopleInfoDaoImp peopleInfoDaoImp = null;
		try {
			peopleInfoDaoImp = (PeopleInfoDaoImp) InfoDaoFactory.getInstance().creator("PeopleInfoDao");
		} catch (Exception e) {
			SystemLogOut.getInstance().printOut(e.getMessage());
		}*/
		HttpSession session = request.getSession();
		String userID = request.getParameter("username");
		String password = request.getParameter("password");
		
		/*PrintWriter out = response.getWriter();
		if(userID == null || password == null || userID.isEmpty() || password.isEmpty()){
			request.getRequestDispatcher("../index.jsp").forward(request, response);
			return;
		}
		
		HashMap<String, String> which = new HashMap<String, String>();
		which.put("name", userID);
		which.put("password", password);
		PeopleEntity peopleEntity = peopleInfoDaoImp.queryInfo(which);
		
		if(peopleEntity == null){
			out.println("<script language=javascript>alert('’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°');history.go(-1);</script>");
			out.flush();
			out.close();
			return;
		}
		out.println("<script language=javascript>history.go(-1);</script>");
		out.flush();
		out.close();
		session.setAttribute("peopleEntity", peopleEntity);
		request.getRequestDispatcher("../bookIndex.jsp").forward(request, response);*/
		HashMap<String, String> which = new HashMap<String, String>();
		which.put("name", userID);
		which.put("password", password);
		PeopleInfoSerImp peopleInfoSerImp = new UserInfoServise();
		String msg = peopleInfoSerImp.queryInfo(which);
		
		PrintWriter out = response.getWriter();
//		out.println("\"result\":\"true\"");
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
