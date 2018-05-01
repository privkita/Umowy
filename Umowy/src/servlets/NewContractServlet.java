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
 * Handle adding new Contract page
 * 
 * @author Lucas Kita
 */
@WebServlet("/newContract")
public class NewContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Getting the Systems list for the Systems chooser
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SystemDao systemDao = (SystemDao) request.getAttribute("systemDao");
		List<System> systems = systemDao.getSystems();
		request.setAttribute("systems", systems);

		request.getRequestDispatcher("WEB-INF/view/newContract.jsp").forward(request, response);
	}
	
	/**
	 * Collects data from the form, checks their correctness and creates a new Contract
	 * type element
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("setId");
		String system = request.getParameter("setSystem");
		LocalDate startDate = null;
		LocalDate endDate = null;
		BigDecimal amount = null;
		String tax = request.getParameter("setTax");
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

		if (!id.equals("") && !system.equals("") && !settlement.equals("") && !active.equals("") 
				&& !tax.equals("")) {
			contract.setId(id);
			contract.setSystem(system);
			contract.setStartDate(startDate);
			contract.setEndDate(endDate);
			contract.setAmount(amount);
			contract.setTax(tax);
			contract.setSettlement(settlement);
			contract.setActive(active);
			
			ContractDao contractDao = (ContractDao) request.getAttribute("contractDao");
			// Checks the validity of the id number of new Contract
			if (contractDao.idExist(id)) {
				request.setAttribute("message", "Umowa o tym numerze już istnieje");
				doGet(request, response);
			} else {
				if (contractDao.addContract(contract)) {
					request.setAttribute("message", "Dodano nową umowę");
					doGet(request, response);
				}
			}
		} else {
			request.setAttribute("message", "Podano nieprawidłowe dane, zapis nie powiódł się");
			doGet(request, response);
		}
	}
}