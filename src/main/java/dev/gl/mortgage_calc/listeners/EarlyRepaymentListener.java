package dev.gl.mortgage_calc.listeners;

import dev.gl.mortgage_calc.gui.EarlyRepaymentDialog;
import dev.gl.mortgage_calc.gui.MainWindow;
import dev.gl.mortgage_calc.models.EarlyRepayment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gl
 */
public class EarlyRepaymentListener implements ActionListener {
    
    private MainWindow parent;
    private EarlyRepayment repayment;

    public EarlyRepaymentListener(MainWindow parent, EarlyRepayment repayment) {
        this.parent = parent;
        this.repayment = repayment;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        EarlyRepaymentDialog dialog = new EarlyRepaymentDialog(parent, true, repayment);
        dialog.setVisible(true);
    }
    
}
