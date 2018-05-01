package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SystemDao;

import entities.System;

/**
 * Servlet implementation class SystemServlet
 * Handle Systems' table page
 * 
 * @author Lucas Kita
 */
@WebServlet("/systems")
public class SystemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Sends list of System type elements
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pobiera z bazy i wypisuje listę Systemów
		SystemDao systemDao = (SystemDao) request.getAttribute("systemDao");
		List<System> systems = systemDao.getSystems();
		request.setAttribute("systems", systems);
		request.getRequestDispatcher("WEB-INF/view/systems.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
