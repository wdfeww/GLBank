/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glbank.database;

import glbank.Employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Client
 */
public class ConnectionProviderTest {
    
    public ConnectionProviderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmployeePasswordValid method, of class ConnectionProvider.
     */
    @Test
    public void testIsEmployeePasswordValid1() throws Exception {
        System.out.println("isEmployeePasswordValid");
        String username = "user1";
        String password = "secret";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = true;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    @Test
    public void testIsEmployeePasswordValid2() throws Exception {
        System.out.println("isEmployeePasswordValid");
        String username = "user1";
        String password = "Secret";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
@Test
    public void testIsEmployeePasswordValid3() throws Exception {
        System.out.println("isEmployeePasswordValid");
        String username = "user1";
        String password = "dasdsa";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
    @Test
    public void testIsEmployeePasswordValid4() throws Exception {
        System.out.println("isEmployeePasswordValid");
        String username = "User1";
        String password = "secret";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    @Test
    public void testIsEmployeePasswordValid5() throws Exception {
        System.out.println("isEmployeePasswordValid");
        String username = "sser1";
        String password = "secret";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    /**
     * Test of getEmployeeId method, of class ConnectionProvider.
     */
    @Test
    public void testGetEmployeeId1() throws Exception {
        System.out.println("getEmployeeId");
        String username = "user1";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = 1;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testGetEmployeeId2() throws Exception {
        System.out.println("getEmployeeId");
        String username = "user2";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = 2;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
@Test
    public void testGetEmployeeId3() throws Exception {
        System.out.println("getEmployeeId");
        String username = "user3";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = 3;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @Test
    public void testGetEmployeeId4() throws Exception {
        System.out.println("getEmployeeId");
        String username = "user4";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = -1;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    /**
     * Test of getDateTime method, of class ConnectionProvider.
     */
   /* @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        ConnectionProvider instance = new ConnectionProvider();
        String expResult = "";
        String result = instance.getDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }*/

    /**
     * Test of logEmployeeAccess method, of class ConnectionProvider.
     */
    /*@Test
    public void testLogEmployeeAccess() throws Exception {
        System.out.println("logEmployeeAccess");
        int id = 0;
        ConnectionProvider instance = new ConnectionProvider();
        instance.logEmployeeAccess(id);
        // TODO review the generated test code and remove the default call to fail.
        
    }*/

    /**
     * Test of getEmployee method, of class ConnectionProvider.
     */
    
    @Test
    public void testGetEmployee() throws Exception {
        System.out.println("getEmployee");
        int idemp = 1;
        ConnectionProvider instance = new ConnectionProvider();
       
        Employee result = instance.getEmployee(idemp);
        
        assertEquals("Jozef", result.getFirstname());
        assertEquals("Haluska", result.getLastname());
        assertEquals(1, result.getIdemp());
        assertEquals("jozef.h@gmail.com", result.getEmail());
        assertEquals('C', result.getPosition());
      
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
