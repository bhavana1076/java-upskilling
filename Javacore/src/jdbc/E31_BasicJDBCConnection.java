/**
 * Exercise 31: Basic JDBC Connection
 * Objective: Connect Java with a relational database.
 * 
 * NOTE: This example uses SQLite. Make sure to have sqlite-jdbc in your classpath.
 * Download from: https://www.xerial.org/maven/repository/artifact/org.xerial/sqlite-jdbc/
 */
import java.sql.*;

public class E31_BasicJDBCConnection {
    static final String DB_URL = "jdbc:sqlite:student.db";
    
    public static void main(String[] args) {
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            
            // Create connection
            Connection conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to database successfully!");
            
            // Create table if not exists
            createTable(conn);
            
            // Insert sample data
            insertData(conn);
            
            // Retrieve and display data
            retrieveData(conn);
            
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC Driver not found!");
            System.out.println("Download from: https://www.xerial.org/maven/repository/artifact/org/xerial/sqlite-jdbc/");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void createTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "marks INTEGER" +
                ")";
        
        Statement stmt = conn.createStatement();
        stmt.execute(createTableSQL);
        stmt.close();
        System.out.println("Table created successfully!");
    }
    
    public static void insertData(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO students (name, marks) VALUES (?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, "John Doe");
            pstmt.setInt(2, 85);
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Jane Smith");
            pstmt.setInt(2, 92);
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Bob Johnson");
            pstmt.setInt(2, 78);
            pstmt.executeUpdate();
        }
        System.out.println("Data inserted successfully!");
    }
    
    public static void retrieveData(Connection conn) throws SQLException {
        String selectSQL = "SELECT id, name, marks FROM students";
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);
        
        System.out.println("\nStudent Records:");
        System.out.println("ID | Name | Marks");
        System.out.println("-----------");
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int marks = rs.getInt("marks");
            System.out.println(id + " | " + name + " | " + marks);
        }
        
        rs.close();
        stmt.close();
    }
}
