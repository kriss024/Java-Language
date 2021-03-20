import javax.swing.JApplet;

public class MainApplet extends JApplet {
  public void init() {
    System.out.println("init");
  }

  public void start() {
    System.out.println("started");

  }
  
  public void stop() {
	    System.out.println("stoped");

	  }
  
  public void destroy() {
	    System.out.println("destroyed");

	  }
}