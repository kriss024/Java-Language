import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class Arrow extends JComponent implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static double maxAlfa = 2*Math.PI;
    private int x0, y0, x, y, r;
    private String ts;
    private double div;
    private Color c;
    private Thread thread;

    public Arrow(int x0, int y0, int r,Color c, String ts,double div)
    {
        this.x0 = x0;
        this.y0 = y0;
        this.x = x0;
        this.y = y0;    
        this.r = r;   
        this.c = c;
        this.ts = ts;
        this.div = div;
        thread = new Thread(this);
        thread.start();
    }

    public void drawItself(Graphics gr)
    {
        gr.setColor(c);
        gr.drawLine(x0, y0, x, y);
    }

    public void run() 
    {
    	
        while (thread.isAlive()) 
        {
          Calendar cal = Calendar.getInstance();
  	  	  cal.getTime();
  	  	  SimpleDateFormat SSS_format = new SimpleDateFormat(ts);
  	  	  String SSS = SSS_format.format(cal.getTime());
  	  	  double dSSS=Double.parseDouble(SSS);
  	  	  double alfaSSS = dSSS/div*maxAlfa;
  	  	  double x_d = (double)x0+(double)r*Math.cos(alfaSSS);
  	  	  double y_d = (double)y0+(double)r*Math.sin(alfaSSS);
          x=(int)x_d;
          y=(int)y_d;

            
        }
    }
}