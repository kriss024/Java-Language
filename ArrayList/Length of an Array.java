public class MainClass {

  public static void main(String[] arg) {
    int[] intArray = new int[10];

    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = 100;
    }

    for (int i = 0; i < intArray.length; i++) {
      System.out.println(intArray[i]);
    }

  }

}