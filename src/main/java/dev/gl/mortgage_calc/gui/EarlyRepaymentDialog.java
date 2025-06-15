package dev.gl.mortgage_calc.gui;

import dev.gl.mortgage_calc.enums.Frequency;
import dev.gl.mortgage_calc.enums.Strategy;
import dev.gl.mortgage_calc.listeners.EarlyRepaymentsAbractAction;
import dev.gl.mortgage_calc.models.EarlyRepayment;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import java.util.stream.IntStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author gl
 */
public class EarlyRepaymentDialog extends javax.swing.JDialog {

    private EarlyRepayment repayment;
    private MainWindow mw;

    public EarlyRepaymentDialog(java.awt.Frame parent, boolean modal, EarlyRepayment repayment) {
        super(parent, modal);
        mw = (MainWindow) parent;
        initComponents();
        setTitle(parent.getTitle());
        setIconImage(parent.getIconImage());
        this.repayment = repayment;
        this.setLocationRelativeTo(null);
        prepareAmountJTextField();
        initFrequencyCombobox();
        initStrategyCombobox();
        initYearCombobox();
        initMonthCombobox();
        addListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        amountTextField = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        frequencyComboBox = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        strategyComboBox = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Amount: ");
        jPanel3.add(jLabel1);

        amountTextField.setColumns(12);
        amountTextField.setText("0");
        amountTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(amountTextField);

        jPanel9.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Frequency: ");
        jPanel4.add(jLabel2);

        frequencyComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        frequencyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(frequencyComboBox);

        jPanel9.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Strategy: ");
        jPanel5.add(jLabel3);

        strategyComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        strategyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(strategyComboBox);

        jPanel9.add(jPanel5);

        jPanel1.add(jPanel9);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First Payment Period", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Year: ");
        jPanel6.add(jLabel4);

        yearComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(yearComboBox);

        jPanel8.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Month: ");
        jPanel7.add(jLabel5);

        monthComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(monthComboBox);

        jPanel8.add(jPanel7);

        jPanel1.add(jPanel8);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        okButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        okButton.setText("OK");
        jPanel2.add(okButton);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amountTextField;
    private javax.swing.JComboBox frequencyComboBox;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox strategyComboBox;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables

    private void prepareAmountJTextField() {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        dfs.setGroupingSeparator(' ');

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", dfs);
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setMaximumIntegerDigits(9);
        decimalFormat.setMaximumFractionDigits(2);

        amountTextField.setFormatterFactory(new DefaultFormatterFactory(createNumberFormatter(decimalFormat)));
        amountTextField.setValue(0);
    }

    private NumberFormatter createNumberFormatter(DecimalFormat decimalFormat) {
        NumberFormatter formatter = new NumberFormatter(decimalFormat);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0.0);

        return formatter;
    }

    private void initFrequencyCombobox() {
        DefaultComboBoxModel<Frequency> model = new DefaultComboBoxModel<>(Frequency.values());
        frequencyComboBox.setModel(model);
        frequencyComboBox.setSelectedItem(Frequency.SINGLE);
    }

    private void initStrategyCombobox() {
        DefaultComboBoxModel<Strategy> model = new DefaultComboBoxModel<>(Strategy.values());
        strategyComboBox.setModel(model);
        strategyComboBox.setSelectedItem(Strategy.TERM_REDUCTION);
    }

    private void initYearCombobox() {
        int currentYear = LocalDate.now().getYear();

        DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
        model.addAll(IntStream
                .rangeClosed(currentYear, currentYear + 10)
                .boxed()
                .toList());
        yearComboBox.setModel(model);
        yearComboBox.setSelectedItem(model.getElementAt(0));
    }

    private void initMonthCombobox() {
        DefaultComboBoxModel<Month> model = new DefaultComboBoxModel<>(Month.values());
        monthComboBox.setModel(model);
        monthComboBox.setSelectedItem(LocalDate.now().plusMonths(1L).getMonth());

    }

    

    private void addListeners() {
        EarlyRepaymentsAbractAction okButtonListener = new EarlyRepaymentsAbractAction(this, mw);
        okButton.addActionListener(okButtonListener);
        
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ok");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");

        this.getRootPane().getActionMap().put("ok", okButtonListener);
    }
    
    public boolean checkFieldValue() {
        try {
            Double val = Double.parseDouble(amountTextField.getValue().toString());
            return val.compareTo(0d) > 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Double getAmount() {
        return Double.valueOf(amountTextField.getText().replaceAll(" ", ""));
    }
    
    public Frequency getFrequency() {
        return (Frequency) frequencyComboBox.getSelectedItem();
    }
    
    public Strategy getStrategy() {
        return (Strategy) strategyComboBox.getSelectedItem();
    }
    
    public Integer getYear() {
        return (Integer) yearComboBox.getSelectedItem();
    }
    
    public Month getMonth() {
        return (Month) monthComboBox.getSelectedItem();
    }

}
