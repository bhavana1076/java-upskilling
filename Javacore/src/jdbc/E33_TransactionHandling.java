/**
 * Exercise 33: Transaction Handling in JDBC
 * Objective: Use JDBC transactions.
 */
import java.sql.*;

public class E33_TransactionHandling {
    static final String DB_URL = "jdbc:sqlite:bank.db";
    
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(DB_URL);
            
            // Create accounts table if not exists
            createAccountsTable(conn);
            
            // Insert initial data
            insertInitialData(conn);
            
            System.out.println("=== Initial Balances ===");
            displayBalances(conn);
            
            // Transfer money with transaction handling
            System.out.println("\n=== Transferring $50 from Account 1 to Account 2 ===");
            transferMoney(conn, 1, 2, 50);
            
            System.out.println("\n=== Final Balances ===");
            displayBalances(conn);
            
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void createAccountsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "balance REAL" +
                ")";
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }
    
    public static void insertInitialData(Connection conn) throws SQLException {
        String deleteSQL = "DELETE FROM accounts"; // Clear existing data for demo
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(deleteSQL);
        }
        
        String insertSQL = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, "Account 1");
            pstmt.setDouble(2, 1000);
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Account 2");
            pstmt.setDouble(2, 500);
            pstmt.executeUpdate();
        }
    }
    
    public static void transferMoney(Connection conn, int fromId, int toId, double amount) throws SQLException {
        try {
            // Disable auto-commit to start transaction
            conn.setAutoCommit(false);
            
            String debitsSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            
            try (PreparedStatement debitStmt = conn.prepareStatement(debitsSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {
                
                // Debit from account
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                debitStmt.executeUpdate();
                
                // Credit to account
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                creditStmt.executeUpdate();
                
                // Commit transaction
                conn.commit();
                System.out.println("Transfer successful!");
            } catch (SQLException e) {
                // Rollback on error
                conn.rollback();
                System.out.println("Transfer failed! Transaction rolled back.");
                throw e;
            } finally {
                // Re-enable auto-commit
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void displayBalances(Connection conn) throws SQLException {
        String selectSQL = "SELECT id, name, balance FROM accounts";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            
            System.out.println("ID | Name | Balance");
            System.out.println("-------------------");
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | $" + rs.getDouble("balance"));
            }
        }
    }
}
