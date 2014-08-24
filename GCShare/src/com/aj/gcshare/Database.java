package com.aj.gcshare;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class Database {

	String url = "jdbc:mysql://localhost:3306/test";
	String user = "root";
	String password = "root";
	PreparedStatement stmt = null;
	Connection conn = null;
	String sql=null;
	
	
	
	public void insert(String userfilename, InputStream fileStream, String savpublishflag, String sysdate) throws IOException {

		try {
			conn = DriverManager.getConnection(url, user, password);

			sql = "INSERT INTO TBL_UPLD_FL (USR_FLNM,SYS_FLNM,FLG_SV_PBLSH,DATE) values (?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, userfilename);// the file name that user has
												// input
			stmt.setBlob(2, fileStream);// change it to set blob
			stmt.setString(3, savpublishflag);
			stmt.setString(4, sysdate);// flag should be either S or P
			stmt.executeUpdate();
			int row = stmt.executeUpdate();
			if (row > 0) {
				System.out.println("A contact was inserted with photo image.");
			}
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void delete(String userfilename) {
			sql="DELETE FROM TBL_UPLD_FL WHERE USR_FLNM=?";
			try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userfilename);
			}
			catch(SQLException sqlex)
			{
				sqlex.printStackTrace();				
			}
				
	}
	
	public void update(){

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		Date date = new Date();
		String sysdate = dateFormat.format(date);
		String flag = "P";
		sql="UPDATE TBL_UPLD_FL SET DATE=?,FLG_SV_PBLSH=? WHERE FLG_SV_PBLSH='S';";
		try{
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, sysdate);
		stmt.setString(2, flag);
		}
		catch(SQLException sqlex)
		{
			sqlex.printStackTrace();				
		}
	}

}
