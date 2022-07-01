/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vvt
 */
public class UseSession implements Serializable{
    private int id;
    private Date checkin, checkout;
    private float total;
    private String note;
    private BookedCourt bookedCourt;
    private ArrayList<UsedService> usedService;

    public UseSession() {
        super();
        usedService = new ArrayList<>();
    }

    public UseSession(Date checkin, Date checkout, float total, String note, BookedCourt bookedCourt) {
        super();
        this.checkin = checkin;
        this.checkout = checkout;
        this.total = total;
        this.note = note;
        this.bookedCourt = bookedCourt;
        usedService = new ArrayList<>();;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
    
    public float getTotal() {
        updateTotal();
        return total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BookedCourt getBookedCourt() {
        return bookedCourt;
    }

    public void setBookedCourt(BookedCourt bookedCourt) {
        this.bookedCourt = bookedCourt;
    }

    public ArrayList<UsedService> getUsedService() {
        return usedService;
    }

    public void setUsedService(ArrayList<UsedService> usedService) {
        this.usedService = usedService;
    }
    private void updateTotal(){
        total = 0;
        
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        LocalDateTime date1 = LocalDateTime.parse(format.format(checkin).toString(), dtf);
        LocalDateTime date2 = LocalDateTime.parse(format.format(checkout).toString(), dtf);
        
        total = Duration.between(date1, date2).toHours() * bookedCourt.getPrice();
        if(usedService != null){
            for(UsedService us: usedService){
                total += us.getTotal();
            }
        }
    }
}
