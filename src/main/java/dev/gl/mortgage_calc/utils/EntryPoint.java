package dev.gl.mortgage_calc.utils;

import dev.gl.mortgage_calc.gui.MainWindow;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author gl
 */
public class EntryPoint {

    public static void main(String[] args) {

        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.PLAIN, 14));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            Font font = UIManager.getFont("OptionPane.messageFont");
//            System.out.println("fontName = " + font.getFontName());
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

        SwingUtilities.invokeLater(() -> {
            MainWindow mw = new MainWindow();
            mw.setVisible(true);
        });
    }
}
