package com.cg_vip.lab1.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil
{
	private static String url = null;
	private static String usn = null;
	private static String pwd = null;
	static Connection con = null;
	public static Connection getCon() throws SQLException, IOException
	{
		Properties myProp = getprops();
		if(con==null)
		{
			url = myProp.getProperty("dburl");

			usn = myProp.getProperty("dbusn");

			pwd = myProp.getProperty("dbpwd");

			con = DriverManager.getConnection(url,usn,pwd);
			
		}
		return con;
	}
	public static Properties getprops() throws IOException
	{
		Properties dbProps = new Properties();
		FileReader fr = new FileReader("dbInfo.properties");
		dbProps.load(fr);
		return dbProps;
	}
}
