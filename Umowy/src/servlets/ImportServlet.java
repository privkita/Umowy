package servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;

import dao.ContractDao;
import dao.XLSHandler;
import entities.Contract;

/**
 * Servlet implementation class ImportServlet
 */
@WebServlet("/import")
public class ImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/import.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("path").equals("")) {
			request.setAttribute("message", "Podaj pełną ścieżkę do pliku !!!");
			doGet(request, response);
		}
		String fileName = request.getParameter("path");
		XLSHandler handler = new XLSHandler();
		try {
			List<Contract> contractsList = handler.loadFile(fileName);
			ContractDao contractDao = (ContractDao) request.getAttribute("contractDao");
			contractDao.writeContracts(contractsList);
			request.setAttribute("message", "Dodano do bazy " + contractsList.size() + "pozycji");
			doGet(request, response);
			
		} 
		catch (FileNotFoundException e) {
			request.setAttribute("message", "Nie odnaleziono pliku");
		e.printStackTrace();
		} catch (IOException e) {
			request.setAttribute("message", "Błąd odczytu pliku");
		e.printStackTrace();
		} catch (NotOfficeXmlFileException e) {
			request.setAttribute("message", "Podany plik nie jest typu xml");
		}
		doGet(request, response);
	}

}
