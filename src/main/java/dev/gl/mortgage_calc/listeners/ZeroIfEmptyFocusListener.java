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
    private String defaultText;

    public ZeroIfEmptyFocusListener(JTextField textField, String defaultText) {
        this.textField = textField;
        this.defaultText = defaultText;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().equals(defaultText)) {
            textField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty()) {
            textField.setText(defaultText);
        }
    }
    
}
