package dev.gl.mortgage_calc.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class ZeroIfEmptyFocusListener implements FocusListener{
    
    private JTextField textField;

    public ZeroIfEmptyFocusListener(JTextField textField) {
        this.textField = textField;
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().equals("0")) {
            textField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty()) {
            textField.setText("0");
        }
    }
    
}
