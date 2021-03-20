import java.awt.*;
import javax.swing.*;

public class Ball extends JPanel implements Runnable
{
    private static final long serialVersionUID = 1L;
    private int x, y;
    private Color c;
    private Thread thread;

    public Ball(int x, int y,Color c)
    {
        this.x = x;
        this.y = y;
        this.c = c;
        thread = new Thread(this);
        thread.start();
    }

    public void drawItself(Graphics2D g)
    {
        g.setColor(c);
        g.fillOval(x, y, 13, 13);
    }

    public void run() 
    {
        while (thread.isAlive()) 
        {
            x+=(int)(4.0*Math.random()-1);
            y+=(int)(4.0*Math.random()-1);
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}