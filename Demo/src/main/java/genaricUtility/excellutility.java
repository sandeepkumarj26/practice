package genaricUtility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class excellutility {
	@DataProvider(name="testdata")
	public Object[][] Reading(String filepath,String SheetName) throws EncryptedDocumentException, InvalidFormatException, IOException    {
		File excel=new File(filepath);
		Workbook workbook = WorkbookFactory.create(excel);
		Sheet sheet = workbook.getSheet(SheetName);
		int rowcount=sheet.getPhysicalNumberOfRows();
		int cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowcount][cellcount];
		for(int row=0;row<rowcount;row++) {
			Row actualrow=sheet.getRow(row);
			for(int cell=0;cell<actualrow.getLastCellNum();cell++) {
				data[row][cell]=actualrow.getCell(cell).toString();
			}
		}
	  
		
		
		return data;
		
	}

}
