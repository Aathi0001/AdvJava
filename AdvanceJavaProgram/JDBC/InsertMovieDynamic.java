package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMovieDynamic {

	    public static void main(String[] args) {

	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        Scanner sc = new Scanner(System.in);

	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	         
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "Aathi@2003");

	       
	            String sql = "INSERT INTO movies (movie_name, director, hero, heroine, villain, collection, rating) "
	                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	            pstmt = conn.prepareStatement(sql);

	            System.out.print("How many movies do you want to insert? ");
	            int n = sc.nextInt();
	            sc.nextLine(); 

	            for (int i = 1; i <= n; i++) {
	                System.out.println("\nEnter details for Movie " + i);

	                System.out.print("Movie Name: ");
	                String movieName = sc.nextLine();

	                System.out.print("Director: ");
	                String director = sc.nextLine();

	                System.out.print("Hero: ");
	                String hero = sc.nextLine();

	                System.out.print("Heroine: ");
	                String heroine = sc.nextLine();

	                System.out.print("Villain: ");
	                String villain = sc.nextLine();

	                System.out.print("Collection (in numbers): ");
	                long collection = sc.nextLong();

	                System.out.print("Rating (e.g., 8.5): ");
	                double rating = sc.nextDouble();
	                sc.nextLine(); 

	    
	                pstmt.setString(1, movieName);
	                pstmt.setString(2, director);
	                pstmt.setString(3, hero);
	                pstmt.setString(4, heroine);
	                pstmt.setString(5, villain);
	                pstmt.setLong(6, collection);
	                pstmt.setDouble(7, rating);

	                pstmt.addBatch(); 
	            }

	            
	            int[] results = pstmt.executeBatch();
	            System.out.println("\n Successfully inserted " + results.length + " movies!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
	            try { if (conn != null) conn.close(); } catch (Exception e) {}
	            sc.close();
	        }
	    }
	}
