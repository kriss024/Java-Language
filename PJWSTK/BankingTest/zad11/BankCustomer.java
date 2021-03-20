package zad11;

class BankCustomer {
    private Person osoba;
    private Account konto=new Account();
    public BankCustomer(Person p) {
        osoba=p;
    }
    public Account getAccount() {
        return konto;
    }
    public String toString()  {
        return "Klient: "+osoba.getPerson()+" stan konta "+konto.getBalance();
    }

}