package zad13;


public class ReversibleString  implements Reversible {

    private String tekst;

    public ReversibleString(String s) {
        tekst = s;
    }

    @Override
    public void reverse() {
        StringBuffer buffer = new StringBuffer(tekst);
        tekst=buffer.reverse().toString();
    }

    public String toString() {
        return  tekst;
    }
}
