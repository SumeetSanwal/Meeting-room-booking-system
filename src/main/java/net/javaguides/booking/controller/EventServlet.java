package net.javaguides.booking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.booking.dao.*;
import net.javaguides.booking.model.*;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private EventDao eventDao = new EventDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/Event-Organiser/event_organiser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String room =request.getParameter("room");
		String to =request.getParameter("to");
		String from =request.getParameter("from");
		String dt =request.getParameter("dt");
		String path = request.getParameter("path");
		String description =request.getParameter("description");
		
		Event ev =new Event();
		ev.setRoom(room);
		ev.setTo(to);
		ev.setFrom(from);
		ev.setDt(dt);
		ev.setPath(path);
		ev.setDescription(description);
	
		try {
			eventDao.registerEvent(ev);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			listEvents(request, response);
		} catch (SQLException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		RequestDispatcher dispatcher =  request.getRequestDispatcher("/Hod/hod.jsp");
//		dispatcher.forward(request, response);
	}



private void listEvents(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
	List<Event> listEvents = EventDao.selectAllEvents();
	request.setAttribute("listEvents", listEvents);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/Hod/hod.jsp");
	dispatcher.forward(request, response);
}

}
