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

/**
 * Transform data from MSExcel file to list of Contract type elements.
 * @author Lucas Kita
 *
 */
public class XLSHandler {

	/**
	 * Read MSExcel file row by row and add to list a Contract type elements, omit rows with 
	 * wrong format data
	 * @param filePath full lenght path to MSExcel file
	 * @return list of Contract type element
	 * @throws IOException  if an I/O error occurs
	 * @throws FileNotFoundException  if an wrong path of file is given
	 * @throws NotOfficeXmlFileException if the contents of the file cannot be parsed into a Workbook
	 * @throws EncryptedDocumentException If the workbook given is password protected
	 * @throws InvalidFormatException if the contents of the file cannot be parsed into a Workbook
	 */
	public List<Contract> loadFile(String filePath)
			throws IOException, FileNotFoundException, NotOfficeXmlFileException, EncryptedDocumentException, InvalidFormatException {
		List<Contract> contractsList = new ArrayList<Contract>();

		try {
			Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			Row row;

			for (int i = 1; i <= rowCount; i++) {
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