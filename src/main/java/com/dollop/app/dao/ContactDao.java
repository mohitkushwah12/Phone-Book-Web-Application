package com.dollop.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dollop.app.entity.Contact;

public class ContactDao 
{
	private Connection con;

	public ContactDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean saveContact(Contact c)
	{
		boolean f = false;
		
		try {
			
			String sql = "insert into contact(name,email,phono,about,userid) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhono());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getUserId());
			
			int i = ps.executeUpdate();
			
			if(i==1)
			{
				f = true;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Contact> getAllContact(int uId)
	{
		List<Contact> list = new ArrayList<Contact>();
		Contact c = null;
		try {
			String sql = "select * from contact where userid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhono(rs.getString(4));
				c.setAbout(rs.getString(5));
				list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Contact getContactById(int cId)
	{
		Contact c = new Contact();
		try
		{
			PreparedStatement ps = con.prepareStatement("select * from contact where id=?");
			ps.setInt(1, cId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhono(rs.getString(4));
				c.setAbout(rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return c;
	}
	
	public boolean updateContact(Contact c)
	{
		boolean f = false;
		try {
			
			String sql = "update contact set name=?,email=?,phono=?,about=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhono());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getId());
			
			int i = ps.executeUpdate();
			
			if(i==1)
			{
				f = true;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteContact(int id)
	{
		boolean f = false;
		try {
			String sql = "delete from contact where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if(i==1)
			{
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
