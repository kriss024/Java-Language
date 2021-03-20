import javax.swing.*;

import java.awt.*;
 
public class HelloWorld extends JApplet {
	
	  JLabel theText = new JLabel(
	    	     "<html>Hello! This is a multiline label with <b>bold</b> "
	    	     + "and <i>italic</i> text. <P> "
	    	     + "It can use paragraphs, horizontal lines, <hr> "
	    	     + "<font color=red>colors</font> "
	    	     + "and most of the other basic features of HTML 3.2</html>");

	public void init() {
		
		this.getContentPane().add(theText);
    }
     
    public void stop() {
    }
 
    public void start() {

    }
}