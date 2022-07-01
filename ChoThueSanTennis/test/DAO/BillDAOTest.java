/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Bill;
import Model.BookedCourt;
import Model.BookingTicket;
import Model.UseSession;
import Model.UsedService;
import Model.User;
import java.util.Date;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author vvt
 */
public class BillDAOTest {
    private BillDAO bd = new BillDAO();

    /**
     * Test of AddBill method, of class BillDAO.
     */
    @Test
    public void testAddBill1() {
        Bill bill = new Bill();
        bill.setPaymentDate(new Date());
        bill.setPaymentMethod("cash");
        bill.setAmount(450000);
        User creator = new User();
        creator.setId(4);
        bill.setCreator(creator);
        BookingTicket booking = new BookingTicket();
        booking.setId(2);
        bill.setBookingticket(booking);
        
        Connection con = DAO.con;
        
        try {
            con.setAutoCommit(false);
            assertTrue(bd.AddBill(bill));
            
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(!con.getAutoCommit()) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void testAddBill2() {
        Bill bill = new Bill();
        bill.setPaymentDate(new Date());
        bill.setPaymentMethod("cash");
        bill.setAmount(1000000);
        User creator = new User();
        creator.setId(4);
        bill.setCreator(creator);
        BookingTicket booking = new BookingTicket();
        booking.setId(1);
        bill.setBookingticket(booking);
        
        Connection con = DAO.con;
        
        try {
            con.setAutoCommit(false);
            assertTrue(bd.AddBill(bill));
            
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(!con.getAutoCommit()) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Test of EditBill method, of class BillDAO.
     */
    @Test
    public void testEditBill1() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

        UsedService us = new UsedService();
        us.setId(1);
        us.setAmount(5);
        us.setPrice(10000);
        us.setSaleoff(0);
        us.setNote("test1");
        
        Connection con = DAO.con;
        
        try {
            con.setAutoCommit(false);
            assertTrue(bd.EditBill(us));
            
            String sqlUpdateUsedService = "SELECT * FROM tblUsedService WHERE IdUsedService = ?";
                    
            try {
                PreparedStatement ps = con.prepareStatement(sqlUpdateUsedService);
                ps.setInt(1, us.getId());
                        
                ResultSet result = ps.executeQuery();
                assertTrue(result.next());
                assertTrue(us.getAmount() == result.getInt("amount"));
                assertTrue(us.getPrice() == result.getFloat("price"));
                assertTrue(us.getSaleoff() == result.getFloat("saleoff"));
                assertTrue(result.getString("note").trim().equalsIgnoreCase(us.getNote()));

            }catch(Exception e1) {
                e1.printStackTrace();
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(!con.getAutoCommit()) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void testEditBill2() throws ParseException {
        UsedService us = new UsedService();
        us.setId(3);
        us.setAmount(3);
        us.setPrice(10000);
        us.setSaleoff(0);
        us.setNote("test2");
        
        Connection con = DAO.con;
        
        try {
            con.setAutoCommit(false);
            assertTrue(bd.EditBill(us));
            
            String sqlUpdateUsedService = "SELECT * FROM tblUsedService WHERE IdUsedService = ?";
                    
            try {
                PreparedStatement ps = con.prepareStatement(sqlUpdateUsedService);
                ps.setInt(1, us.getId());
                        
                ResultSet result = ps.executeQuery();
                assertTrue(result.next());
                assertTrue(us.getAmount() == result.getInt("amount"));
                assertTrue(us.getPrice() == result.getFloat("price"));
                assertTrue(us.getSaleoff() == result.getFloat("saleoff"));
                assertTrue(result.getString("note").trim().equalsIgnoreCase(us.getNote()));

            }catch(Exception e1) {
                e1.printStackTrace();
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(!con.getAutoCommit()) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
