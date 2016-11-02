package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.checkLoginBO;
import model.bo.getDataBO;

/**
 * Servlet implementation class checkLoginServerlet
 */
public class checkLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("tfUsername");
		String password = request.getParameter("tfPassword");

		String errorReport = "";

		if ("".equals(username) || "".equals(password)) {
			errorReport = "Required username and password!";
			request.setAttribute("errorReport", errorReport);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if (checkLoginBO.checkAccount(username, password) == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("homeAdminServlet");
			rd.forward(request, response);
		} else if (checkLoginBO.checkAccount(username, password) == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("homeCustomer.jsp");
			rd.forward(request, response);
		} else {
			errorReport = "username or password invalid";
			request.setAttribute("errorReport", errorReport);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
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
