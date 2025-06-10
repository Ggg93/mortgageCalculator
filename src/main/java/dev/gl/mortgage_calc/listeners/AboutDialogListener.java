package dev.gl.mortgage_calc.listeners;

import dev.gl.mortgage_calc.gui.AboutDialog;
import dev.gl.mortgage_calc.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gl
 */
public class AboutDialogListener implements ActionListener{

    private MainWindow mw;

    public AboutDialogListener(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AboutDialog dialog = new AboutDialog(mw, true);
        dialog.setVisible(true);
    }
    
}
