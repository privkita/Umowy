package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import entities.Contract;

public class XLSHandler {

	// Wczytuje dane z pliku, zapisuje je jako obiekty Contract a następnie dodaje
	// je do listy, jeśli wystąpi wyjatek przekazuje go do servletu celem obsłużenia
	public List<Contract> loadFile(String filePath)
			throws IOException, FileNotFoundException, NotOfficeXmlFileException, EncryptedDocumentException, InvalidFormatException {
		List<Contract> contractsList = new ArrayList<Contract>();
//		Workbook workbook = null;
		try {
			Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			Row row;

			for (int i = 1; i <= rowCount; i++) {
				// sprawdza prawidłowość danych i dodaje je do obietku Contract
				try {
					row = sheet.getRow(i);
					Contract contract = new Contract();
					contract.setId(row.getCell(2).getStringCellValue());
					contract.setSystem(row.getCell(0).getStringCellValue());
					contract.setStartDate(row.getCell(3).getDateCellValue().toInstant().
							atZone(ZoneId.systemDefault()).toLocalDate());
					contract.setEndDate(row.getCell(4).getDateCellValue().toInstant().
							atZone(ZoneId.systemDefault()).toLocalDate());
					contract.setAmount(new BigDecimal(row.getCell(5).getStringCellValue()));
					contract.setSettlement(row.getCell(7).getStringCellValue());
					if (row.getCell(9).getStringCellValue().equals("true"))
						contract.setActive("tak");
					if (row.getCell(9).getStringCellValue().equals("false"))
						contract.setActive("nie");
					contract.setTax(row.getCell(6).getStringCellValue());
					contractsList.add(contract);
				} catch (Exception e) {
					continue;
				}
			}
			workbook.close();
			return contractsList;
		} finally {

		}
	}
}