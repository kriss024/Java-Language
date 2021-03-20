package modelowanie;

import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.util.Random;


public class MainClass {
    public MainClass() {
    JWindow MainWindow = new JWindow("Java Window",50,50,400,400,false);
    JData macierz = new JData(400,400);
    MyCanvas Can = new MyCanvas(macierz);
    MainWindow.add(Can);
    MainWindow.setVisible(true);
    

    
    //--------------------------------------------------
    for (int q = 0; q < 500; q++){
    Random rand = new Random();
    for (int i = 0; i < 1000; i++){
    double x = (rand.nextDouble()*400); 
    double y = (rand.nextDouble()*400); 
    macierz.matrix[(int)x][(int)y]=3;
    }
    Can.repaint();
    try 
    {
    Thread.sleep(100); // do nothing for 1000 miliseconds (1 second)
    } 
    catch(InterruptedException e)
    {
    e.printStackTrace();
    } 
    macierz.cls(); 
    }
      
    //------------------------------------------------
    }
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
    }
}
