package zad13;


public class ReversibleDouble implements Reversible {

    private double liczba;

    public ReversibleDouble(double i) {
        liczba = i;
    }

    @Override
    public void reverse() {
        liczba=1/liczba;
    }

    public String toString() {
        return  Double.toString(liczba);
    }

}
