/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package glbank;

import java.util.Date;


public class TransactionHistory {
    private String date;
    private String desc;
    private float amount;
    

    public TransactionHistory(String date, String desc, float amount) {
        this.date = date;
        this.desc = desc;
        this.amount = amount;
        
    }

    public String getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public float getAmount() {
        return amount;
    }

    
    
}
