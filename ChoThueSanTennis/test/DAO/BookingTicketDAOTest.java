/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.BookedCourt;
import Model.BookingTicket;
import Model.Client;
import Model.UseSession;
import Model.UsedService;
import Model.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vvt
 */
public class BookingTicketDAOTest {
    private BookingTicketDAO btd = new BookingTicketDAO();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Test
    public void testCalculateTotalLeft1() throws ParseException{
        BookingTicket btk = new BookingTicket();
        btk.setId(3);
        
        ArrayList<BookedCourt> listBC = new ArrayList<>();
        BookedCourt bc1 = new BookedCourt();
        bc1.setPrice(200000);
        bc1.setSaleoff(20000);
        
        ArrayList<UseSession> listUS = new ArrayList<>();
        UseSession us1 = new UseSession();
        us1.setBookedCourt(bc1);
        us1.setCheckin(format.parse("2022-01-01 07:00:00"));
        us1.setCheckout(format.parse("2022-01-01 15:00:00"));
        us1.setUsedService(new ArrayList<UsedService>());
        
        listUS.add(us1);
        
        bc1.setUseSession(listUS);
        listBC.add(bc1);
        
        btk.setBookedCourt(listBC);
        
        float result = 500000;

        assertTrue(result == btd.CalculateTotalLeft(btk));
    }
    
    @Test
    public void testCalculateTotalLeft2() throws ParseException{
        BookingTicket btk = new BookingTicket();
        btk.setId(2);
        
        ArrayList<BookedCourt> listBC = new ArrayList<>();
        BookedCourt bc1 = new BookedCourt();
        bc1.setPrice(100000);
        bc1.setSaleoff(50000);
        
        ArrayList<UseSession> listUS = new ArrayList<>();
        UseSession us1 = new UseSession();
        us1.setBookedCourt(bc1);
        us1.setCheckin(format.parse("2022-01-01 07:00:00"));
        us1.setCheckout(format.parse("2022-01-01 10:00:00"));
        us1.setUsedService(new ArrayList<UsedService>());
        
        UseSession us2 = new UseSession();
        us2.setBookedCourt(bc1);
        us2.setCheckin(format.parse("2022-01-01 07:00:00"));
        us2.setCheckout(format.parse("2022-01-01 11:00:00"));
        us2.setUsedService(new ArrayList<UsedService>());
        
        listUS.add(us1);
        listUS.add(us2);
        
        bc1.setUseSession(listUS);
        listBC.add(bc1);
        
        btk.setBookedCourt(listBC);
        
        float result = 550000;

        assertTrue(result == btd.CalculateTotalLeft(btk));
    }
    
    @Test
    public void testSearchBookingTicket1() {
        Client client = new Client();
        client.setId(1);
        
        ArrayList<BookingTicket> listBooking = btd.SearchBookingTicket(new User(), client);
        assertNotNull(listBooking);
        assertEquals(2, listBooking.size());
    }
    
    @Test
    public void testSearchBookingTicket2() {
        Client client = new Client();
        client.setId(2);
        
        ArrayList<BookingTicket> listBooking = btd.SearchBookingTicket(new User(), client);
        assertNotNull(listBooking);
        assertEquals(0, listBooking.size());
    }
    
    @Test
    public void testSearchBookingTicket3() {
        Client client = new Client();
        client.setId(3);
        
        ArrayList<BookingTicket> listBooking = btd.SearchBookingTicket(new User(), client);
        assertNotNull(listBooking);
        assertEquals(1, listBooking.size());
    }
}
