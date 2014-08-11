package com.corejsf;

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

@ManagedBean(name="table")
@SessionScoped
public class TableData implements Serializable {
	
	@Resource(name="jdbc/whiztechaj")
	private DataSource ds;

	public List<Name> getNames() throws SQLException{
		System.out.println("TableData");
		if(ds==null)
			throw new SQLException("Can't get data source");
 
		//get database connection
		Connection con = ds.getConnection();
 
		if(con==null)
			throw new SQLException("Can't get database connection");
 
		PreparedStatement ps 
			= con.prepareStatement("select lst_nm, fst_nm from person"); 
 
		//get customer data from database
		ResultSet result =  ps.executeQuery();
 
		List<Name> list = new ArrayList<Name>();
 
		while(result.next()){
			Name cust = new Name();
 
			cust.setLast(result.getString("lst_nm"));
			cust.setFirst(result.getString("fst_nm"));
			//store all data into a List
			list.add(cust);
		}
		return list;
	}
}