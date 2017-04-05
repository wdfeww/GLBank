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

    public Card(int idcard, long cardnumber, long idacc, boolean blocked) {
        this.idcard = idcard;
        this.cardnumber = cardnumber;
        this.idacc = idacc;
        this.blocked = blocked;
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
    
}
