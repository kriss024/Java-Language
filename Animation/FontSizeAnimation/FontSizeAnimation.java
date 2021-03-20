import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class FontSizeAnimation extends JPanel implements Runnable {
  private int x;
  private float alpha;
  private Thread t;

  public FontSizeAnimation() {
    x=1;
    alpha = 1f;
    t = new Thread(this);
    t.start();
  }
  
    public void run() {
      while (true)
        {          
           this.repaint();
            x += 1;
            alpha = alpha - alpha*0.005f;
            try {
               Thread.sleep(5);
               } catch (InterruptedException iex) {
                      System.err.println("Exception in thread: "+iex.getMessage());
            }
            
        }
  
    }
  public void paint(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON);

    Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
    g2d.setComposite(c); 

    Font font = new Font("Dialog", Font.PLAIN, x);
    g2d.setFont(font);

    FontMetrics fm = g2d.getFontMetrics();
    String s = "Java";
    
    int w = (int) getSize().getWidth();
    int h = (int) getSize().getHeight();

    int stringWidth = fm.stringWidth(s);

    g2d.drawString(s, (w - stringWidth) / 2, h / 2);
  }

  public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("FontSizeAnimation");
                frame.add(new FontSizeAnimation());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
          });
      
  }

}