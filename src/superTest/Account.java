package superTest;

public class Account{

    // field
    private String actno;
    private double balance;

    Account() {};
    Account(String actno, boolean balance) {
        System.out.println("父类构造函数执行！");
    }

    // getter and setter
    public void setActno(String actno) {
        this.actno = actno;
    }
    public String getActno() {
        return actno;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
}