using System;
using System.IO;
using System.Text;
using System.Data.SqlClient;

namespace VulnerableApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter your username:");
            string username = Console.ReadLine();

            Console.WriteLine("Enter your password:");
            string password = Console.ReadLine();

            if (AuthenticateUser(username, password))
            {
                Console.WriteLine("Authentication successful!");
            }
            else
            {
                Console.WriteLine("Authentication failed!");
            }

            Console.WriteLine("Enter a file path to read:");
            string filePath = Console.ReadLine();
            ReadFile(filePath);

            Console.WriteLine("Enter a SQL query:");
            string query = Console.ReadLine();
            ExecuteQuery(query);
        }

        static bool AuthenticateUser(string username, string password)
        {
            // Insecure password storage
            string storedPassword = File.ReadAllText("passwords.txt");
            return password == storedPassword;
        }

        static void ReadFile(string filePath)
        {
            try
            {
                string content = File.ReadAllText(filePath);
                Console.WriteLine("File content:");
                Console.WriteLine(content);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error reading file: " + ex.Message);
            }
        }

        static void ExecuteQuery(string query)
        {
            string connectionString = "Data Source=server;Initial Catalog=db;User ID=user;Password=pass";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                SqlCommand command = new SqlCommand(query, connection);
                try
                {
                    connection.Open();
                    SqlDataReader reader = command.ExecuteReader();
                    while (reader.Read())
                    {
                        Console.WriteLine(String.Format("{0}, {1}", reader[0], reader[1]));
                    }
                   : " + ex.Message);
                }
            }
        }
    }
}
