package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BookfieldState;
import model.bo.BookfieldStateBO;
import model.bo.FieldBO;
import model.bo.TimepacketBO;

/**
 * Servlet implementation class managementfieldServlet
 */
@WebServlet("/manage-fields")
public class managefieldsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public managefieldsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Set to session list timepackets
		session.setAttribute("listTimepacket", new TimepacketBO().getListTimepacket());

		// Get today and set to session
		Calendar calendar = Calendar.getInstance();
		String today = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ calendar.get(Calendar.YEAR);

		// Get list bookfield state and set to request
		ArrayList<BookfieldState> listBookFieldState = new ArrayList<>();
		String day = today;
		int timepacket_id = 1;
		if (session.getAttribute("listBookfieldState") != null) {
			listBookFieldState = (ArrayList<BookfieldState>) session.getAttribute("listBookfieldState");
			session.removeAttribute("listBookfieldState");
		} else {
			listBookFieldState = new BookfieldStateBO()
					.getListBookFieldState(java.sql.Date.valueOf(calendar.get(Calendar.YEAR) + "-"
							+ (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE)), timepacket_id);
		}
		if (session.getAttribute("day") != null) {
			day = ((java.sql.Date) session.getAttribute("day")).toString();
			day = day.substring(8, day.length()) + "/" + day.substring(5, 7) + "/" + day.substring(0, 4);
			session.removeAttribute("day");
		}
		
		if (session.getAttribute("timepacket_id") != null) {
			timepacket_id = (int) session.getAttribute("timepacket_id");
			session.removeAttribute("timepacket_id");
		}
		
		if (session.getAttribute("actionReport") != null) {
			String actionReport=(String)session.getAttribute("actionReport");
			request.setAttribute("actionReport", actionReport);
			session.removeAttribute("actionReport");
		}

		
		request.setAttribute("day", day);
		request.setAttribute("timepacket_id", timepacket_id);
		request.setAttribute("listBookFieldState", listBookFieldState);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/manage-fields.jsp").forward(request, response);
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
