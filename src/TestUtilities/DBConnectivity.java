package TestUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public interface DBConnectivity {
	
	
	
default ArrayList<String> jdbcdatabaseresult() throws ClassNotFoundException, SQLException{
		
		ArrayList<String> al = new ArrayList<String>();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
				
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@https://retail.axisbank.co.in/:5000:AXIS", "872048754", "azad1234");
		
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery("select * from AXIS_TABLE");
		
		while(rst.next()){
			
			//String dbvalue = rst.getString("BAL");
			String dbvalue = rst.getString("POL_NO");
			
			al.add(dbvalue);
		}
		
		return al;
		
	}

}
