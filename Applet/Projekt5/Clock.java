import javax.swing.*; 
import java.awt.*; 

public class Clock extends JApplet { 

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


public void init() { 
    try { 
      SwingUtilities.invokeAndWait(new Runnable () { 
        public void run() { 
          guiInit(); // initialize the GUI 
        } 
      }); 
    } catch(Exception exc) { 
      System.out.println("Can't create because of "+ exc); 
    } 
  } 
 
  public void start() { 
    
  } 
 

  public void stop() { 
   
  } 

  public void destroy() { 
    
  } 
 
  
  private void guiInit() { 
      Container cp = getContentPane();
      cp.add(new MyComponent());
  
  } 
}
