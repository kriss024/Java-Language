import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Main extends Applet {
  private String name = "";

  public void init() {
    name = getParameter("name");
  }

  public void paint(Graphics g) {
    g.setColor(Color.BLUE);
    g.drawString(name, 0, 0);
  }
} 
 