/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glbank.database;

import glbank.Account;
import glbank.Card;
import glbank.Client;
import glbank.Employee;
import glbank.Transaction;
import java.sql.Connection;
import java.util.List;
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

    /**
     * Test of isEmployeePasswordValid method, of class ConnectionProvider.
     */
    @Test
    public void testIsEmployeePasswordValid() throws Exception {
        System.out.println("isEmployeePasswordValid");
        String username = "";
        String password = "";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmployeePasswordValidById method, of class ConnectionProvider.
     */
    @Test
    public void testIsEmployeePasswordValidById() throws Exception {
        System.out.println("isEmployeePasswordValidById");
        int idemp = 0;
        String password = "";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.isEmployeePasswordValidById(idemp, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeId method, of class ConnectionProvider.
     */
    @Test
    public void testGetEmployeeId() throws Exception {
        System.out.println("getEmployeeId");
        String username = "";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = 0;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateTime method, of class ConnectionProvider.
     */
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        ConnectionProvider instance = new ConnectionProvider();
        String expResult = "";
        String result = instance.getDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logEmployeeAccess method, of class ConnectionProvider.
     */
    @Test
    public void testLogEmployeeAccess() throws Exception {
        System.out.println("logEmployeeAccess");
        int id = 0;
        ConnectionProvider instance = new ConnectionProvider();
        instance.logEmployeeAccess(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewPassword method, of class ConnectionProvider.
     */
    @Test
    public void testSetNewPassword() throws Exception {
        System.out.println("setNewPassword");
        int idemp = 0;
        String password = "";
        ConnectionProvider instance = new ConnectionProvider();
        instance.setNewPassword(idemp, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllClients method, of class ConnectionProvider.
     */
    @Test
    public void testGetAllClients() throws Exception {
        System.out.println("getAllClients");
        ConnectionProvider instance = new ConnectionProvider();
        List<Client> expResult = null;
        List<Client> result = instance.getAllClients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existClientLogin method, of class ConnectionProvider.
     */
    @Test
    public void testExistClientLogin() throws Exception {
        System.out.println("existClientLogin");
        String username = "";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.existClientLogin(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertClientToDatabase method, of class ConnectionProvider.
     */
    @Test
    public void testInsertClientToDatabase() throws Exception {
        System.out.println("insertClientToDatabase");
        Client client = null;
        String password = "";
        ConnectionProvider instance = new ConnectionProvider();
        instance.insertClientToDatabase(client, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertClientDetailsToDatabase method, of class ConnectionProvider.
     */
    @Test
    public void testInsertClientDetailsToDatabase() {
        System.out.println("insertClientDetailsToDatabase");
        Client client = null;
        String password = "";
        Connection conn = null;
        ConnectionProvider instance = new ConnectionProvider();
        instance.insertClientDetailsToDatabase(client, password, conn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertClientLogin method, of class ConnectionProvider.
     */
    @Test
    public void testInsertClientLogin() {
        System.out.println("insertClientLogin");
        Client client = null;
        String password = "";
        Connection conn = null;
        ConnectionProvider instance = new ConnectionProvider();
        instance.insertClientLogin(client, password, conn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientById method, of class ConnectionProvider.
     */
    @Test
    public void testGetClientById() throws Exception {
        System.out.println("getClientById");
        int idc = 0;
        ConnectionProvider instance = new ConnectionProvider();
        Client expResult = null;
        Client result = instance.getClientById(idc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccounts method, of class ConnectionProvider.
     */
    @Test
    public void testGetAccounts() throws Exception {
        System.out.println("getAccounts");
        int idc = 0;
        ConnectionProvider instance = new ConnectionProvider();
        List<Account> expResult = null;
        List<Account> result = instance.getAccounts(idc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewAccount method, of class ConnectionProvider.
     */
    @Test
    public void testAddNewAccount() throws Exception {
        System.out.println("addNewAccount");
        Account account = null;
        ConnectionProvider instance = new ConnectionProvider();
        instance.addNewAccount(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsAccount method, of class ConnectionProvider.
     */
    @Test
    public void testExistsAccount() throws Exception {
        System.out.println("existsAccount");
        Account account = null;
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.existsAccount(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editClient method, of class ConnectionProvider.
     */
    @Test
    public void testEditClient() throws Exception {
        System.out.println("editClient");
        Client client = null;
        ConnectionProvider instance = new ConnectionProvider();
        instance.editClient(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCashTransactions method, of class ConnectionProvider.
     */
    @Test
    public void testUpdateCashTransactions() throws Exception {
        System.out.println("updateCashTransactions");
        Account account = null;
        int idemp = 0;
        char mark = ' ';
        float amount = 0.0F;
        ConnectionProvider instance = new ConnectionProvider();
        instance.updateCashTransactions(account, idemp, mark, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAccountBalance method, of class ConnectionProvider.
     */
    @Test
    public void testUpdateAccountBalance() throws Exception {
        System.out.println("updateAccountBalance");
        Account account = null;
        Connection conn = null;
        ConnectionProvider instance = new ConnectionProvider();
        instance.updateAccountBalance(account, conn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeLogCashTransaction method, of class ConnectionProvider.
     */
    @Test
    public void testWriteLogCashTransaction() {
        System.out.println("writeLogCashTransaction");
        Connection conn = null;
        int idemp = 0;
        long idacc = 0L;
        char mark = ' ';
        float amount = 0.0F;
        ConnectionProvider instance = new ConnectionProvider();
        instance.writeLogCashTransaction(conn, idemp, idacc, mark, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class ConnectionProvider.
     */
    @Test
    public void testGetBalance() throws Exception {
        System.out.println("getBalance");
        long idacc = 0L;
        ConnectionProvider instance = new ConnectionProvider();
        float expResult = 0.0F;
        float result = instance.getBalance(idacc);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBankTransactions method, of class ConnectionProvider.
     */
    @Test
    public void testUpdateBankTransactions() throws Exception {
        System.out.println("updateBankTransactions");
        Transaction trans = null;
        ConnectionProvider instance = new ConnectionProvider();
        instance.updateBankTransactions(trans);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCard method, of class ConnectionProvider.
     */
    @Test
    public void testCreateCard() throws Exception {
        System.out.println("createCard");
        Card card = null;
        ConnectionProvider instance = new ConnectionProvider();
        instance.createCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsCard method, of class ConnectionProvider.
     */
    @Test
    public void testExistsCard() throws Exception {
        System.out.println("existsCard");
        long cardnumber = 0L;
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.existsCard(cardnumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCards method, of class ConnectionProvider.
     */
    @Test
    public void testGetCards() throws Exception {
        System.out.println("getCards");
        long idacc = 0L;
        ConnectionProvider instance = new ConnectionProvider();
        List<Card> expResult = null;
        List<Card> result = instance.getCards(idacc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blockCard method, of class ConnectionProvider.
     */
    @Test
    public void testBlockCard() throws Exception {
        System.out.println("blockCard");
        long cardNumber = 0L;
        ConnectionProvider instance = new ConnectionProvider();
        instance.blockCard(cardNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unblockCard method, of class ConnectionProvider.
     */
    @Test
    public void testUnblockCard() throws Exception {
        System.out.println("unblockCard");
        long cardNumber = 0L;
        ConnectionProvider instance = new ConnectionProvider();
        instance.unblockCard(cardNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePin method, of class ConnectionProvider.
     */
    @Test
    public void testChangePin() throws Exception {
        System.out.println("changePin");
        long cardNumber = 0L;
        int pin = 0;
        ConnectionProvider instance = new ConnectionProvider();
        instance.changePin(cardNumber, pin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
