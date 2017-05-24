using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace ATM
{
    class Database
    {
        private  string server;
        private  string uid;
        private  string password;
        private  string database;
        MySqlDataReader reader;


        public
            Database()
        {
            server = "localhost";
            uid = "root";
            password = "";
            database = "GlBank";
           
            
        }
       private  MySqlConnection OpenConnection()
        {
            string connectionString = "SERVER=" + server + ";";
            connectionString += "DATABASE=" + database + ";";
            connectionString += "UID=" + uid + ";";
            connectionString += "PASSWORD=" + password + ";";
            return new MySqlConnection(connectionString);
            
        }
        public  bool existCard(long idcard)
        {
            string query = "SELECT idcard FROM cards WHERE cardnumber =" + idcard.ToString();
            MySqlConnection connection = OpenConnection();
            
            if (connection != null)
            {
                try {
                    MySqlCommand cmd = new MySqlCommand(query, connection);
                    connection.Open();
                    reader = cmd.ExecuteReader();
                    if (reader.Read())
                    {
                        return true;
                    }
                }catch(Exception ex)
                {
                    Console.WriteLine("Error! " + ex.ToString());
                }
                finally
                {
                    reader.Close();
                }
               
           
            }
            return false;

        }

        public bool isCardBlocked(long idcard)
        {
            string query = "SELECT blocked FROM cards WHERE cardnumber =" + idcard.ToString();
            MySqlConnection connection = OpenConnection();

            if (connection != null)
            {
                try
                {
                    MySqlCommand cmd = new MySqlCommand(query, connection);
                    connection.Open();
                    reader = cmd.ExecuteReader();
                    if (reader.Read())
                    {
                        return reader.GetBoolean("blocked");
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error! " + ex.ToString());
                }
                finally
                {
                    reader.Close();
                }


            }
            return false;

        }

    }
}
