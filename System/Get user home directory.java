public class Main {
  public static void main(String[] args) {
    String userHome = "user.home";

    String path = System.getProperty(userHome);

    System.out.println("Your Home Path: " + path);
  }
}