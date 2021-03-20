import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class MyPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    ArrayList<Ball> listBalls;

    public MyPanel()
    {
        this.setBackground(Color.WHITE);
        listBalls = new ArrayList<Ball>();
        listBalls.add(new Ball(30,30,Color.red));
        listBalls.add(new Ball(60,35,Color.orange));   
        listBalls.add(new Ball(90,30, Color.black));
        listBalls.add(new Ball(120,35, Color.pink));
    }

    @Override
    public void paint(Graphics gr)
    {
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(3f));
        super.paint(g);
            for(Ball b : listBalls)
            {
                b.drawItself(g);
            }   
        repaint();
    }
}
