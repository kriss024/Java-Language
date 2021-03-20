import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Krzysztof on 2015-11-28.
 */
public class DoubleBufferWithBufferedImage extends JComponent{
    int gap = 3;

    public void paint(Graphics g) {

        Dimension d = getSize();
        int w = d.width;
        int h = d.height;

        BufferedImage buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        Graphics2D screengc = buffer.createGraphics();
        screengc.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        screengc.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        screengc.setColor(Color.blue);
        screengc.fillRect(0, 0, w, h);

        screengc.setColor(Color.red);
        for (int i = 0; i < w; i += gap)
            screengc.drawLine(i, 0, w - i, h);
        for (int i = 0; i < h; i += gap)
            screengc.drawLine(0, i, w, h - i);

        g.drawImage(buffer, 0, 0, null);

    }

}
