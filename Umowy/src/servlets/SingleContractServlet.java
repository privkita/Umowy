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
 * Servlet implementation class SingleContractServlet
 * Handle editing Contract page
 * 
 * @author Lucas Kita
 */
@WebServlet("/contract")
public class SingleContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Gets single Contract from database to edit
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContractDao contractDao = (ContractDao) request.getAttribute("contractDao");
		String paramId = request.getParameter("id");
		if (!paramId.equals("")) {
			Contract contract = contractDao.getContractById(paramId);
			request.setAttribute("contract", contract);
		}
		// Gets Systems list for chooser
		SystemDao systemDao = (SystemDao) request.getAttribute("systemDao");
		List<System> systems = systemDao.getSystems();
		request.setAttribute("systems", systems);
		
		request.getRequestDispatcher("WEB-INF/view/singleContract.jsp").forward(request, response);
	}

	/**
	 * Collects data from the form, checks their correctness and update data of selected 
	 * Contract type element
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
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
			request.setAttribute("message", "Podano nieprawidłową datę, aktualizacja nie powiodła się");
			doGet(request, response);
		}
		try {
			amount = new BigDecimal(request.getParameter("setAmount").replace(",", "."));
		} catch (Exception e) {
			request.setAttribute("message", "Podano nieprawidłową kwotę, aktualizacja nie powiodła się");
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
			if (contractDao.updateContract(contract)) {
				request.setAttribute("message", "Aktualizacja danych przebiegła pomyślnie");
				doGet(request, response);
			}
		} else {
			request.setAttribute("message", "Podano nieprawidłowe dane, aktualizacja nie powiodła się");
			doGet(request, response);
		}
	}
}
