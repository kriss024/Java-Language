package modelowanie;

import java.awt.*;
import javax.swing.*;

public class JWindow extends JFrame {

public JWindow(String nazwa,int x,int y,int sizex,int sizey,boolean resize){
    super(nazwa);
    setBounds(x,y,sizex,sizey);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
    setResizable(resize);                 
    }
}
