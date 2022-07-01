/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vvt
 */
public class UserDAOTest {
    private UserDAO ud = new UserDAO();
    
    @Test
    public void testCheckLoginException1() {
        User user = new User();
        user.setUsername("t4");
        user.setPassword("123");

        assertEquals(false, ud.CheckLogin(user));
    }
    
    @Test
    public void testCheckLoginException2() {
        User user = new User();
        user.setUsername("t1");
        user.setPassword("12345");

        assertEquals(false, ud.CheckLogin(user));
    }
    
    @Test
    public void testCheckLoginStandard1() {
        User user = new User();
        user.setUsername("tuan");
        user.setPassword("123");

        assertEquals(true, ud.CheckLogin(user));
    }
    
    @Test
    public void testCheckLoginStandard2() {
        User user = new User();
        user.setUsername("tuan");
        user.setPassword("123");

        assertEquals(true, ud.CheckLogin(user));
    }
}
