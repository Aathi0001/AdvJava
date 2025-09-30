package test2;

import java.sql.*;

public class ConnectJDBC {

	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/movie_db";
	        String user = "root";
	        String password = "Aathi@2003"; 
	        
	        try {
	            // Step 1: Load Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Step 2: Establish Connection
	            Connection conn = DriverManager.getConnection(url, user, password);
	            System.out.println("✅ Connected to MySQL successfully!");
	            
	            // Step 3: Close Connection
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
