package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertMovies {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/movie_db";
        String user = "root";
        String password = "Aathi@2003";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO movies (movie_name, director, hero, heroine, villain, collection, rating) "
                       + "VALUES ('Inception', 'Christopher Nolan', 'Leonardo DiCaprio', 'Elliot Page', 'Cillian Murphy', 836800000, 8.8)";
            
            int rows = stmt.executeUpdate(sql);
            System.out.println("✅ Rows inserted: " + rows);
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
