import java.sql.*;

public class mysql {
    Connection c;
    Statement s;

    public mysql() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Update the connection string with proper details
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "###");
            s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found. Add the JDBC driver to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database. Check your URL, username, and password.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
}
