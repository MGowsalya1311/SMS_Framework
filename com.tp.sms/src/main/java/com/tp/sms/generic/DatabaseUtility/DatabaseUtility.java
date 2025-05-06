package com.tp.sms.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn = null;
	public ResultSet getDataBaseConnection(String Query) throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedata","root","root");
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(Query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
		}
		
		return resultSet;
	}

	public void closeDBConnection() throws Throwable {
		conn.close();
		System.out.println("connection closed");
	}

}
