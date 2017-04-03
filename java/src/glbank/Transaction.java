/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glbank;

/**
 *
 * @author wdfeww
 */
public class Transaction {
    private float amount;
    private String description;
    private int idemp;
    private long srcacc;
    private long destacc;
    private int srcbank;
    private int destbank;

    public Transaction(float amount, String description, int idemp, long srcacc, long destacc, int srcbank, int destbank) {
        this.amount = amount;
        this.description = description;
        this.idemp = idemp;
        this.srcacc = srcacc;
        this.destacc = destacc;
        this.srcbank = srcbank;
        this.destbank = destbank;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public int getIdemp() {
        return idemp;
    }

    public long getSrcacc() {
        return srcacc;
    }

    public long getDestacc() {
        return destacc;
    }

    public int getSrcbank() {
        return srcbank;
    }

    public int getDestbank() {
        return destbank;
    }
    
    
}
