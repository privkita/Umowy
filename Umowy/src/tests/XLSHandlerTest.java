package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.XLSHandler;
import entities.Contract;

class XLSHandlerTest {

	@Test
	final void testLoadFile() {
		String filePath = System.getProperty("user.dir") + ("/src/tests/test.xls");
		XLSHandler handler = new XLSHandler();
		String idExp = "1/2010";
		String systemExp = "KUCYK";
		LocalDate startDateExp = LocalDate.parse("2012-02-02");
		String activeExp = "tak";
		List<Contract> list = new ArrayList<Contract>();
		
		try {
			list = handler.loadFile(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(idExp, list.get(0).getId());
		assertEquals(systemExp, list.get(0).getSystem());
		assertEquals(startDateExp, list.get(0).getStartDate());
		assertEquals(activeExp, list.get(0).getActive());
	}

}
