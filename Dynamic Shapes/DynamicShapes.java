import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DynamicShapes extends JPanel {

    private List<Object> shapes = new ArrayList<>();
    private Random random = new Random();

    public DynamicShapes(int i, String shape) {
        int width = 800;
        int height = 800;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(width, height));

        switch (shape) {
            case "Circles":
                for (int j = 0; j < i; j++) {
                    addCircle(width, height);
                }
                break;
            case "Stars":
                for (int j = 0; j < i; j++) {
                    addStar(width, height);
                }
                break;
            case "Both":
                int mid = i / 2;
                for (int j = 0; j < mid; j++) {
                    addCircle(width, height);
                }
                for (int j = mid; j < i; j++) {
                    addStar(width, height);
                }
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof Circle) {
                ((Circle) s).draw(g);
            } else if (s instanceof Star) {
                ((Star) s).draw(g);
            }
        }
    }

    public void addCircle(int maxX, int maxY) {
        shapes.add(new Circle(random.nextInt(maxX), random.nextInt(maxY)));
        repaint();
    }

    public void addStar(int maxX, int maxY) {
        shapes.add(new Star(random.nextInt(maxX), random.nextInt(maxY)));
        repaint();
    }

    public static void main(String[] args) {

        String shapeAmount = JOptionPane.showInputDialog(null,
                "How many shapes?", "Random Shapes...", JOptionPane.PLAIN_MESSAGE);
        int amount = Integer.parseInt(shapeAmount);

        String shapes[] = {"Stars", "Circles", "Both"};
        String shape = (String) JOptionPane.showInputDialog(null,
                "Pick the shape you want", "Random Shapes...",
                JOptionPane.PLAIN_MESSAGE, null, shapes, shapes[0]);

        JFrame frame = new JFrame();
        frame.add(new DynamicShapes(amount, shape));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}