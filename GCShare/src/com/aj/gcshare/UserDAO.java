package com.aj.gcshare;
import java.sql.*;

public class UserDAO {      
     public static boolean login(String user, String password) {
        /*Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select user, pass from userinfo where user= ? and pass= ? ");
            ps.setString(1, user);
            ps.setString(2, password);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("user"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            Database.close(con);
        }*/
    	 
    	String name1 = "ADMIN";
    	String pwd1 = "ADMIN";
    	String name2 = "a2";
    	String pwd2 = "a2";
    	if (user.contains(name1)&& password.contains(pwd1)){
    		return true;
    	}
    	else if(user.contains(name2)&& password.contains(pwd2)){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}
