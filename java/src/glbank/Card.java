/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package glbank;

/**
 *
 * @author Monika Jassova
 */
public class Card {
    private int idcard;
    private long cardnumber;
    private long idacc;
    private boolean blocked;
    private int pin;

    public Card(int idcard, long cardnumber, long idacc, boolean blocked, int pin) {
        this.idcard = idcard;
        this.cardnumber = cardnumber;
        this.idacc = idacc;
        this.blocked = blocked;
        this.pin=pin;
    }

    public int getPin() {
        return pin;
    }

    public int getIdcard() {
        return idcard;
    }

    public long getCardnumber() {
        return cardnumber;
    }

    public long getIdacc() {
        return idacc;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    public void setCardnumber(long cardnumber) {
        this.cardnumber = cardnumber;
    }

    public void setIdacc(long idacc) {
        this.idacc = idacc;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    
}
