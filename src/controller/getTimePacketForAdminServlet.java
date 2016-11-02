package controller;

import model.bean.FootballField;
import model.bean.TimePacket;
import model.bo.getDataBO;
import model.bo.getTimePacketForAdminBO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getTimePacketForAdminServlet
 */
@WebServlet("/getTimePacketForAdminServlet")
public class getTimePacketForAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTimePacketForAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field = request.getParameter("field");
		String date = request.getParameter("date");
		String condition = request.getParameter("condition");
		
		ArrayList<FootballField> footballFieldArrayList = getDataBO.getFootballField();
		request.setAttribute("footballFieldArrayList", footballFieldArrayList);
		
		ArrayList<String> information = new ArrayList<String>();
		information.add(field);
		information.add(date);
		information.add(condition);
		request.setAttribute("information", information);
		
		ArrayList<TimePacket> timePacketArrayList = getTimePacketForAdminBO.getTimePacket(field, date, condition);
		request.setAttribute("timePacketArrayList", timePacketArrayList);
		
		RequestDispatcher rd = request.getRequestDispatcher("homeAdminServlet");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
