package TestNGClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import TestUtilities.ExcelDataCompell;

public class ExcelCompellRunner implements ExcelDataCompell{
	


	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		ExcelCompellRunner obj = new ExcelCompellRunner();
		obj.DataRetreive("C:\\Users\\Azad\\Desktop\\azad.xlsx", "ACP9999012", "Sheet1");
		
		

	}

}
