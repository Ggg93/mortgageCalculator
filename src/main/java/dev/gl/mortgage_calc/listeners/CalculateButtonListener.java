package dev.gl.mortgage_calc.listeners;

import dev.gl.mortgage_calc.gui.MainWindow;
import dev.gl.mortgage_calc.models.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gl
 */
public class CalculateButtonListener implements ActionListener {

    private MainWindow mw;

    public CalculateButtonListener(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!mw.isInputValid()) {
            return;
        }
        
        Calculator calculator = mw.createCalculator();
        calculator.calculateMortgage();
        mw.showOutput();
    }

}
