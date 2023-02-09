package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {

	private static String url;
    private static String driverName;
    private static String username;
    private static String password;
    
static {
        
        ResourceBundle rbd= ResourceBundle.getBundle("databasedetails");
        
        url= rbd.getString("db.url");
        driverName= rbd.getString("db.drivername");
        username= rbd.getString("db.username");
        password= rbd.getString("db.password");
        
        
        
    }

public static Connection provideConnection() {
	Connection conn = null;
	
	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	try {
		conn = DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
}

}
