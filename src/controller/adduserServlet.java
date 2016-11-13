package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;

/**
 * Servlet implementation class adduserServlet
 */
@WebServlet("/add-user")
public class adduserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adduserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String phonenumber = request.getParameter("tfPhonenumber");
		String password = request.getParameter("tfPassword");
		String repassword = request.getParameter("tfRepassword");
		String name = request.getParameter("tfName");
		String role = request.getParameter("slRole");
		
		String status="";
		if ("".equals(phonenumber) || "".equals(password) || "".equals(repassword) || "".equals(name)
				|| "".equals(role)) {
			status="Data input empty";
		} else if(!password.equals(repassword)) {
			status="Password don't match";
		} else {
			int roleInt = Integer.parseInt(role);
			status = new UserBO().addUser(new User(phonenumber, password, name, roleInt));
		}
		HttpSession session = request.getSession();
		session.setAttribute("status", status);
		response.sendRedirect("register");
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
