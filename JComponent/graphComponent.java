import javax.swing.*;
import java.awt.*;

/**
 * Created by Krzysiek on 2015-01-13.
 */
public class graphComponent extends JComponent {

    private int Resolution;

    public graphComponent(){

    }

    public int getResolution(){
        return this.Resolution;
    }

    public void setResolution(int Resolution){
        this.Resolution = Resolution;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.red);
        float x = ((float)getWidth()-1)/getResolution();
        float y = ((float)getHeight()-1)/getResolution();

        for (int i = 0;x*i < getWidth();i++){
            int xround = Math.round(x * i);
            g.drawLine(xround, 0, xround, getHeight()-1);

        }
        for (int i = 0;y*i < getHeight();i++){
            int yround = Math.round(y * i);
            g.drawLine(0, yround, getWidth()-1, yround);

        }


    }


}
