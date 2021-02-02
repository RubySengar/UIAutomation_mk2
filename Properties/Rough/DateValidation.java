package Rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DateValidation {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception, Throwable {
		// TODO Auto-generated method stub
		
		DateComparison();
		DateValidation();

	}
	
	
	public static void DateValidation() throws FileNotFoundException , IOException, Throwable, Exception  {
		
		LinkedList<String> l1 = new LinkedList<String>();
		l1.add("11-10-2020");
		l1.add("12-10-2020");
		l1.add("11-11-2020");
		l1.add("11-12-2020");
		l1.add("11-13-2020");
		l1.add("11-13-2020");
		l1.add("11-14-2020");
		l1.add("11-15-2020");
		l1.add("11-16-2020");
		l1.add("11-17-2020");
		l1.add("11-18-2020");
		l1.add("11-19-2020");
		l1.add("11-19-2020");
		
		System.out.println("Size of list is > " + l1.size());
		
		File f = new File("C:\\Users\\Azad\\Desktop\\azad.xlsx");
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1 = wb.getSheet("Date"); 
		
		int row = sh1.getLastRowNum();
		int col = sh1.getRow(9).getLastCellNum();
		
		int fieldcolnum = 0;
		
		for (int i = 0; i <= col; i++) {
			
			String s1 = sh1.getRow(9).getCell(i).getStringCellValue();
			
			if(s1.contentEquals("Pol_Effective_Date")) {
				
				fieldcolnum = i;
				break;
			}
			else {
				
				continue;
			}
		}
		
		System.out.println("Field column number is -> " + fieldcolnum);
		System.out.println("Last Row number is -> " + row);
		System.out.println("Last Column number is -> " + col);
		
		ArrayList<String> exceldate = new ArrayList<String>();
		
		for (int j = 10; j <= row; j++) {
			
			String s2 = sh1.getRow(j).getCell(fieldcolnum).getStringCellValue();
			exceldate.add(s2);
		}
		
		System.out.println("Total date values from excel is -> " + exceldate.size());
		
		
		if(l1.size() == exceldate.size()) {
			
			for(int i = 0; i <l1.size(); i++) {
				
				//System.out.println(l1.get(i) + exceldate.get(i));
				
				
				  if(l1.get(i).contentEquals(exceldate.get(i))) {
				  
				  System.out.println("Effective date is matching with DB -> " + l1.get(i)); }
				  else {
				  
				  throw new Exception("Effective date is not matching with DB"); }
				 
			}
		}
		
		
	
	}
	
	
	public static void DateComparison() {
		
		String d1 = "10/Nov/2020";
		String d2 = "10/Nov/2020";
		
		boolean x = false ;
		
		if(d1.contentEquals(d2)) {
			
			x = true;
			System.out.println(x);
		}
		
		else {
			
			System.out.println(x);
		}
				
		
		
		
	}

}
