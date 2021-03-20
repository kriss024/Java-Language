import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
 

public class HelloWorld extends JApplet { 
  JButton jbtnOne = new JButton("One"); 
  JButton jbtnTwo = new JButton("Two");; 
  JLabel jlab = new JLabel("Press a button."); 
 
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
      cp.setLayout(new FlowLayout());
      cp.add(jbtnOne);
      cp.add(jbtnTwo);
      cp.add(jlab);
 
    jbtnOne.addActionListener(new ActionListener() {      
      public void actionPerformed(ActionEvent le) {  
        jlab.setText("Button One pressed.");  
      }      
    });      
 
    jbtnTwo.addActionListener(new ActionListener() {      
      public void actionPerformed(ActionEvent le) {  
        jlab.setText("Button Two pressed.");  
      }      
    });      
  
  } 
}
