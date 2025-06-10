package dev.gl.mortgage_calc.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author gl
 */
public class ExitListener implements ActionListener{

    private JFrame parent;

    public ExitListener(JFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.dispose();
        System.exit(0);
    }
    
}
