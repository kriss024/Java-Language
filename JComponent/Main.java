import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by Krzysiek on 2015-01-13.
 */
public class Main {

    public static void main(String[] args)
    {
        // schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayJFrame();
            }
        });
    }

    public static void  displayJFrame(){
        JFrame frame = new JFrame("Artificial Neural Network Demo - Recognizing Gestures");
        frame.setSize(new Dimension(600, 400));
        frame.setMinimumSize(new Dimension(300, 200));
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        graphComponent compo = new graphComponent();
        compo.setResolution(10);

        frame.add(compo);
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton trainButton = new JButton("Train");
        JButton recognizeButton = new JButton("Recognize");
        panel.add(addButton);
        panel.add(trainButton);
        panel.add(recognizeButton);
        frame.add(panel,BorderLayout.SOUTH);

        frame.setVisible(true);
    }


    //-------------------------------------


}
