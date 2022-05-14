package utilities;

import java.io.FileInputStream;
import java.io.IOException;

  
import org.apache.poi.ss.usermodel.*;  
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import basePacks.BaseClass;  

public class ImportFromExcel extends BaseClass {
	
	//method to import data from excel
	public String getdata (String datav) throws IOException {
		
		String data=new String();
		try {
	    String filePath=rpf.getDataFromPropertyFile("readExcelPath");
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		 int totalRow=sheet.getLastRowNum();
		for(int i=0;i<totalRow;i++) {
		Row r=sheet.getRow(i);
		if(r.getCell(0).getStringCellValue().equalsIgnoreCase(datav))
		{
		data=r.getCell(1).getStringCellValue();
		}
		}
		System.out.println("Data successfully Imported from Excel");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
		}
	}
	

	


