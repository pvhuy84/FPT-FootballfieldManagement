package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BookfieldState;
import model.bo.BookfieldStateBO;

/**
 * Servlet implementation class getBookfieldStateServlet
 */
@WebServlet("/get-book-field-state")
public class getBookfieldStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBookfieldStateServlet() {
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
		
		int timepacket_id=Integer.parseInt(request.getParameter("listtimepacket"));
		String day=request.getParameter("day");
		Date sqlDay = Date.valueOf(day.substring(6, day.length()) + "-" + day.substring(3, 5) + "-" + day.substring(0, 2));
		ArrayList<BookfieldState> listBookfieldState = new ArrayList<>();
		listBookfieldState = new BookfieldStateBO().getListBookFieldState(sqlDay, timepacket_id);
		session.setAttribute("day", sqlDay);
		session.setAttribute("timepacket_id", timepacket_id);
		session.setAttribute("listBookfieldState", listBookfieldState);
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
