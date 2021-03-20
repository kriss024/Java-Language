import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class JOknoAplikcaji extends JFrame {
    JSlider slider1;
    JEllipse ellipse1;
    GridLayout gridLayout;
    FlowLayout layout;
    JSlider slider2;
    JEllipse ellipse2;
    JPanel cards;
    Container pane;


    public JOknoAplikcaji(String title){
        super(title);
    }
    protected void frameInit(){
        super.frameInit();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane = this.getContentPane();
        gridLayout = new GridLayout(2,3);
        gridLayout.setHgap(20);
        gridLayout.setVgap(20);
        pane.setLayout(gridLayout);


        /*-----------------------------------------------------------*/

        ellipse1 =  new JEllipse(Color.orange);
        pane.add(ellipse1);
        slider1 = new JSlider(JSlider.HORIZONTAL,0, 100, 25);
        slider1.setMinorTickSpacing(2);
        slider1.setMajorTickSpacing(10);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);

        ellipse1.SetRoundRect(slider1.getValue());

        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                ellipse1.SetRoundRect(slider1.getValue());

            }
        });
        pane.add(slider1);
        /*-----------------------------------------------------------*/


        JPanel card1 = new JPanel(new FlowLayout());
        card1.add(new JTextField(5));
        card1.add(new JButton("Start"));

        layout = new FlowLayout();
        layout.setHgap(3);
        layout.setVgap(3);

        JPanel card2 = new JPanel(layout);
        for(int i = 0; i < 25; i++) {
            card2.add(new JButton(Integer.toString(i)));

        }
        cards = new JPanel(new BorderLayout());
        cards.add(card1,BorderLayout.NORTH);
        cards.add(card2,BorderLayout.CENTER);
        pane.add(cards);
        /*-----------------------------------------------------------*/

        ellipse2 =  new JEllipse(Color.pink);
        pane.add(ellipse2);
        slider2 = new JSlider(JSlider.HORIZONTAL,0, 100, 75);
        slider2.setMinorTickSpacing(2);
        slider2.setMajorTickSpacing(10);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);

        ellipse2.SetRoundRect(slider2.getValue());
        slider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                ellipse2.SetRoundRect(slider2.getValue());

            }
        });
        pane.add(slider2);

        /*-----------------------------------------------------------*/
    }


}
