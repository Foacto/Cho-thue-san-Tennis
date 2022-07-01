/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vvt
 */
public class BookedCourt implements Serializable{
    private int id;
    private Date startDate, endDate;
    private float price, saleoff, subtotal;
    private String note;
    private TennisCourt tennisCourt;
    private ArrayList<UseSession> useSession;

    public BookedCourt() {
        super();
        useSession = new ArrayList<>();
    }

    public BookedCourt(Date startDate, Date endDate, float price, float saleoff, String note, TennisCourt tennisCourt) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.saleoff = saleoff;
        this.note = note;
        this.tennisCourt = tennisCourt;
        useSession = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(float saleoff) {
        this.saleoff = saleoff;
    }

    public float getSubtotal() {
        updateSubtotal();
        return subtotal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TennisCourt getTennisCourt() {
        return tennisCourt;
    }

    public void setTennisCourt(TennisCourt tennisCourt) {
        this.tennisCourt = tennisCourt;
    }

    public ArrayList<UseSession> getUseSession() {
        return useSession;
    }

    public void setUseSession(ArrayList<UseSession> useSession) {
        this.useSession = useSession;
    }
   
    private void updateSubtotal(){
        subtotal = 0;
        if(useSession != null){
            subtotal -= saleoff;
            for(UseSession uss: useSession){
                subtotal += uss.getTotal();
            }
        }
    }
}
