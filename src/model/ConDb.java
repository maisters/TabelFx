/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author Администратор
 */
public class ConDb {
	private static Connection conn;
	
	public ConDb() throws Exception{
		//connect to database
		String url = "jdbc:postgresql://192.168.0.14/Baza";
		String user = "postgres";
		String pass = "Winston15lm";
		
		conn = DriverManager.getConnection(url,user,pass);
		
	}

	public static List<part>getAllParts() throws Exception{
		List<part>list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRes = null;
		
		try{
			myStmt = conn.createStatement();
			myRes = myStmt.executeQuery("select * from parti_2016 order by (data,numofpart) desc");
			
			
		
		while(myRes.next()){
			part tempPart = convertRowToPart(myRes);
			list.add(tempPart);
		}
		return list;
		
	}finally{
		close(myStmt,myRes);
	}
	}
	
	
	

		private static person convertRowToPart(ResultSet myRs) throws SQLException {
			
			int id = myRs.getInt("NumOfPart");
			Date data = myRs.getDate("Data");
			String product = myRs.getString("Product");
			String weight = myRs.getString("Weight");
			String firm = myRs.getString("Firm");
			String order = myRs.getString("NumOfOrder");
			
			part tempPart = new part(id,data, product, weight,firm,order);
			
			return tempPart;
		}

		
		private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
				throws SQLException {

			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}

		private static void close(Statement myStmt, ResultSet myRs) throws SQLException {
			close(null, myStmt, myRs);		
		}
		

					
}		
