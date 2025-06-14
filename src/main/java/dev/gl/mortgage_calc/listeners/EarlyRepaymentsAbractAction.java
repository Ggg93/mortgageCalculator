package dev.gl.mortgage_calc.listeners;

import dev.gl.mortgage_calc.gui.EarlyRepaymentDialog;
import dev.gl.mortgage_calc.gui.EarlyRepaymentPanel;
import dev.gl.mortgage_calc.gui.MainWindow;
import dev.gl.mortgage_calc.models.EarlyRepayment;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author gl
 */
public class EarlyRepaymentsAbractAction extends AbstractAction {
    
    private EarlyRepaymentDialog parent;
    private MainWindow mw;

    public EarlyRepaymentsAbractAction(EarlyRepaymentDialog parent, MainWindow mw) {
        this.parent = parent;
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!parent.checkFieldValue()) {
            JOptionPane.showMessageDialog(parent,
                    "Amount must not be zero",
                    parent.getTitle(),
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int year = parent.getYear();
        Month month = parent.getMonth();
        LocalDate firstPaymentDate = LocalDate.of(year, month, 1);
        
        EarlyRepayment repayment = new EarlyRepayment();
        repayment.setAmount(new BigDecimal(parent.getAmount()));
        repayment.setFrequency(parent.getFrequency());
        repayment.setStrategy(parent.getStrategy());
        repayment.setFirstPaymentPeriod(firstPaymentDate);
        
        // creating new EarlyRepayment panel
        EarlyRepaymentPanel panel = new EarlyRepaymentPanel(mw, repayment);
        mw.addEarlyRepayment(panel);
        mw.refreshCalculations();
        parent.dispose();
    }
    
}
