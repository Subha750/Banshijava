package com.banshi.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoController 
{
  public boolean check(String uname,String pass)
  {
	  String classname="com.mysql.jdbc.Driver";
	  String url="jdbc:mysql://localhost:3306/banshiplg";
	  String username="root";
	  String pasword="banshi";
	  try
	  {
		  Class.forName(classname);
		  Connection con=DriverManager.getConnection(url,username,pasword);
		  PreparedStatement pst=con.prepareStatement("select * from user where uname=? and pass=?");
		  pst.setString(1,uname);///here uname is nothing but pass veriable on method parameter
		  pst.setString(2,pass);
		 ResultSet rs= pst.executeQuery();
		 if(rs.next())
		 {
			 return true;
		 }
		  
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  return false;
  }
}
