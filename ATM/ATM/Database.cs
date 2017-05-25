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
                    connection.Close();
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
                    connection.Close();
                }


            }
            return false;

        }

        public bool isPinCorrect(long idcard, int pin)
        {
            string query = "SELECT * FROM cards WHERE cardnumber =" + idcard.ToString() +" AND pin =" +pin.ToString();
            MySqlConnection connection = OpenConnection();

            if (connection != null)
            {
                try
                {
                    MySqlCommand cmd = new MySqlCommand(query, connection);
                    connection.Open();
                    reader = cmd.ExecuteReader();
                    return reader.Read();
                    
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error! " + ex.ToString());
                }
                finally
                {
                    reader.Close();
                    connection.Close();
                }


            }
            return false;

        }


        public void changePassword(long idcard, int pin)
        {
            string query = "UPDATE cards SET pin =" + pin.ToString() + " where cardnumber = " + idcard.ToString();
            MySqlConnection connection = OpenConnection();

            if (connection != null)
            {
                try
                {
                    MySqlCommand cmd = new MySqlCommand(query, connection);
                    connection.Open();
                    cmd.ExecuteNonQuery();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error! " + ex.ToString());
                }
                finally
                {
                    connection.Close();
                }


            }
           

        }

        
        public float getBalance(long idcard)
        {
            string query = "SELECT balance FROM accounts INNER JOIN cards ON accounts.idacc = cards.idacc WHERE cardnumber = " + idcard.ToString();
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
                    
                        return reader.GetFloat("balance");
                    }
                    

                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error! " + ex.ToString());
                }
                finally
                {
                    reader.Close();
                    connection.Close();
                }


            }
            return -1;

        }

        public void withdrawMoney(long idcard, float money)
        {
            string query = "UPDATE accounts SET balance = (balance - " + money + ") where idacc = (SELECT idacc FROM cards where cardnumber = " + idcard + ")";
            MySqlConnection connection = OpenConnection();

            if (connection != null)
            {
                try
                {
                    MySqlCommand cmd = new MySqlCommand(query, connection);
                    connection.Open();
                    cmd.ExecuteNonQuery();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error! " + ex.ToString());
                }
                finally
                {
                    connection.Close();
                }


            }


        }
    }
}
