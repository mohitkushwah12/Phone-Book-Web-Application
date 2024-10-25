package com.dollop.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dollop.app.entity.User;

public class UserDao 
{
	private Connection con;
	
	public UserDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean userRegister(User u)
	{
		boolean f = false;
		
		try 
		{
			String sql = "INSERT INTO user(name, email, password) values(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int i = ps.executeUpdate();
			if(i==1)
			{
				f = true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public User userLogin(String e, String p)
	{		
		User user = null;
		try 
		{
			String sql = "select * from user where email=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, e);
			ps.setString(2, p);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return user;
	}
	
	
}
