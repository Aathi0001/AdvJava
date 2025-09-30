package test2;

import java.sql.*;

public class CreateTableJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/movie_db";
        String user = "root";
        String password = "Aathi@2003"; // your password

        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to DB
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            // Step 3: Check if table exists
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "movies", null);

            if (tables.next()) {
                System.out.println("Table 'movies' already exists!");
            } else {
                // Step 4: Create table
                stmt = conn.createStatement();
                String sql = "CREATE TABLE movies ("
                        + "movie_id INT AUTO_INCREMENT PRIMARY KEY, "
                        + "movie_name VARCHAR(100) NOT NULL, "
                        + "director VARCHAR(100), "
                        + "hero VARCHAR(100), "
                        + "heroine VARCHAR(100), "
                        + "villain VARCHAR(100), "
                        + "collection BIGINT, "
                        + "rating DECIMAL(2,1)"
                        + ")";
                stmt.executeUpdate(sql);
                System.out.println("✅ Table 'movies' created successfully!");
            }

            // Close resources
            tables.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
