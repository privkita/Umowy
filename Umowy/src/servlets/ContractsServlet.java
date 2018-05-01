package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContractDao;
import entities.Contract;

/**
 * Servlet implementation class ContractServlet
 * Handle Contracts' table page
 * 
 * @author Lucas Kita
 */
@WebServlet("/contracts")
public class ContractsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Depending on the selected option, it sends list of all or only active 
	 * Contract type elements
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContractDao contractDao = (ContractDao) request.getAttribute("contractDao");
		String filtr = request.getParameter("filtr");
		if (!filtr.equals("aktywne")) {
			List<Contract> contracts = contractDao.getAllContracts();
			request.setAttribute("contracts", contracts);
		} else {
			List<Contract> activeContracts = contractDao.getActiveContracts();
			request.setAttribute("contracts", activeContracts);
		}
		request.getRequestDispatcher("WEB-INF/view/contracts.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
