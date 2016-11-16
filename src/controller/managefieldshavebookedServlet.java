package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BookfieldState;
import model.bean.FieldBooked;
import model.bean.User;
import model.bo.BookfieldStateBO;
import model.bo.FieldBookedBO;

/**
 * Servlet implementation class managementfieldhasbookedServlet
 */
@WebServlet("/manage-fields-have-booked")
public class managefieldshavebookedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managefieldshavebookedServlet() {
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
		if(session.getAttribute("user")==null) response.sendRedirect("login");
		User user = (User) session.getAttribute("user");
				
		ArrayList<FieldBooked> listFieldBooked = new ArrayList<>();
		listFieldBooked = new FieldBookedBO().getListFieldBooked(user);
		
		request.setAttribute("listFieldBooked", listFieldBooked);
		
		if (session.getAttribute("actionReport") != null) {
			String actionReport=(String)session.getAttribute("actionReport");
			request.setAttribute("actionReport", actionReport);
			session.removeAttribute("actionReport");
		}
		request.getRequestDispatcher("/WEB-INF/views/manage-fields-have-booked.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
