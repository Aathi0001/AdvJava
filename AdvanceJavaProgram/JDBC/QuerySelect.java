package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class QuerySelect {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/movie_db";
        String user = "root";
        String password = "Aathi@2003";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM movies";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Movie: " + rs.getString("movie_name") 
                                   + ", Director: " + rs.getString("director") 
                                   + ", Rating: " + rs.getDouble("rating"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
