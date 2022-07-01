/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author vvt
 */
public class UsedService implements Serializable{
    private int id, amount;
    private float price, saleoff, total;
    private String note;
    private Service service;

    public UsedService() {
    }

    public UsedService(int amount, float price, float saleoff, float total, String note, Service service) {
        super();
        this.amount = amount;
        this.price = price;
        this.saleoff = saleoff;
        this.total = total;
        this.note = note;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public float getTotal() {
        updateTotal();
        return total;
    }
    
    private void updateTotal(){
        total = amount * price - saleoff;
    }
}
