package com.cg_vip.lab1.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg_vip.lab1.util.DBUtil;

public class Main
{
	public static void main(String[] args) 
	{
		Connection connection = null;
		ResultSet rs = null;
		try 
		{
			connection = DBUtil.getCon();
			String selectQuery = "SELECT * FROM lab1";
			String selectQuery2 = "SELECT * FROM lab2"; 
			String deleteQuery = "DELETE FROM Lab2 WHERE id IN (SELECT id FROM Lab1)";
			Statement statement = connection.createStatement();
			
			rs = statement.executeQuery(selectQuery);
			System.out.println("=====================LAB1=================");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+""+rs.getString(2));
			}
			System.out.println("======================LAB2================");
			rs = statement.executeQuery(selectQuery2);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+""+rs.getString(2));
			}
			
			int done = statement.executeUpdate(deleteQuery);
			
			System.out.println("======================LAB2================");
			rs = statement.executeQuery(selectQuery2);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+""+rs.getString(2));
			}
			if(done==1)
				{
					System.out.println("Deleted ??");
					System.out.println("Yes");
				}
				else
				{
					System.out.println("Deleted ??");
					System.out.println("No");
				}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
