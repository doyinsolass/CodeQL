# Java Code with SQL Injection Vulnerability
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableJava {
    public static void main(String[] args) {
        String userId = args[0];
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = " + userId);
            while (resultSet.next()) {
                System.out.println("User: " + resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Java Code with Hardcoded Credentials
public class HardcodedCredentials {
    public static void main(String[] args) {
        String username = "admin";
        String password = "password";
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
