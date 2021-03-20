import org.opencv.core.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainApp {
    JFrame frame;
    VideoCapture camera;
    BufferedImage img;
    JLabel label;
    ImageIcon icon;
    Mat mat;
    public MainApp(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Kamierka intenretowa na OpenCV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        icon = new ImageIcon();
        label = new JLabel(icon);
        frame.add(label);

        camera = new VideoCapture(0);
        camera.open(0);
        if(!camera.isOpened()){
            System.out.println("Problem z uruchomieniem kamaery");
        }
        else{
            System.out.println("Kamera On");
        }

        mat = new Mat();

        camera.read(mat);
        img = Mat2Image(mat);
        icon.setImage(img);

        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (camera.isOpened()){
                System.out.println("Kamera Off");
                camera.release();
                }
                System.exit(0);  }
        });

        frame.pack();
        frame.setVisible(true);

    }

    public BufferedImage Mat2Image(Mat mat){
        byte[] data = new byte[mat.rows()*mat.cols()*(int)(mat.elemSize())];
        mat.get(0, 0, data);
        if (mat.channels() == 3) {
            for (int i = 0; i < data.length; i += 3) {
                byte temp = data[i];
                data[i] = data[i + 2];
                data[i + 2] = temp;
            }
        }
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), BufferedImage.TYPE_3BYTE_BGR);
        image.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), data);
        return image;
    }




    public void runCamera(){

        Thread thread = new Thread(){
            public void run(){
                while (frame.isVisible()&&camera.isOpened()) {
                    camera.retrieve(mat);
                    img = Mat2Image(mat);
                    icon.setImage(img);
                    frame.repaint();
                }
            }
        };
        thread.start();
    }


    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainApp app = new MainApp();
                app.runCamera();
            }
        });


    }

}
