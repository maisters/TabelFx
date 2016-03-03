/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Администратор
 */
public class ConDb {
    
    private static Connection conn;

    
	
    public ConDb() throws Exception{
	//connect to database
	String url = "jdbc:postgresql://192.168.0.14/Test";
	String user = "postgres";
	String pass = "Winston15lm";
		
	conn = DriverManager.getConnection(url,user,pass);
		
	}

    public static ObservableList<Person>getAllParts() throws Exception{
        ObservableList<Person>list = FXCollections.observableArrayList();
		
        Statement myStmt = null;
        ResultSet myRes = null;
		
        try{
            myStmt = conn.createStatement();
            myRes = myStmt.executeQuery("select * from persons");	
		
            while(myRes.next()){
		Person temp = convertRowToPart(myRes);
		list.add(temp);
            }
            
	return list;
                
        }finally{
            close(myStmt,myRes);
        }
        
    }
	
	
	

    private static Person convertRowToPart(ResultSet myRs) throws SQLException {			
        int id = myRs.getInt("id");
        String firstName = myRs.getString("firstName");
        String lastName = myRs.getString("lastName");
        LocalDate birthDate =toLocalDate(myRs.getDate("birthDate"));                        
        return new Person(id,firstName,lastName,birthDate);                        
    }

		
    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
				throws SQLException {
        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();
        }
			
        if (myConn != null) {
            myConn.close();
        }
    }
        
        
    private static void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);	
    }
        
        
    private static LocalDate toLocalDate(Date date) {
        return date.toLocalDate();
        }	

        
    public static void main(String [] args) throws Exception{
        ConDb s = new ConDb();
        ObservableList l = FXCollections.observableArrayList(s.getAllParts());       
        System.out.println(l);
            
    }
					
}		
