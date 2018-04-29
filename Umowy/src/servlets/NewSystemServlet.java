package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SystemDao;

import entities.System;

/**
 * Servlet implementation class NewSystemServlet
 */
@WebServlet("/newSystem")
public class NewSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/newSystem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("setName");
		String description = request.getParameter("setDescription");
		String technologies = request.getParameter("setTechnologies");
		String client = request.getParameter("setClient");
		System system = new System();

		if (!name.equals("") && !description.equals("") && !technologies.equals("") && !client.equals("")) {
			system.setName(name);
			system.setDescription(description);
			system.setTechnologies(technologies);
			system.setClient(client);
			SystemDao systemDao = (SystemDao) request.getAttribute("systemDao");
			// Sprawdza czy System o podanej nazwie już istnieje
			try {
				systemDao.getSystemByName(name);
				request.setAttribute("message", "System o tej nazwie już istnieje");
				doGet(request, response);
			} catch (Exception e) {
				systemDao.addSystem(system);
				request.setAttribute("message", "Dodano nowy system");
				doGet(request, response);
			}

		} else {
			request.setAttribute("message", "Podano nieprawidłowe dane");
			doGet(request, response);
		}
	}

}
