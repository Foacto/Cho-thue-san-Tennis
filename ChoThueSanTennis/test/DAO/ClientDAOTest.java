/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Client;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vvt
 */
public class ClientDAOTest {
    private ClientDAO cd = new ClientDAO();

    @Test
    public void testSearchClientException1(){
        String name = "xxxxxxxxxx";
        ArrayList<Client> listClient = cd.SearchClient(name);
        assertNotNull(listClient);
        assertEquals(0, listClient.size());
    }
    
    @Test
    public void testSearchClientException2(){
        String name = "rn";
        ArrayList<Client> listClient = cd.SearchClient(name);
        assertNotNull(listClient);
        assertEquals(0, listClient.size());
    }
    
    @Test
    public void testSearchClientStandard1() {
        String name = "t";
        ArrayList<Client> listClient = cd.SearchClient(name);
        assertNotNull(listClient);
        assertEquals(2, listClient.size());
        for(int i = 0;i < listClient.size();i++){
            assertTrue(listClient.get(i).getName().toLowerCase().contains(name.toLowerCase()));
        }
    }
    
    @Test
    public void testSearchClientStandard2() {
        String name = "m";
        ArrayList<Client> listClient = cd.SearchClient(name);
        assertNotNull(listClient);
        assertEquals(1, listClient.size());
        for(int i = 0;i < listClient.size();i++){
            assertTrue(listClient.get(i).getName().toLowerCase().contains(name.toLowerCase()));
        }
    }
}
