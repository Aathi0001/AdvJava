package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/movie_db";
        String user = "root";
        String password = "Aathi@2003";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO movies (movie_name, director, hero, heroine, villain, collection, rating) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Doctor Strange");
            pstmt.setString(2, "Scott Derrickson");
            pstmt.setString(3, "Benedict Cumberbatch");
            pstmt.setString(4, "Rachel McAdams");
            pstmt.setString(5, "Mads Mikkelsen");
            pstmt.setLong(6, 677700000);
            pstmt.setDouble(7, 7.5);

            int rows = pstmt.executeUpdate();
            System.out.println("✅ Rows inserted: " + rows);

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
