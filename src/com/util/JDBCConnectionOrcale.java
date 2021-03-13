package src.com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionOrcale {
	public static Connection connectionMethod() {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String userName= "dbms_project";
		String password= "dbms_project";
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,userName,password);
			if(con == null)
				System.out.println("not connected");
			else
				System.out.println("connected");
				System.out.println(con);
		}
		catch(Exception e){
			System.out.println("Something went wrong "+e);
		}
		return con;
	}
	
}
