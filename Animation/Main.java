import javax.swing.*;

public class Main extends JFrame
{
    private static final long serialVersionUID = 1L;
    private static final int _HEIGHT = 480, _WIDTH = 320;
    private MyPanel panel;

    public Main()
    {
        super("Test");

        panel = new MyPanel();

        this.setContentPane(panel);
        this.setBounds(350,100,_HEIGHT,_WIDTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}