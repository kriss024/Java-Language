import java.util.ArrayList;
import java.util.Collections;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<String>();

    arrayList.add("1");
    arrayList.add("3");
    arrayList.add("5");
    arrayList.add("2");
    arrayList.add("4");

    Collections.sort(arrayList);

    for (String str: arrayList)
      System.out.println(str);
  }
}
/*
1
2
3
4
5
*/