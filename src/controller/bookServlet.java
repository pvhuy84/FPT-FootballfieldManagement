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
 * Servlet implementation class bookServlet
 */
@WebServlet("/book")
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionReport="Not success";
		String field_id = request.getParameter("field");
		String bookerPhonenumber = request.getParameter("booker");
		int timepacket_id = Integer.parseInt(request.getParameter("timepacket"));
		String day = request.getParameter("day");
		
		actionReport = new BookfieldBO().book(field_id, bookerPhonenumber, timepacket_id, day);
		String sqlDay = day.substring(6, day.length()) + "-" + day.substring(3, 5) + "-" + day.substring(0, 2);
		HttpSession session = request.getSession();
		session.setAttribute("actionReport", actionReport);
		session.setAttribute("timepacket_id", timepacket_id);
		session.setAttribute("day", java.sql.Date.valueOf(sqlDay));
		response.sendRedirect("manage-fields");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
