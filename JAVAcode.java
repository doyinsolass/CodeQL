// Java Code with SQL Injection Vulnerability
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

// Java Code with Command Injection Vulnerability
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandInjection {
    public static void main(String[] args) {
        try {
            String command = args[0];
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Java Code with Insecure Deserialization
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public main(String[] args) {
        try {
            byte[] serializedData = args[0].getBytes();
            ByteArrayInputStream byteStream = new ByteArrayInputStream(serializedData);
            ObjectInputStream objectStream = new ObjectInputStream(byteStream);
            Object obj = objectStream.readObject();
            System.out.println("Deserialized object: " + obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        with Deprecated Cryptographic Algorithms
import java.security.MessageDigest;

public class DeprecatedCrypto {
    public static void main(String[] args) {
        try {
            String data = args[0];
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] hash = md5Digest.digest(data.getBytes());
            System.out.println("MD5 hash: " + bytesToHex(hash));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
