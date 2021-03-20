
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyComponent extends JComponent
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Arrow> listArrows;

    public MyComponent()
    {
        listArrows = new ArrayList<Arrow>();
        listArrows.add(new Arrow(100,100,60,Color.green,"HH",23.0));
        listArrows.add(new Arrow(100,100,70,Color.black,"mm",59.0));
        listArrows.add(new Arrow(100,100,75,Color.blue,"ss",59.0));
        listArrows.add(new Arrow(100,100,80,Color.red,"SSS",999.0));
    }
    @Override
    public void paint(Graphics g)
    {
        for(Arrow a : listArrows)
            {
                a.drawItself(g);
            }   
        repaint();
        
    }
}
