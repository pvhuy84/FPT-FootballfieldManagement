package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.BookfieldBO;

/**
 * Servlet implementation class adminDeleteServlet
 */
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		String actionReport="Not success";
		String field_id = request.getParameter("field");
		String day = request.getParameter("day");
		int timepacket_id = Integer.parseInt(request.getParameter("timepacket"));
		
		actionReport = new BookfieldBO().delete(field_id, timepacket_id, day);

		session.setAttribute("actionReport", actionReport);
		if(request.getParameter("phonenumber")==null) {
			String sqlDay = day.substring(6, day.length()) + "-" + day.substring(3, 5) + "-" + day.substring(0, 2);
			session.setAttribute("timepacket_id", timepacket_id);
			session.setAttribute("day", java.sql.Date.valueOf(sqlDay));
			response.sendRedirect("manage-fields");
		} else {
			response.sendRedirect("manage-fields-have-booked");
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
