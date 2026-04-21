import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class VulnerableApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Hardcoded credentials (Vulnerability 1)
        String dbUser = "admin";
        String dbPassword = "admin123";

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        try {

            // Database connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    dbUser,
                    dbPassword
            );

            Statement stmt = conn.createStatement();

            // SQL Injection vulnerability (Vulnerability 2)
            String query = "SELECT * FROM users WHERE username = '" + username + "'";

            stmt.executeQuery(query);

            // Information disclosure (Vulnerability 3)
            System.out.println("Connected to database successfully!");

        } catch (Exception e) {

            // Sensitive error exposure (Vulnerability 4)
            e.printStackTrace();

        }

        scanner.close();
    }
}
