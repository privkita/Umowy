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
 */
@WebServlet("/contracts")
public class ContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ContractDao contractDao = (ContractDao) request.getAttribute("contractDao");
		String active = request.getParameter("filtr");
		if (!active.equals("aktywne")) {
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
