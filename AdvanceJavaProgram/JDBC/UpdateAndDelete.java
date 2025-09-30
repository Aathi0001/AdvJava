package test2;

import java.sql.*;
import java.util.*;

public class UpdateAndDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/movie_db";
        String user = "root";
        String password = "Aathi@2003"; // your password

        try {
            // ✅ Load driver (safe to include)
            Class.forName("com.mysql.cj.jdbc.Driver");

//try-with-resources statement. 
//The parentheses after try declare resources that will be automatically closed when the try block finishes.

            
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Scanner sc = new Scanner(System.in)) {  

//		Equivalent code without try-with-resources
            	
//            	Connection conn = null;
//            	Scanner sc = null;
//            	try {
//            	    conn = DriverManager.getConnection(url, user, password);
//            	    sc = new Scanner(System.in);
//            	    // ... work ...
//            	} catch (Exception e) {
//            	    e.printStackTrace();
//            	} finally {
//            	    if (sc != null) {
//            	        try { sc.close(); } catch (Exception ex) { ex.printStackTrace(); }
//            	    }
//            	    if (conn != null) {
//            	        try { conn.close(); } catch (Exception ex) { ex.printStackTrace(); }
//            	    }
//            	}

                System.out.println("✅ Connected to MySQL successfully!");

                boolean exit = false;
                while (!exit) {
                    System.out.println("\nChoose operation:");
                    System.out.println("1. Update movie");
                    System.out.println("2. Delete a movie");
                    System.out.println("3. Exit");
                    System.out.print("Enter choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter movie name to update: ");
                            String movieName = sc.nextLine();

                            System.out.println("\nWhich fields do you want to update?");
                            System.out.println("1. Movie Name");
                            System.out.println("2. Director");
                            System.out.println("3. Hero");
                            System.out.println("4. Heroine");
                            System.out.println("5. Villain");
                            System.out.println("6. Collection");
                            System.out.println("7. Rating");
                            System.out.println("8. All fields");
                            System.out.print("Enter your choices (comma separated, e.g. 2,3,7): ");
                            String[] choices = sc.nextLine().split(",");

                            List<String> columns = new ArrayList<>();
                            List<Object> values = new ArrayList<>();

                            for (String c : choices) {
                                switch (c.trim()) {
                                    case "1":
                                        columns.add("movie_name");
                                        System.out.print("New Movie Name: ");
                                        values.add(sc.nextLine());
                                        break;
                                    case "2":
                                        columns.add("director");
                                        System.out.print("New Director: ");
                                        values.add(sc.nextLine());
                                        break;
                                    case "3":
                                        columns.add("hero");
                                        System.out.print("New Hero: ");
                                        values.add(sc.nextLine());
                                        break;
                                    case "4":
                                        columns.add("heroine");
                                        System.out.print("New Heroine: ");
                                        values.add(sc.nextLine());
                                        break;
                                    case "5":
                                        columns.add("villain");
                                        System.out.print("New Villain: ");
                                        values.add(sc.nextLine());
                                        break;
                                    case "6":
                                        columns.add("collection");
                                        System.out.print("New Collection: ");
                                        values.add(sc.nextLong());
                                        sc.nextLine();
                                        break;
                                    case "7":
                                        columns.add("rating");
                                        System.out.print("New Rating: ");
                                        values.add(sc.nextDouble());
                                        sc.nextLine();
                                        break;
                                    case "8": // all fields
                                        columns.addAll(Arrays.asList("movie_name","director","hero","heroine","villain","collection","rating"));
                                        System.out.print("New Movie Name: ");
                                        values.add(sc.nextLine());
                                        System.out.print("New Director: ");
                                        values.add(sc.nextLine());
                                        System.out.print("New Hero: ");
                                        values.add(sc.nextLine());
                                        System.out.print("New Heroine: ");
                                        values.add(sc.nextLine());
                                        System.out.print("New Villain: ");
                                        values.add(sc.nextLine());
                                        System.out.print("New Collection: ");
                                        values.add(sc.nextLong());
                                        System.out.print("New Rating: ");
                                        values.add(sc.nextDouble());
                                        sc.nextLine();
                                        break;
                                    default:
                                        System.out.println("❌ Invalid choice: " + c);
                                }
                            }

                            if (!columns.isEmpty()) {
                                StringBuilder sql = new StringBuilder("UPDATE movies SET ");
                                for (int i = 0; i < columns.size(); i++) {
                                    sql.append(columns.get(i)).append("=?");
                                    if (i < columns.size() - 1) sql.append(", ");
                                }
                                sql.append(" WHERE movie_name=?");

                                try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
                                    int index = 1;
                                    for (Object val : values) {
                                        if (val instanceof String) pstmt.setString(index++, (String) val);
                                        else if (val instanceof Long) pstmt.setLong(index++, (Long) val);
                                        else if (val instanceof Double) pstmt.setDouble(index++, (Double) val);
                                    }
                                    
//Suppose values contains: ["Christopher Nolan", "Cillian Murphy", 9.0] (types: String, String, Double).
//
//Iteration 1:
//
//val = "Christopher Nolan" → instanceof String → call pstmt.setString(1, "Christopher Nolan").
//
//index increments to 2.
//
//Iteration 2:
//
//val = "Cillian Murphy" → pstmt.setString(2, "Cillian Murphy").
//
//index increments to 3.
//
//Iteration 3:
//
//val = 9.0 → instanceof Double → pstmt.setDouble(3, 9.0).
//
//index increments to 4.
//
//After loop, index == 4, so the next placeholder to fill is parameter 4.
                                    
                                    pstmt.setString(index, movieName); // WHERE condition

                                    int rows = pstmt.executeUpdate();
                                    System.out.println("✅ Rows updated: " + rows);
                                }
                            } else {
                                System.out.println("❌ No fields selected for update.");
                            }
                            break;

                        case 2:
                            System.out.print("Enter movie name to delete: ");
                            String delMovie = sc.nextLine();

                            String deleteSQL = "DELETE FROM movies WHERE movie_name = ?";
                            try (PreparedStatement pstmt2 = conn.prepareStatement(deleteSQL)) {
                                pstmt2.setString(1, delMovie);
                                int rows = pstmt2.executeUpdate();
                                System.out.println("✅ Rows deleted: " + rows);
                            }
                            break;

                        case 3:
                            exit = true;
                            System.out.println("Exiting...");
                            break;

                        default:
                            System.out.println("❌ Invalid choice!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
