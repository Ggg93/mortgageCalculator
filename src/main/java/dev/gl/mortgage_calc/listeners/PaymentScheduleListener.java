package dev.gl.mortgage_calc.listeners;

import dev.gl.mortgage_calc.gui.MainWindow;
import dev.gl.mortgage_calc.gui.PaymentScheduleDialog;
import dev.gl.mortgage_calc.models.MonthData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author gl
 */
public class PaymentScheduleListener implements ActionListener {
    
    private JFrame parent;
    private List<MonthData> monthsData;

    public PaymentScheduleListener(JFrame parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        monthsData = ((MainWindow) parent).getCalculator().getMonthsData();
        PaymentScheduleDialog dialog = new PaymentScheduleDialog(parent, true, monthsData);
        dialog.setVisible(true);
    }
    
}
