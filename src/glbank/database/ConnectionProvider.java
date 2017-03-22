package glbank.database;

import glbank.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        boolean ret=false;
        String query = "SELECT idemp FROM LoginEmployee WHERE login LIKE ? AND password LIKE ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                ret=rs.next();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return ret;
    }

    public int getEmployeeId(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int id = -1;
        String query = "SELECT idemp FROM LoginEmployee WHERE login LIKE ?";
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
                employee = new Employee(idemp, rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("position").charAt(0));
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return employee;
    }

}
