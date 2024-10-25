package com.dollop.app.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebookapplication";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "mohitkush@123";
	private static Connection con = null;
	
	public static Connection getConnection()
	{
		if(con==null)
		{
			return con=getConnection(DB_URL,DB_UNAME,DB_PWD);
		}
		return con;
	}
	
	private static Connection getConnection(String dbUrl, String dbUname, String dbPwd)
	{
		//step 1 -> Load Driver
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step 2 -> Get DB Connection
			con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		return con;
	}
}