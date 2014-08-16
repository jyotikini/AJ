package com.corejsf;

import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.corejsf.Name;

@ManagedBean(name = "table")
@SessionScoped
public class TableData implements Serializable {

	// @Resource(name = "jdbc/whiztechaj")
	// private DataSource ds;
	// int i = 0;
	public List<Name> filename;
	public File[] listOfFiles;
	
	
	public File[] getListOfFiles() {
		
		return listOfFiles;
	}



	public List<Name> getFilename() throws SQLException {
		//System.out.println("TableData");
		/*
		 * if(ds==null) throw new SQLException("Can't get data source");
		 * 
		 * //get database connection Connection con = ds.getConnection();
		 * 
		 * if(con==null) throw new
		 * SQLException("Can't get database connection");
		 * 
		 * PreparedStatement ps =
		 * con.prepareStatement("select lst_nm, fst_nm from person");
		 * 
		 * //get customer data from database ResultSet result =
		 * ps.executeQuery();
		 */

		List<Name> list = new ArrayList<Name>();
		File folder = new File(
				"C:/Users/Asad/git/datatable/fileuploaddownload/WebContent/resources/default/uploads");
		listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				Name cust = new Name();

				cust.setLast(listOfFiles[i].getName());
				cust.setFilenum(i);
				
				// store all data into a List
				list.add(cust);
				
			//	System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				//System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		//System.out.println(listOfFiles.length);
		return list;

	}

}