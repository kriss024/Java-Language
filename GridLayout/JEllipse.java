import javax.swing.*;
import java.awt.*;

/**
 * Created by Krzysiek on 2015-04-11.
 */
public class JEllipse extends JPanel {

    int param;
    Color color;

    public JEllipse(Color c){
        super();
        param=6;
        color=c;

    }

    public void SetRoundRect(int i){
        this.param=i;
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //Set  anti-alias!
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // Set anti-alias for text
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        g.setColor(color);
        g.fillRoundRect(0, 0, w, h, param, param);
    }


}
