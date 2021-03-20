package zad21;

public class Main {
  
  public static void main(String ... args) throws Exception  {
    Finder finder = new Finder("../Test.java");
    int nif = finder.getIfCount();
    int nwar = finder.getStringCount("wariant");
    System.out.println("Liczba instrukcji if: " + nif);
    System.out.println("Liczba napisow wariant: " + nwar);
  }
  
}
