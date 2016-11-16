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
import model.bo.TimepacketBO;

/**
 * Servlet implementation class bookFieldServlet
 */
@WebServlet("/book-field")
public class bookFieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bookFieldServlet() {
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
		if (session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}

		session.setAttribute("listTimepacket", new TimepacketBO().getListTimepacket());
		// Get today
		Calendar calendar = Calendar.getInstance();
		String today = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ calendar.get(Calendar.YEAR);

		String day = today;
		int timepacket_id = 1;
		if (session.getAttribute("day") != null) {
			day = ((java.sql.Date) session.getAttribute("day")).toString();
			day = day.substring(8, day.length()) + "/" + day.substring(5, 7) + "/" + day.substring(0, 4);
			session.removeAttribute("day");
		}

		if (session.getAttribute("timepacket_id") != null) {
			timepacket_id = (int) session.getAttribute("timepacket_id");
			session.removeAttribute("timepacket_id");
		}

		ArrayList<BookfieldState> listBookFieldEmpty = new ArrayList<>();

		if (session.getAttribute("listBookFieldEmpty") != null) {
			listBookFieldEmpty = (ArrayList<BookfieldState>) session.getAttribute("listBookFieldEmpty");
			session.removeAttribute("listBookFieldEmpty");
		} else {
			listBookFieldEmpty = new BookfieldStateBO()
					.getListBookFieldEmpty(Date.valueOf(day.substring(6, day.length()) + "-" + day.substring(3, 5) + "-" + day.substring(0, 2)), timepacket_id);
		}
//		} else {
//			listBookFieldEmpty = new BookfieldStateBO()
//					.getListBookFieldEmpty(java.sql.Date.valueOf(calendar.get(Calendar.YEAR) + "-"
//							+ (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE)), timepacket_id);
//		}
		
		if (session.getAttribute("actionReport") != null) {
			String actionReport = (String) session.getAttribute("actionReport");
			request.setAttribute("actionReport", actionReport);
			session.removeAttribute("actionReport");
		}

		request.setAttribute("day", day);
		request.setAttribute("timepacket_id", timepacket_id);
		request.setAttribute("listBookFieldEmpty", listBookFieldEmpty);

		request.getRequestDispatcher("WEB-INF/views/book-field.jsp").forward(request, response);
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
