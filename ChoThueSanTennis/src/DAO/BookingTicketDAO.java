/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.BookedCourt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.BookingTicket;
import Model.Client;
import Model.Service;
import Model.TennisCourt;
import Model.UseSession;
import Model.UsedService;
import Model.User;
import java.util.ArrayList;

/**
 *
 * @author vvt
 */
public class BookingTicketDAO extends DAO{
    public ArrayList<BookingTicket> SearchBookingTicket(User user, Client client){
        ArrayList<BookingTicket> result = new ArrayList<>();
        String sql = "SELECT * FROM tblBookingTicket WHERE tblClientId LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,client.getId() + "");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                BookingTicket booking = new BookingTicket();
                booking.setId(rs.getInt("IdBookingTicket"));
                booking.setBookingDate(rs.getDate("bookingDate"));
                booking.setNote(rs.getString("note"));
                booking.setDeposit(rs.getFloat("deposit"));
                booking.setCreator(user);
                booking.setClient(client);
                
                // Truy vấn đến BookedCourt
                ArrayList<BookedCourt> listBooked = new ArrayList<>();
                String sql_1 = "SELECT * FROM tblBookedCourt WHERE tblBookingTicketId LIKE ?";
                try {
                    PreparedStatement ps_1 = con.prepareStatement(sql_1);
                    ps_1.setString(1,booking.getId() + "");
                    ResultSet rs_1 = ps_1.executeQuery();
                    
                    while(rs_1.next()){
                        BookedCourt bk = new BookedCourt();
                        bk.setId(rs_1.getInt("IdBookedCourt"));
                        bk.setStartDate(rs_1.getDate("startDate"));
                        bk.setEndDate(rs_1.getDate("endDate"));
                        bk.setPrice(rs_1.getFloat("price"));
                        bk.setSaleoff(rs_1.getFloat("saleoff"));
                        bk.setNote(rs_1.getString("note"));
                        
                        // Truy vấn đến TennisCourt
                        String courtId = rs_1.getString("tblTennisCourtId");
                        String sql_2 = "SELECT * FROM tblTennisCourt WHERE IdCourt LIKE ?";
                        try {
                            PreparedStatement ps_2 = con.prepareStatement(sql_2);
                            ps_2.setString(1, courtId);
                            ResultSet rs_2 = ps_2.executeQuery();
                            
                            if(rs_2.next()){
                                TennisCourt tc = new TennisCourt();
                                tc.setId(courtId);
                                tc.setName(rs_2.getString("name"));
                                tc.setType(rs_2.getString("type"));
                                tc.setPrice(rs_2.getFloat("price"));
                                tc.setDes(rs_2.getString("des"));
                         
                                bk.setTennisCourt(tc);
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        
                        // Truy vấn đến UseSession
                        ArrayList<UseSession> listUseSession = new ArrayList<>();
                        String sql_3 = "SELECT * FROM tblUseSession WHERE tblBookedCourtId LIKE ?";
                        try {
                            PreparedStatement ps_3 = con.prepareStatement(sql_3);
                            ps_3.setString(1, bk.getId() + "");
                            ResultSet rs_3 = ps_3.executeQuery();
                            
                            while(rs_3.next()){
                                UseSession uss = new UseSession();
                                uss.setId(rs_3.getInt("IdUseSession"));
                                uss.setCheckin(rs_3.getTimestamp("checkin"));
                                uss.setCheckout(rs_3.getTimestamp("checkout"));
                                uss.setNote(rs_3.getString("note"));
                                uss.setBookedCourt(bk);
                                
                                // Truy vấn đến UsedService
                                ArrayList<UsedService> listUsedService = new ArrayList<>();
                                String sql_4 = "SELECT * FROM tblUsedService WHERE tblUseSessionId LIKE ?";
                                try {
                                    PreparedStatement ps_4 = con.prepareStatement(sql_4);
                                    ps_4.setString(1, uss.getId() + "");
                                    ResultSet rs_4 = ps_4.executeQuery();
                                    
                                    while(rs_4.next()){
                                        UsedService usd = new UsedService();
                                        usd.setId(rs_4.getInt("IdUsedService"));
                                        usd.setAmount(rs_4.getInt("amount"));
                                        usd.setPrice(rs_4.getFloat("price"));
                                        usd.setSaleoff(rs_4.getFloat("saleoff"));
                                        usd.setNote(rs_4.getString("note"));
                                        
                                        // Truy vấn đến Service
                                        int serviceId = rs_4.getInt("tblServiceId");
                                        String sql_5 = "SELECT * FROM tblService WHERE IdService LIKE ?";
                                        
                                        try {
                                            PreparedStatement ps_5 = con.prepareStatement(sql_5);
                                            ps_5.setString(1, serviceId + "");
                                            ResultSet rs_5 = ps_5.executeQuery();
                                            
                                            if(rs_5.next()){
                                                Service sv = new Service();
                                                
                                                sv.setId(serviceId);
                                                sv.setName(rs_5.getString("name"));
                                                sv.setType(rs_5.getString("type"));
                                                sv.setPrice(rs_5.getFloat("price"));
                                                sv.setUnity(rs_5.getString("unity"));
                                                sv.setNote(rs_5.getString("note"));
                                                
                                                usd.setService(sv);
                                            }
                                        }catch(Exception e) {
                                            e.printStackTrace();
                                        }
                                        listUsedService.add(usd);
                                    }
                                    
                                uss.setUsedService(listUsedService);
                                }catch(Exception e) {
                                    e.printStackTrace();
                                }
                                
                                listUseSession.add(uss);
                            }
                            
                        bk.setUseSession(listUseSession);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        
                        listBooked.add(bk);
                    }
                booking.setBookedCourt(listBooked);
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                result.add(booking);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    public float CalculateTotalLeft(BookingTicket booking){
        float totalLeft = booking.getTotal() - booking.getDeposit();
        String sql = "SELECT amount FROM tblBill WHERE tblBookingTicketId LIKE ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,booking.getId() + "");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                totalLeft -= rs.getFloat("amount");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return totalLeft;
    }
}
