package dev.gl.mortgage_calc.gui;

import dev.gl.mortgage_calc.models.EarlyRepayment;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author gl
 */
public class EarlyRepaymentPanel extends javax.swing.JPanel {

    private final MainWindow parent;
    private final EarlyRepayment repayment;

    public EarlyRepaymentPanel(MainWindow parent, EarlyRepayment repayment) {
        this.parent = parent;
        this.repayment = repayment;
        initComponents();
        setNumberFormatters();

        amountTextField.setValue(repayment.getAmount());
        frequencyTextField.setText(repayment.getFrequency().name());
        strategyTextField.setText(repayment.getStrategy().name());
        firstPaymentPeriodTextField.setText(repayment.getFirstPaymentPeriod().format(DateTimeFormatter.ofPattern("yyyy-MM")));

        deleteButton.addActionListener((e) -> {
            int answer = JOptionPane.showConfirmDialog(parent,
                    "Are you sure?",
                    parent.getTitle(),
                    JOptionPane.YES_NO_OPTION);

            if (answer == 0) {
                parent.deleteEarlyRepayment(this, repayment);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        amountTextField = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        frequencyTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        strategyTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        firstPaymentPeriodTextField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setMinimumSize(new java.awt.Dimension(400, 80));
        setPreferredSize(new java.awt.Dimension(400, 80));
        setLayout(new java.awt.GridLayout(2, 6));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Amount");
        add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Frequency");
        add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Strategy");
        add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("First Payment Period");
        add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Actions:");
        add(jLabel5);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        amountTextField.setEditable(false);
        amountTextField.setColumns(12);
        amountTextField.setText("0");
        amountTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(amountTextField, new java.awt.GridBagConstraints());

        add(jPanel1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        frequencyTextField.setEditable(false);
        frequencyTextField.setColumns(12);
        frequencyTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(frequencyTextField, new java.awt.GridBagConstraints());

        add(jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        strategyTextField.setEditable(false);
        strategyTextField.setColumns(12);
        strategyTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(strategyTextField, new java.awt.GridBagConstraints());

        add(jPanel3);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        firstPaymentPeriodTextField.setEditable(false);
        firstPaymentPeriodTextField.setColumns(12);
        firstPaymentPeriodTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 41, 58, 54);
        jPanel4.add(firstPaymentPeriodTextField, gridBagConstraints);

        add(jPanel4);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        deleteButton.setText("DELETE");
        jPanel5.add(deleteButton, new java.awt.GridBagConstraints());

        add(jPanel5);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amountTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField firstPaymentPeriodTextField;
    private javax.swing.JTextField frequencyTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField strategyTextField;
    // End of variables declaration//GEN-END:variables

    
    private void setNumberFormatters() {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        dfs.setGroupingSeparator(' ');

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", dfs);
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setMaximumIntegerDigits(9);
        decimalFormat.setMaximumFractionDigits(2);

        amountTextField.setFormatterFactory(new DefaultFormatterFactory(createNumberFormatter(decimalFormat)));
    }
    
    private NumberFormatter createNumberFormatter(DecimalFormat decimalFormat) {
        NumberFormatter formatter = new NumberFormatter(decimalFormat);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0.0);

        return formatter;
    }

}
