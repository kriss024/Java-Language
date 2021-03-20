package zad11;

class Account {

    private double balance=0.0;
    private static double stopaOprocentowania=0.0;

    public Account() {
    }

    public void deposit(double cash) {
        if (cash>0) balance+=cash;
    }
    public void withdraw(double cash) {
        if (cash>0)
        if (balance>=cash) balance-=cash;
    }
    public static void setInterestRate(double so) {
        stopaOprocentowania=so;
    }
    public void transfer(Account p,double cash) {
        if (cash>0)
        if (balance>=cash) {
            withdraw(cash);
            p.deposit(cash);
        }
    }
    public void addInterest() {
        balance=balance*(100+stopaOprocentowania)/100;
    }
    public double getBalance(){
        return balance;
    }


}