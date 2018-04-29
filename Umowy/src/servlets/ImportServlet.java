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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/import.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// Pobiera ścieżkę pliku do importu, sprawdza czy da się tego dokonać jeśli tak
		// to importuje
		// dane z pliku do listy Contract'ów i zapisuje listę do bazy jako pojedyncze
		// Contract'y
		if (request.getParameter("path").equals("")) {
			request.setAttribute("message", "Proszę podać ścieżkę do pliku!!!");
			doGet(request, response);
		}
		String path = request.getParameter("path");
		XLSHandler handler = new XLSHandler();
		try {
			List<Contract> contractsList = handler.loadFile(path);
			ContractDao contractDao = (ContractDao) request.getAttribute("contractDao");
			int succesCount = contractDao.writeContracts(contractsList);
			request.setAttribute("message", "Liczba pozycji dodanych do bazy: " + succesCount);
			doGet(request, response);
		} catch (FileNotFoundException e) {
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
