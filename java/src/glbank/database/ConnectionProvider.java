package glbank.database;

import glbank.Account;
import glbank.Client;
import glbank.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnectionProvider {

    private final String URL = "jdbc:mysql://localhost/";
    private final String DBNAME = "GLBank";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection conn = null;
        try {

            Class.forName(DRIVER).newInstance();
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD); //zabezpecuje pripojenie k databaze
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return conn;
    }

    public boolean isEmployeePasswordValid(String username, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean ret = false;
        String query = "SELECT idemp FROM LoginEmployee WHERE login LIKE BINARY ? AND password LIKE BINARY ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                ret = rs.next();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return ret;
    }

    public boolean isEmployeePasswordValidById(int idemp, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean ret = false;
        String query = "SELECT * FROM LoginEmployee WHERE idemp = ? AND password LIKE BINARY ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idemp);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                ret = rs.next();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        
        return ret;
    }

    public int getEmployeeId(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int id = -1;
        String query = "SELECT idemp FROM LoginEmployee WHERE login LIKE BINARY ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("idemp");
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return id;
    }

    public String getDateTime() {
        Date date = new Date();
        SimpleDateFormat ft
                = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ft.format(date);
    }

    public void logEmployeeAccess(int id) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String query = "INSERT INTO historyloginemployee(idemp,logindate) VALUES(?,?)";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, getDateTime());
                ps.execute();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
    }

    public Employee getEmployee(int idemp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Employee employee = null;
        String query = "SELECT * FROM Employees WHERE idemp = ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idemp);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    employee = new Employee(idemp, rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), (rs.getString("position")).charAt(0));

                }

                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return employee;
    }

    public void setNewPassword(int idemp, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String query = "UPDATE LoginEmployee SET password = ? WHERE idemp = ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, password);
                ps.setInt(2, idemp);
                ps.execute();

                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
    }

    public List<Client> getAllClients() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM Clients"
                + " INNER JOIN ClientDetails ON Clients.idc = ClientDetails.idc"
                + " WHERE disable = 'F'"
                + " ORDER BY lastname, firstname";
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (conn != null) {
                while (rs.next()) {
                    int idc = rs.getInt("Clients.idc");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    Date date = rs.getDate("dob");
                    
                    Client client = new Client(idc, firstname, lastname, date);
                    clients.add(client);
                }
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return clients;
    }

    public boolean existClientLogin(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean exists = false;
        String query = "SELECT login FROM LoginClient WHERE login LIKE ?";
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username );
                ResultSet rs = ps.executeQuery();
                exists= rs.next();
                conn.close();
            }
         catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return exists;
    }
    
    public void insertClientToDatabase(Client client, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
    String query = "INSERT INTO Clients(firstname,lastname) VALUES( ? , ? )";
    String querySelect = "SELECT max(idc) as idc FROM Clients WHERE firstname like ? AND lastname LIKE ?";
    Connection conn = getConnection();
    try {
            PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, client.getFirstname() );
                ps.setString(2, client.getLastname() );
                ps.execute();
                
            PreparedStatement ps2 = conn.prepareStatement(querySelect);   
                ps2.setString(1, client.getFirstname() );
                ps2.setString(2, client.getLastname() );
                ResultSet rs = ps2.executeQuery();
                if(rs.next())
                client.setIdc(rs.getInt("idc"));
                
                insertClientDetailsToDatabase(client, password, conn);
                insertClientLogin(client,password,conn);
                
                conn.close();
            }
         catch (SQLException ex) {
            System.out.println("Error: 'insertClientToDatabase' :" + ex.toString());
        }
    }
    
    public void insertClientDetailsToDatabase(Client client,String password, Connection conn){
            String query = "INSERT INTO ClientDetails (idc,street,housenumber, postcode, city, dob, email) VALUES(?, ? ,?, ?, ?, ? , ? )";
            
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                 ps.setInt(1, client.getIdc() );
                  ps.setString(2, client.getStreet());
                   ps.setInt(3, client.getHousenumber() );
                    ps.setString(4, client.getPostcode() );
                     ps.setString(5, client.getCity() );
                      ps.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(client.getDob()));
                       ps.setString(7, client.getEmail() );
                       ps.execute();
                       System.out.println("date to send "+new SimpleDateFormat("yyyy-MM-dd").format(client.getDob()));
            }catch (SQLException ex) {
            System.out.println("Error: 'insertClientDetailsToDatabase' :" + ex.toString());
        }
    }
    
    public void insertClientLogin(Client client, String password,  Connection conn){
        String query = "INSERT INTO LoginClient(idc,login,password) VALUE ( ? , ? , ?)";
        try{
                PreparedStatement ps = conn.prepareStatement(query);
                 ps.setInt(1, client.getIdc() );
                  ps.setString(2, client.getUsername());
                   ps.setString(3, password );
                       ps.executeUpdate();
            }catch (SQLException ex) {
            System.out.println("Error: 'insertClientLogin' :" + ex.toString());
        }
    }
    
    public Client getClientById(int idc) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Client client = null; // new Client();
        String query="SELECT * FROM Clients"
                + " INNER JOIN ClientDetails ON Clients.idc = ClientDetails.idc"
                + " INNER JOIN LoginClient ON Clients.idc = LoginClient.idc"
                + " WHERE Clients.idc = ?";
        Connection conn = getConnection();
        
         try {
             PreparedStatement ps = conn.prepareStatement(query);
              ps.setInt(1, idc );
              ResultSet rs = ps.executeQuery();
            
             if (conn != null) {
                 if(rs.next()){
                     String firstname = rs.getString("firstname");
                     String lastname = rs.getString("lastname");
                     String email = rs.getString("email");
                     String street = rs.getString("street");
                     int housenumber = rs.getInt("housenumber");
                     String postcode = rs.getString("postcode");
                     String city = rs.getString("city");
                     String username = rs.getString("login");
                     boolean disable = rs.getString("disable").charAt(0)=='T';
                     boolean blocked = rs.getString("blocked").charAt(0)=='T';
                    Date dob = rs.getDate("dob");
                    client = new Client(idc, firstname, lastname, email, street, housenumber, postcode, city, username, disable, blocked, dob);
                    
                 }
                     
             }
             conn.close();
         }  catch (SQLException ex) {
            System.out.println("Error: 'getClientById': " + ex.toString());
        }
        
        
        return client;
    } 
    
    public List<Account> getAccounts(int idc) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM Accounts"
                + " WHERE idc = ?";
        Connection conn = getConnection();
        try {
                 PreparedStatement ps = conn.prepareStatement(query);
                 ps.setInt(1, idc );
                 ResultSet rs  = ps.executeQuery();
                 if(conn!=null)
                       while(rs.next()){
                       Account account = new Account(rs.getLong("idacc"), idc, rs.getFloat("balance"));
                       accounts.add(account);
                       }
                       conn.close();
                }
         catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return accounts;
    }
    
    public void updateAccount(Account account)throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        String query = "UPDATE Accounts SET balance = ? WHERE idacc = ?";
        
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setFloat(1, account.getBalance() );
            ps.setLong(2, account.getIdacc());
            ps.executeUpdate();
            conn.close();
            }
         catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
    }
    
    public void addNewAccount(Account account) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        String query = "INSERT INTO Accounts(idacc,idc,balance) VALUE ( ? , ? , ?)";
        Connection conn = getConnection();
        try{
                PreparedStatement ps = conn.prepareStatement(query);
                 ps.setLong(1, account.getIdacc() );
                  ps.setInt(2, account.getIdc());
                   ps.setFloat(3, account.getBalance());
                       ps.executeUpdate();
            }catch (SQLException ex) {
            System.out.println("Error: 'addNewAccount' :" + ex.toString());
        }
    
    }
    
    public boolean existsAccount(Account account) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    boolean exist = false;
        String query = "SELECT * FROM Accounts WHERE idacc = ? ";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setLong(1, account.getIdacc());
                ResultSet rs = ps.executeQuery();
                exist = rs.next();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        
        return exist;
    }
    
    
    
    
    
    
    
    
    
    
    /*
     public Client getClient(int idc) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Client client = null;
        String query = "SELECT * FROM Clients inner join WHERE idc = ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idc);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    employee = new Employee(idemp, rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), (rs.getString("position")).charAt(0));
                    
                }

                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return employee;
    }*/
    
    
    
    
    
    
    
}


