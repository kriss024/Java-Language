import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Description
  *
  * @version 1.0 from 2016-08-21
  * @author 
  */

public class Frame extends JFrame {
  // start attributes
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JNumberField jNumberField1 = new JNumberField();
  // end attributes
  
  public Frame() { 
    // Frame-Init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 500; 
    int frameHeight = 400;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Formularz");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jButton1.setBounds(80, 280, 75, 25);
    jButton1.setText("jButton1");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(320, 280, 75, 25);
    jButton2.setText("jButton2");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jNumberField1.setBounds(80, 24, 75, 20);
    jNumberField1.setText("");
    cp.add(jNumberField1);
    // end components
    
    setVisible(true);
  } // end of public Frame
  
  // start methods
  
  public static void main(String[] args) {
    new Frame();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    String st="jButton1";
    JOptionPane.showMessageDialog(null,st);
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    String st="jButton2";
    JOptionPane.showMessageDialog(null,st);
  } // end of jButton2_ActionPerformed

  // end methods
} // end of class Frame
