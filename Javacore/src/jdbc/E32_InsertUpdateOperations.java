/**
 * Exercise 32: Insert and Update Operations in JDBC
 * Objective: Perform insert/update SQL queries from Java.
 */
import java.sql.*;

public class E32_InsertUpdateOperations {
    static final String DB_URL = "jdbc:sqlite:student.db";
    
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(DB_URL);
            
            System.out.println("=== Initial Records ===");
            displayRecords(conn);
            
            System.out.println("\n=== Inserting New Student ===");
            insertStudent(conn, "Alice Brown", 88);
            
            System.out.println("\n=== Records After Insert ===");
            displayRecords(conn);
            
            System.out.println("\n=== Updating Student Marks ===");
            updateStudentMarks(conn, 1, 90);
            
            System.out.println("\n=== Records After Update ===");
            displayRecords(conn);
            
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertStudent(Connection conn, String name, int marks) throws SQLException {
        String insertSQL = "INSERT INTO students (name, marks) VALUES (?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, marks);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student(s) inserted successfully!");
        }
    }
    
    public static void updateStudentMarks(Connection conn, int id, int newMarks) throws SQLException {
        String updateSQL = "UPDATE students SET marks = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setInt(1, newMarks);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record(s) updated successfully!");
        }
    }
    
    public static void displayRecords(Connection conn) throws SQLException {
        String selectSQL = "SELECT id, name, marks FROM students";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            
            System.out.println("ID | Name | Marks");
            System.out.println("-----------");
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getInt("marks"));
            }
        }
    }
}
