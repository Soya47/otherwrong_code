using System;
using System.Data.SqlClient;
using System.IO;
using System.Web;

public class PoorlyWrittenCode : IHttpHandler
{
    // Hardcoded credentials (Security vulnerability)
    private const string connectionString = "Server=localhost;Database=test;User Id=sa;Password=password;";

    public void ProcessRequest(HttpContext context)
    {
        string action = context.Request.QueryString["action"];

        if (action == "login")
        {
            // SQL Injection vulnerability
            string username = context.Request.QueryString["username"];
            string password = context.Request.QueryString["password"];

            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                conn.Open();
                string query = $"SELECT * FROM users WHERE username = '{username}' AND password = '{password}'";
                SqlCommand cmd = new SqlCommand(query, conn);
                SqlDataReader reader = cmd.ExecuteReader();
                if (reader.HasRows)
                {
                    context.Response.Write("Login successful");
                }
                else
                {
                    context.Response.Write("Unauthorized");
                }
            }
        }
        else if (action == "data")
        {
            // Hardcoded file path (Security vulnerability)
            string data = File.ReadAllText("C:\\Windows\\System32\\drivers\\etc\\hosts");
            context.Response.Write(data);
        }
        else
        {
            context.Response.Write("Not Found");
        }
    }

    // Duplicate code
    private void PrintMessage(string message)
    {
        Console.WriteLine(message);
    }

    public void TestDuplicateCode()
    {
        PrintMessage("Hello World");
        PrintMessage("Hello World");
        PrintMessage("Hello World");
    }

    // Unused variable (Code smell)
    private string unusedVariable = "This is not used";

    // Inefficient use of string concatenation in a loop (Performance issue)
    private void InefficientStringConcat()
    {
        string result = "";
        for (int i = 0; i < 100; i++)
        {
            result += i + ",";
        }
        Console.WriteLine(result);
    }

    // Not closing resources properly (Bug)
    private void ReadFile()
    {
        FileStream file = new FileStream("anotherfile.txt", FileMode.Open);
        StreamReader reader = new StreamReader(file);
        string line;
        while ((line = reader.ReadLine()) != null)
        {
            Console.WriteLine(line);
        }
        // Missing file.Close() and reader.Close()
    }

    // Poor exception handling and logging (Code smell)
    private void AccessArray()
    {
        try
        {
            int[] array = { 1, 2, 3 };
            Console.WriteLine(array[10]);
        }
        catch (Exception e)
        {
            Console.WriteLine("Index out of bounds");
        }
    }

    // Dead code (Code smell)
    private void DeadCode()
    {
        if (false)
        {
            Console.WriteLine("This will never be printed");
        }
    }

    // Potentially unsafe type casting (Code smell)
    private void UnsafeTypeCasting()
    {
        object obj = "This is a string";
        if (obj is int)
        {
            int number = (int)obj;
            Console.WriteLine(number);
        }
    }

    // Overly complicated expressions (Code smell)
    private void ComplicatedExpressions()
    {
        int a = 5, b = 10, c = 15;
        int complicatedResult = (a * b) + (b / c) - (a % b) + (c * a) - (b % a);
        Console.WriteLine(complicatedResult);
    }

    // Lack of input validation (Security vulnerability)
    private void LackOfInputValidation()
    {
        string userInput = "age=25";
        string[] parts = userInput.Split('=');
        string age = parts[1];
        Console.WriteLine("Your age is: " + age);
    }

    // More duplicate code to fill up lines
    private void RepeatMethod1() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod2() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod3() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod4() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod5() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod6() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod7() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod8() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod9() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod10() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod11() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod12() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod13() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod14() { Console.WriteLine("Repeat this method"); }
    private void RepeatMethod15() { Console.WriteLine("Repeat this method"); }

    public bool IsReusable
    {
        get { return false; }
    }
}
