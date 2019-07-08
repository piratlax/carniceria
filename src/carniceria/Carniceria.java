package carniceria;

import java.awt.EventQueue;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;
import vista.EscritorioPrincipal;

public class Carniceria {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeCoffeeSkin");
                    SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceTerracotta");

                } catch (Exception e) {
                }
                Splash.setDefaultLookAndFeelDecorated(false);
                new Splash().setVisible(true);
                
            }
        });
    }
}
