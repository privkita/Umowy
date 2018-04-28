package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContractDao;
import dao.SystemDao;
import entities.Contract;
import entities.System;

/**
 * Servlet implementation class NewContractServlet
 */
@WebServlet("/newContract")
public class NewContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pobiera Systemy do choosera
		SystemDao systemDao = (SystemDao) request.getAttribute("systemDao");
		List<System> systems = systemDao.getSystems();
		request.setAttribute("systems", systems);
		
		request.getRequestDispatcher("WEB-INF/view/newContract.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("setId");
		String system = request.getParameter("setSystem");
		LocalDate startDate = null;
		LocalDate endDate = null;
		BigDecimal amount = null;
		String settlement = request.getParameter("setSettlement");
		String active = request.getParameter("setActive");
		Contract contract = new Contract();
		try {
			startDate = LocalDate.parse(request.getParameter("setStartDate"));
			endDate = LocalDate.parse(request.getParameter("setEndDate"));
		} catch (Exception e) {
			request.setAttribute("message", "Podano nieprawidłową datę");
			doGet(request, response);
		}
		try {
			amount = new BigDecimal(request.getParameter("setAmount").replace(",", "."));
		} catch (Exception e) {
			request.setAttribute("message", "Podano nieprawidłową kwotę");
			doGet(request, response);
		}

		if (!id.equals("") && !system.equals("") && !settlement.equals("") && !active.equals("")) {
			contract.setId(id);
			contract.setSystem(system);
			contract.setStartDate(startDate);
			contract.setEndDate(endDate);
			contract.setAmount(amount);
			contract.setSettlement(settlement);
			contract.setActive(active);
			ContractDao contractDao = (ContractDao) request.getAttribute("contractDao");
			
			try {
				contractDao.getContractById(id);
				request.setAttribute("message", "Umowa o tym numerze już istnieje");
				doGet(request, response);
			} catch (Exception e) {
				if (contractDao.addContract(contract)) {
					request.setAttribute("message", "Dodano nową umowę");
					doGet(request, response);
				}
			}
		} else {
			request.setAttribute("message", "Podano nieprawidłowe dane, aktualizacja nie powiodła się");
			doGet(request, response);
		}
	}
}