package TestUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExcelDataCompell {
	
	
	default void DataRetreive(String pathoffile, String Username, String sheetName) throws IOException, FileNotFoundException {
		
		File f = null;
		FileInputStream fis = null;
		
		f = new File(pathoffile);
		fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1   = wb.getSheet(sheetName);
		int lastrowno = sh1.getLastRowNum();
		//System.out.println("Last Row No. is -> " + lastrowno);
		int flag = 0;
		
		for(int i = 0; i<=lastrowno; i++) {
			String user = sh1.getRow(i).getCell(0).getStringCellValue().trim() ;
			
			if(user.matches(Username)) {
				
				System.out.println("Username is -> " +  sh1.getRow(i).getCell(0).getStringCellValue());
				System.out.println("Password is -> " +  sh1.getRow(i).getCell(1).getStringCellValue());
				System.out.println("EID is -> " +  sh1.getRow(i).getCell(2).getStringCellValue());
				System.out.println("Country is -> " +  sh1.getRow(i).getCell(3).getStringCellValue());
				System.out.println("City is -> " +  sh1.getRow(i).getCell(4).getStringCellValue());
				System.out.println("Gender is -> " +  sh1.getRow(i).getCell(5).getStringCellValue());
				flag += 1;
				break;
				
			}
			
			else {
				
				continue;
			}
			
			
		}
		
		if (flag == 0) {
			
			System.out.println("Username Not Found");
		}
		
		
		
		
		
		wb.close();
		fis.close();
		
	}

}
