/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.BookingTicketDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vvt
 */
public class BookingTicket {
    private int id;
    private Date bookingDate;
    private float saleoff, total, totalLeft, deposit;
    private String note;
    private Client client;
    private User creator;
    private ArrayList<BookedCourt> bookedCourt;

    public BookingTicket() {
        super();
    }

    public BookingTicket(Date bookingDate, float deposit, String note, Client client, User creator, ArrayList<BookedCourt> bookedCourt) {
        super();
        this.bookingDate = bookingDate;
        this.deposit = deposit;
        this.note = note;
        this.client = client;
        this.creator = creator;
        this.bookedCourt = bookedCourt;
    }

    public float getTotalLeft() {
        updateTotalLeft();
        return totalLeft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public float getSaleoff() {
        updateSaleoff();
        return saleoff;
    }

    public float getTotal() {
        updateTotal();
        return total;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public ArrayList<BookedCourt> getBookedCourt() {
        return bookedCourt;
    }

    public void setBookedCourt(ArrayList<BookedCourt> bookedCourt) {
        this.bookedCourt = bookedCourt;
    }
    private void updateTotalLeft(){
        BookingTicketDAO bd = new BookingTicketDAO();
        totalLeft = bd.CalculateTotalLeft(this);
    }
    
    private void updateTotal(){
        total = 0;
        if(bookedCourt != null){
            for(BookedCourt bc: bookedCourt){
                total += bc.getSubtotal();
            }
        }
    }
    
    private void updateSaleoff(){
        saleoff = 0;
        if(bookedCourt != null){
            for(BookedCourt bc: bookedCourt){
                saleoff += bc.getSaleoff();
            }
        }
    }
}
