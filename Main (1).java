import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PoorlyWrittenCode extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Hardcoded credentials (Security vulnerability)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            // SQL Injection vulnerability
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                stmt = conn.createStatement();
                String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    response.getWriter().println("Login successful");
                } else {
                    response.getWriter().println("Unauthorized");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Internal Server Error");
            } finally {
                try {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        } else if ("data".equals(action)) {
            // Hardcoded file path (Security vulnerability)
            FileReader fr = new FileReader("/etc/passwd");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                response.getWriter().println(line);
            }
            br.close();
        } else {
            response.getWriter().println("Not Found");
        }
    }

    // Duplicate code
    private void printMessage(String message) {
        System.out.println(message);
    }

    public void testDuplicateCode() {
        printMessage("Hello World");
        printMessage("Hello World");
        printMessage("Hello World");
    }

    // Unused variable (Code smell)
    private String unusedVariable = "This is not used";

    // Inefficient use of string concatenation in a loop (Performance issue)
    private void inefficientStringConcat() {
        String result = "";
        for (int i = 0; i < 100; i++) {
            result += i + ",";
        }
        System.out.println(result);
    }

    // Not closing resources properly (Bug)
    private void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("anotherfile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            // Missing br.close()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Poor exception handling and logging (Code smell)
    private void accessArray() {
        try {
            int[] array = {1, 2, 3};
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }
    }

    // Dead code (Code smell)
    private void deadCode() {
        if (false) {
            System.out.println("This will never be printed");
        }
    }

    // Potentially unsafe type casting (Code smell)
    private void unsafeTypeCasting() {
        Object obj = "This is a string";
        if (obj instanceof Integer) {
            int number = (Integer) obj;
            System.out.println(number);
        }
    }

    // Overly complicated expressions (Code smell)
    private void complicatedExpressions() {
        int a = 5, b = 10, c = 15;
        int complicatedResult = (a * b) + (b / c) - (a % b) + (c * a) - (b % a);
        System.out.println(complicatedResult);
    }

    // Lack of input validation (Security vulnerability)
    private void lackOfInputValidation() {
        String userInput = "age=25";
        String[] parts = userInput.split("=");
        String age = parts[1];
        System.out.println("Your age is: " + age);
    }

    // More duplicate code to fill up lines
    private void repeatMethod1() { System.out.println("Repeat this method"); }
    private void repeatMethod2() { System.out.println("Repeat this method"); }
    private void repeatMethod3() { System.out.println("Repeat this method"); }
    private void repeatMethod4() { System.out.println("Repeat this method"); }
    private void repeatMethod5() { System.out.println("Repeat this method"); }
    private void repeatMethod6() { System.out.println("Repeat this method"); }
    private void repeatMethod7() { System.out.println("Repeat this method"); }
    private void repeatMethod8() { System.out.println("Repeat this method"); }
    private void repeatMethod9() { System.out.println("Repeat this method"); }
    private void repeatMethod10() { System.out.println("Repeat this method"); }
    private void repeatMethod11() { System.out.println("Repeat this method"); }
    private void repeatMethod12() { System.out.println("Repeat this method"); }
    private void repeatMethod13() { System.out.println("Repeat this method"); }
    private void repeatMethod14() { System.out.println("Repeat this method"); }
    private void repeatMethod15() { System.out.println("Repeat this method"); }
}
