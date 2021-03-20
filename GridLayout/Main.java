import javax.swing.UIManager.*;
import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.exit(1);
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOknoAplikcaji oknoAplikcaji = new  JOknoAplikcaji("Okno aplikacji Java");
                oknoAplikcaji.setSize(800, 520);
                oknoAplikcaji.setLocationRelativeTo(null);
                oknoAplikcaji.setVisible(true);

            }
        });



    }
}
