import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame window = new JFrame("Double buffer with BufferedImage Java");
            window.setSize(new Dimension(900,600));
            window.getContentPane().add(new DoubleBufferWithBufferedImage());
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        }
    });
}}
