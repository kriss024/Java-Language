import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class Main {

	public Main() {
		InitUI();
	}
		
	public void InitUI(){
		JFrame frame = new JFrame("Java Nimbus");
		
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
		    	if (frame.isDisplayable()) {
		    		frame.setVisible(false);
		    		frame.dispose();
	            }
			}
		});
		
		JButton button = new JButton("Click Me");
		button.setPreferredSize(new Dimension(500, 300));
		
		button.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {	
		    	if (frame.isDisplayable()) {
		    		frame.setVisible(false);
		    		frame.dispose();
	            }
		    }
		});

		frame.getContentPane().add(button, BorderLayout.CENTER);
		frame.pack();
		frame.setMinimumSize(new Dimension(400, 250));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			System.err.println("Nimbus is not available!");
			System.exit(1);
		}
		
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new Main();
            }
        });
	

	}

}
