import java.io.*;
import java.sql.*;
import java.util.*;

public class PoorlyWrittenCode {

    public static void main(String[] args) {
        // Hardcoded credentials (Security vulnerability)
        String username = "admin";
        String password = "admin123";
        String url = "jdbc:mysql://localhost:3306/mydb";

        try {
            // SQL Injection vulnerability
            String user = "user1";
            String pass = "pass1";
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Duplicate code
        printMessage("Hello World");
        printMessage("Hello World");
        printMessage("Hello World");

        // Unused variable (Code smell)
        String unused = "This is not used";

        // Inefficient use of String concatenation in a loop (Performance issue)
        String result = "";
        for (int i = 0; i < 100; i++) {
            result += i + ",";
        }
        System.out.println(result);

        // Handling exceptions inappropriately
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"));
            String line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }

        // Using outdated collections (Code smell)
        Vector<String> vector = new Vector<>();
        vector.add("item1");
        vector.add("item2");

        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        // Not closing resources properly (Bug)
        try {
            BufferedReader reader = new BufferedReader(new FileReader("anotherfile.txt"));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Poor exception handling and logging (Code smell)
        try {
            int[] array = new int[10];
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }

        // Dead code (Code smell)
        if (false) {
            System.out.println("This will never be printed");
        }

        // Hardcoded file paths (Security vulnerability)
        File file = new File("/etc/passwd");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Potentially unsafe type casting (Code smell)
        Object obj = "This is a string";
        if (obj instanceof Integer) {
            Integer integer = (Integer) obj;
            System.out.println(integer);
        }

        // Overly complicated expressions (Code smell)
        int a = 5, b = 10, c = 15;
        int complicatedResult = (a * b) + (b / c) - (a % b) + (c * a) - (b % a);
        System.out.println(complicatedResult);

        // Lack of input validation (Security vulnerability)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        System.out.println("Your age is: " + age);
    }

    // Duplicate method
    public static void printMessage(String message) {
        System.out.println(message);
    }

    // Additional duplicate method to fill up lines
    public static void anotherPrintMessage(String message) {
        System.out.println(message);
    }

    // More duplicate code
    public static void repeatMethod1() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod2() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod3() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod4() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod5() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod6() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod7() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod8() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod9() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod10() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod11() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod12() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod13() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod14() {
        System.out.println("Repeat this method");
    }

    public static void repeatMethod15() {
        System.out.println("Repeat this method");
    }
}
