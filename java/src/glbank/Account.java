

package glbank;




public class Account {
        private long idacc;
        private int idc;
        private float balance;

    public long getIdacc() {
        return idacc;
    }

    public int getIdc() {
        return idc;
    }

    public float getBalance() {
        return balance;
    }

    public Account(long idacc, int idc, float balance) {
        this.idacc = idacc;
        this.idc = idc;
        this.balance = balance;
    }
}
