package com.sresta.restjersey.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	Connection con;
	
	public DAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","rujen","123456");
			System.out.println("Connection: "+con);
			
		} catch(SQLException e) {
			System.out.println("SQLException: "+e);
		} catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException: "+e);
		}
	}
	
}
