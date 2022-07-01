/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Bill;
import Model.BookedCourt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.BookingTicket;
import Model.UseSession;
import Model.UsedService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author vvt
 */
public class BillDAO extends DAO{
    
    public boolean AddBill(Bill bill){
        String sqlAddBill = "INSERT INTO tblBill(paymentDate, paymentMethod, amount, note, tblUserId, tblBookingTicketId) VALUES(?,?,?,?,?,?)";
        
        boolean result = true;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlAddBill, Statement.RETURN_GENERATED_KEYS);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, dateFormat.format(bill.getPaymentDate()));
            ps.setString(2, bill.getPaymentMethod());
            ps.setFloat(3, bill.getAmount());
            ps.setString(4, bill.getNote());
            ps.setInt(5, bill.getCreator().getId());
            ps.setInt(6, bill.getBookingticket().getId());
            
            ps.executeUpdate();
            
            // Lay Id cua bill moi them vao
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()){
                bill.setId(generatedKeys.getInt(1));
            }
            
            con.commit();   //set this line into comment in JUnit test mode
        }catch(Exception e) {
            result = false;
            try {
                con.rollback();
            }catch(Exception ex) {
                result = false;
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                con.setAutoCommit(true);    //set this line into comment in JUnit test mode
            }catch(Exception ex) {
                result = false;
                ex.printStackTrace();
            }
        }
        
        return result;
    }
    
    public boolean EditBill(UsedService ustmp){
        // Update UsedService
        String sqlEditUsedService = "UPDATE tblUsedService SET amount = ?, price = ?, saleoff = ?, note = ? WHERE IdUsedService = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlEditUsedService);
            ps.setInt(1, ustmp.getAmount());
            ps.setFloat(2, ustmp.getPrice());
            ps.setFloat(3, ustmp.getSaleoff());
            ps.setString(4, ustmp.getNote());
            ps.setInt(5, ustmp.getId());
                                
            ps.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
