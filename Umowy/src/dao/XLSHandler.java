package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entities.Contract;

public class XLSHandler {
	
	public List<Contract> loadFile(String fileName) throws IOException, FileNotFoundException, NotOfficeXmlFileException {
		List<Contract> contractsList = new ArrayList<Contract>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			XSSFRow row;
			for (int i = 1; i <= rowCount; i++) {
				// Jeśli dane w wierszu są prawidłowe zapisuje je do nowej Umowy i dodaje ją do listy
				try {
				row = sheet.getRow(i);
				Contract contract = new Contract();
				contract.setId(row.getCell(2).getStringCellValue());
				contract.setSystem(row.getCell(0).getStringCellValue());
				contract.setStartDate(row.getCell(3).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				contract.setEndDate(row.getCell(4).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				contract.setAmount(new BigDecimal(row.getCell(5).getStringCellValue()));
				contract.setSettlement(row.getCell(7).getStringCellValue());
				if (row.getCell(9).getStringCellValue().equals("true"))
					contract.setActive("tak");
				if (row.getCell(9).getStringCellValue().equals("false"))
					contract.setActive("nie");
				System.out.println("id: " + contract.getId());
				System.out.println("system: " + contract.getSystem());
				System.out.println("startDate: " + contract.getStartDate());
				System.out.println("endDate: " + contract.getEndDate());
				System.out.println("amount: " + contract.getAmount());
				System.out.println("settlement: " + contract.getSettlement());
				System.out.println("active: " + contract.getActive());
				System.out.println();
				contractsList.add(contract);
				} catch (Exception e) {
					continue;
				}
			}
			System.out.println("liczba wierszy: " + rowCount);
			System.out.println("Liczba umów na liście: " + contractsList.size());	
			return contractsList;
		} finally {
			
		}
//		catch (FileNotFoundException e) {
//			System.out.println("To jest wyjątek nie odnaleziono pliku z XLS Handler");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("To jest wyjątek In/Out z XLS Handler");
//			e.printStackTrace();
//		}
			

		
	}
}
