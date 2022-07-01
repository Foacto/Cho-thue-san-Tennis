/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author vvt
 */
public class Bill {
    private int id;
    private Date paymentDate;
    private String paymentMethod;
    private float amount;
    private String note;
    private User creator;
    private BookingTicket bookingticket;

    public Bill() {
        super();
    }

    public Bill(int id, Date paymentDate, String paymentMethod, float amount, String note, User creator, BookingTicket bookingticket) {
        super();
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.note = note;
        this.creator = creator;
        this.bookingticket = bookingticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public BookingTicket getBookingticket() {
        return bookingticket;
    }

    public void setBookingticket(BookingTicket bookingticket) {
        this.bookingticket = bookingticket;
    }
    
}
