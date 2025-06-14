package dev.gl.mortgage_calc.gui;

import dev.gl.mortgage_calc.listeners.AboutDialogListener;
import dev.gl.mortgage_calc.listeners.CalculateButtonListener;
import dev.gl.mortgage_calc.listeners.ExitListener;
import dev.gl.mortgage_calc.listeners.DefaultIfEmptyFocusListener;
import dev.gl.mortgage_calc.listeners.EarlyRepaymentListener;
import dev.gl.mortgage_calc.listeners.PaymentScheduleListener;
import dev.gl.mortgage_calc.models.Calculator;
import dev.gl.mortgage_calc.models.EarlyRepayment;
import dev.gl.mortgage_calc.utils.DoubleRangeDocumentFilter;
import dev.gl.mortgage_calc.utils.IntegerRangeDocumentFilter;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author gl
 */
public class MainWindow extends javax.swing.JFrame {

    private Calculator calculator;
    private List<EarlyRepaymentPanel> earlyRepaymentPanels;

    public MainWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIcon();
        addListeners();
        setDocumentFilters();
        setNumberFormatters();

        earlyRepaymentPanels = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        mainPanel = new javax.swing.JPanel();
        mainDataPanel = new javax.swing.JPanel();
        mainInputPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        homeValueTextField = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        downPaymentTextField = new javax.swing.JFormattedTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        interestRateTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        loanTermTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mainOutputPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        loanAmountTextField = new javax.swing.JFormattedTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        monthlyPaymentTextField = new javax.swing.JFormattedTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        totalInterestPaidTextField = new javax.swing.JFormattedTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        loadPayoffDateTextField = new javax.swing.JTextField();
        mainButtonsPanel = new javax.swing.JPanel();
        calculateButton = new javax.swing.JButton();
        openPaymentScheduleButton = new javax.swing.JButton();
        earlyRepaymentsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        earlyRepaymentsScrollPane = new javax.swing.JScrollPane();
        viewportPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        addNewEarlyRepaymentButton = new javax.swing.JButton();
        chartsPanel = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mortgage Calculator");
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mainPanel.setLayout(new java.awt.BorderLayout());

        mainDataPanel.setLayout(new javax.swing.BoxLayout(mainDataPanel, javax.swing.BoxLayout.LINE_AXIS));

        mainInputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        mainInputPanel.setLayout(new java.awt.GridLayout(4, 0));

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Home Value: ");
        jPanel8.add(jLabel1);

        homeValueTextField.setColumns(12);
        homeValueTextField.setText("0");
        homeValueTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeValueTextField.setValue(0);
        jPanel8.add(homeValueTextField);

        mainInputPanel.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Down Payment: ");
        jPanel9.add(jLabel2);

        downPaymentTextField.setColumns(12);
        downPaymentTextField.setText("0");
        downPaymentTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        downPaymentTextField.setValue(0);
        jPanel9.add(downPaymentTextField);

        mainInputPanel.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Interest Rate: ");
        jPanel10.add(jLabel3);

        interestRateTextField.setColumns(5);
        interestRateTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        interestRateTextField.setText("0");
        jPanel10.add(interestRateTextField);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("%");
        jPanel10.add(jLabel9);

        mainInputPanel.add(jPanel10);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Loan Term: ");
        jPanel11.add(jLabel4);

        loanTermTextField.setColumns(3);
        loanTermTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loanTermTextField.setText("1");
        jPanel11.add(loanTermTextField);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("years");
        jPanel11.add(jLabel10);

        mainInputPanel.add(jPanel11);

        mainDataPanel.add(mainInputPanel);

        mainOutputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Output", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        mainOutputPanel.setLayout(new java.awt.GridLayout(4, 0));

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Loan Amount: ");
        jPanel12.add(jLabel5);

        loanAmountTextField.setEditable(false);
        loanAmountTextField.setColumns(9);
        loanAmountTextField.setText("0");
        loanAmountTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel12.add(loanAmountTextField);

        mainOutputPanel.add(jPanel12);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Monthly Payment: ");
        jPanel13.add(jLabel6);

        monthlyPaymentTextField.setEditable(false);
        monthlyPaymentTextField.setColumns(9);
        monthlyPaymentTextField.setText("0");
        monthlyPaymentTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel13.add(monthlyPaymentTextField);

        mainOutputPanel.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Total Interest Paid: ");
        jPanel14.add(jLabel7);

        totalInterestPaidTextField.setEditable(false);
        totalInterestPaidTextField.setColumns(9);
        totalInterestPaidTextField.setText("0");
        totalInterestPaidTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel14.add(totalInterestPaidTextField);

        mainOutputPanel.add(jPanel14);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Loan Pay-off date: ");
        jPanel15.add(jLabel8);

        loadPayoffDateTextField.setEditable(false);
        loadPayoffDateTextField.setColumns(9);
        loadPayoffDateTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel15.add(loadPayoffDateTextField);

        mainOutputPanel.add(jPanel15);

        mainDataPanel.add(mainOutputPanel);

        mainPanel.add(mainDataPanel, java.awt.BorderLayout.CENTER);

        calculateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        calculateButton.setText("Calculate");
        mainButtonsPanel.add(calculateButton);

        openPaymentScheduleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openPaymentScheduleButton.setText("Open Payment Schedule");
        openPaymentScheduleButton.setEnabled(false);
        mainButtonsPanel.add(openPaymentScheduleButton);

        mainPanel.add(mainButtonsPanel, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Main", mainPanel);

        earlyRepaymentsPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        viewportPanel.setLayout(new javax.swing.BoxLayout(viewportPanel, javax.swing.BoxLayout.Y_AXIS));
        earlyRepaymentsScrollPane.setViewportView(viewportPanel);

        jPanel1.add(earlyRepaymentsScrollPane, java.awt.BorderLayout.CENTER);

        earlyRepaymentsPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        addNewEarlyRepaymentButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addNewEarlyRepaymentButton.setText("Add New Early Repayment");
        addNewEarlyRepaymentButton.setEnabled(false);
        jPanel2.add(addNewEarlyRepaymentButton);

        earlyRepaymentsPanel.add(jPanel2, java.awt.BorderLayout.NORTH);

        jTabbedPane1.addTab("Early Repayments", earlyRepaymentsPanel);

        javax.swing.GroupLayout chartsPanelLayout = new javax.swing.GroupLayout(chartsPanel);
        chartsPanel.setLayout(chartsPanelLayout);
        chartsPanelLayout.setHorizontalGroup(
            chartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        chartsPanelLayout.setVerticalGroup(
            chartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Charts", chartsPanel);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        mainMenuBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mainMenu.setText("Menu");
        mainMenu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        aboutMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aboutMenuItem.setText("About");
        mainMenu.add(aboutMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exitMenuItem.setText("Exit");
        mainMenu.add(exitMenuItem);

        mainMenuBar.add(mainMenu);

        setJMenuBar(mainMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton addNewEarlyRepaymentButton;
    private javax.swing.JButton calculateButton;
    private javax.swing.JPanel chartsPanel;
    private javax.swing.JFormattedTextField downPaymentTextField;
    private javax.swing.JPanel earlyRepaymentsPanel;
    private javax.swing.JScrollPane earlyRepaymentsScrollPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JFormattedTextField homeValueTextField;
    private javax.swing.JTextField interestRateTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField loadPayoffDateTextField;
    private javax.swing.JFormattedTextField loanAmountTextField;
    private javax.swing.JTextField loanTermTextField;
    private javax.swing.JPanel mainButtonsPanel;
    private javax.swing.JPanel mainDataPanel;
    private javax.swing.JPanel mainInputPanel;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JPanel mainOutputPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JFormattedTextField monthlyPaymentTextField;
    private javax.swing.JButton openPaymentScheduleButton;
    private javax.swing.JFormattedTextField totalInterestPaidTextField;
    private javax.swing.JPanel viewportPanel;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/icons8-mortgage-40.png"));
        this.setIconImage(icon.getImage());
    }

    private void addListeners() {

        // main tab
        aboutMenuItem.addActionListener(new AboutDialogListener(this));
        exitMenuItem.addActionListener(new ExitListener(this));
        calculateButton.addActionListener(new CalculateButtonListener(this));
        openPaymentScheduleButton.addActionListener(new PaymentScheduleListener(this));

        homeValueTextField.addFocusListener(new DefaultIfEmptyFocusListener(homeValueTextField, "0"));
        downPaymentTextField.addFocusListener(new DefaultIfEmptyFocusListener(downPaymentTextField, "0"));
        interestRateTextField.addFocusListener(new DefaultIfEmptyFocusListener(interestRateTextField, "0"));
        loanTermTextField.addFocusListener(new DefaultIfEmptyFocusListener(loanTermTextField, "1"));

        // early repayments tab
        addNewEarlyRepaymentButton.addActionListener(new EarlyRepaymentListener(this, null));

    }

    public void refreshCalculations() {
        CalculateButtonListener cbl = null;
        for (ActionListener actionListener : calculateButton.getActionListeners()) {
            if (actionListener instanceof CalculateButtonListener) {
                cbl = (CalculateButtonListener) actionListener;
                break;
            }
        }
        if (cbl == null) {
            return;
        }

        cbl.actionPerformed(null);
    }

    private void setDocumentFilters() {
        ((AbstractDocument) homeValueTextField.getDocument())
                .setDocumentFilter(new DoubleRangeDocumentFilter(0.0, 999999999.0));
        ((AbstractDocument) downPaymentTextField.getDocument())
                .setDocumentFilter(new DoubleRangeDocumentFilter(0.0, 999999999.0));
        ((AbstractDocument) interestRateTextField.getDocument())
                .setDocumentFilter(new DoubleRangeDocumentFilter(0.0, 99.9));
        ((AbstractDocument) loanTermTextField.getDocument())
                .setDocumentFilter(new IntegerRangeDocumentFilter(1, 50));
    }

    public boolean isInputValid() {
        Double downPayment = Double.parseDouble(downPaymentTextField.getText().replaceAll(" ", ""));
        Double homeValue = Double.parseDouble(homeValueTextField.getText().replaceAll(" ", ""));
        if (downPayment.compareTo(homeValue) >= 0) {
            JOptionPane.showMessageDialog(this,
                    "Down Payment should be less than Home Value",
                    getTitle(),
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        return true;
    }

    public Calculator createCalculator() {

        try {
            BigDecimal homeValue = new BigDecimal(homeValueTextField.getText().replaceAll(" ", ""));
            BigDecimal downPayment = new BigDecimal(downPaymentTextField.getText().replaceAll(" ", ""));
            BigDecimal interestRate = new BigDecimal(interestRateTextField.getText());
            BigDecimal loanTerm = new BigDecimal(loanTermTextField.getText());

            List<EarlyRepayment> earlyRepayments = new ArrayList<>();
            for (EarlyRepaymentPanel earlyRepaymentPanel : earlyRepaymentPanels) {
                earlyRepayments.add(earlyRepaymentPanel.getRepayment());
            }

            calculator = new Calculator(homeValue, downPayment, interestRate, loanTerm, earlyRepayments);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return calculator;
    }

    public void showOutput() {
        loanAmountTextField.setText(calculator.getLoanAmount().setScale(2, RoundingMode.HALF_UP).toString());
        monthlyPaymentTextField.setText(calculator.getMonthlyPayment().setScale(2, RoundingMode.HALF_UP).toString());
        totalInterestPaidTextField.setText(calculator.getTotalInterestPaid().setScale(2, RoundingMode.HALF_UP).toString());
        loadPayoffDateTextField.setText(calculator.getPayOffDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));
        setOpenPaymentScheduleButtonEnabled(true);
        setAddNewEarlyRepaymentButtonEnabled(true);
    }

    private void setNumberFormatters() {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        dfs.setGroupingSeparator(' ');

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", dfs);
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setMaximumIntegerDigits(9);
        decimalFormat.setMaximumFractionDigits(2);

        homeValueTextField.setFormatterFactory(new DefaultFormatterFactory(createNumberFormatter(decimalFormat)));
        downPaymentTextField.setFormatterFactory(new DefaultFormatterFactory(createNumberFormatter(decimalFormat)));
        loanAmountTextField.setFormatterFactory(new DefaultFormatterFactory(createNumberFormatter(decimalFormat)));
        monthlyPaymentTextField.setFormatterFactory(new DefaultFormatterFactory(createNumberFormatter(decimalFormat)));
        totalInterestPaidTextField.setFormatterFactory(new DefaultFormatterFactory(createNumberFormatter(decimalFormat)));
    }

    private NumberFormatter createNumberFormatter(DecimalFormat decimalFormat) {
        NumberFormatter formatter = new NumberFormatter(decimalFormat);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0.0);

        return formatter;
    }

    private void setOpenPaymentScheduleButtonEnabled(boolean isEnabled) {
        openPaymentScheduleButton.setEnabled(isEnabled);
    }

    private void setAddNewEarlyRepaymentButtonEnabled(boolean isEnabled) {
        addNewEarlyRepaymentButton.setEnabled(isEnabled);
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void addEarlyRepayment(EarlyRepaymentPanel panel) {
        panel.setSize(Integer.MAX_VALUE, 100);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        viewportPanel.add(panel);
        this.revalidate();
        this.repaint();

        earlyRepaymentPanels.add(panel);
    }

    public void deleteEarlyRepayment(EarlyRepaymentPanel panel) {
        viewportPanel.remove(panel);
        earlyRepaymentPanels.remove(panel);
        refreshCalculations();

        this.revalidate();
        this.repaint();
    }

}
