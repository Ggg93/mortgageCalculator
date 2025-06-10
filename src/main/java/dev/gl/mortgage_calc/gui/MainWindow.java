package dev.gl.mortgage_calc.gui;

import dev.gl.mortgage_calc.listeners.AboutDialogListener;
import dev.gl.mortgage_calc.listeners.CalculateButtonListener;
import dev.gl.mortgage_calc.listeners.ExitListener;
import dev.gl.mortgage_calc.utils.IntegerRangeDocumentFilter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author gl
 */
public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIcon();
        addListeners();
        setDocumentFilters();
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
        homeValueTextField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        downPaymentTextField = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        interestRateTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        loarTermTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mainOutputPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        loanAmountTextField = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        monthlyPaymentTextField = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        totalInterestPaidTextField = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        loadPayoffDateTextField = new javax.swing.JTextField();
        mainButtonsPanel = new javax.swing.JPanel();
        calculateButton = new javax.swing.JButton();
        openPaymentScheduleButton = new javax.swing.JButton();
        earlyRepaymentsPanel = new javax.swing.JPanel();
        chartsPanel = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mortgage Calculator");
        setMinimumSize(new java.awt.Dimension(400, 300));

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mainPanel.setLayout(new java.awt.BorderLayout());

        mainDataPanel.setLayout(new javax.swing.BoxLayout(mainDataPanel, javax.swing.BoxLayout.LINE_AXIS));

        mainInputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        mainInputPanel.setLayout(new java.awt.GridLayout(4, 0));

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Home Value: ");
        jPanel8.add(jLabel1);

        homeValueTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeValueTextField.setText("0");
        jPanel8.add(homeValueTextField);

        mainInputPanel.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Down Payment: ");
        jPanel9.add(jLabel2);

        downPaymentTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        downPaymentTextField.setText("0");
        jPanel9.add(downPaymentTextField);

        mainInputPanel.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Interest Rate: ");
        jPanel10.add(jLabel3);

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

        loarTermTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loarTermTextField.setText("0");
        jPanel11.add(loarTermTextField);

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
        loanAmountTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loanAmountTextField.setText("0");
        jPanel12.add(loanAmountTextField);

        mainOutputPanel.add(jPanel12);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Monthly Payment: ");
        jPanel13.add(jLabel6);

        monthlyPaymentTextField.setEditable(false);
        monthlyPaymentTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        monthlyPaymentTextField.setText("0");
        jPanel13.add(monthlyPaymentTextField);

        mainOutputPanel.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Total Interest Paid: ");
        jPanel14.add(jLabel7);

        totalInterestPaidTextField.setEditable(false);
        totalInterestPaidTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalInterestPaidTextField.setText("0");
        jPanel14.add(totalInterestPaidTextField);

        mainOutputPanel.add(jPanel14);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Loan Pay-off date: ");
        jPanel15.add(jLabel8);

        loadPayoffDateTextField.setEditable(false);
        loadPayoffDateTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loadPayoffDateTextField.setText("0");
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

        javax.swing.GroupLayout earlyRepaymentsPanelLayout = new javax.swing.GroupLayout(earlyRepaymentsPanel);
        earlyRepaymentsPanel.setLayout(earlyRepaymentsPanelLayout);
        earlyRepaymentsPanelLayout.setHorizontalGroup(
            earlyRepaymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );
        earlyRepaymentsPanelLayout.setVerticalGroup(
            earlyRepaymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Early Repayments", earlyRepaymentsPanel);

        javax.swing.GroupLayout chartsPanelLayout = new javax.swing.GroupLayout(chartsPanel);
        chartsPanel.setLayout(chartsPanelLayout);
        chartsPanelLayout.setHorizontalGroup(
            chartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );
        chartsPanelLayout.setVerticalGroup(
            chartsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Charts", chartsPanel);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        mainMenuBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mainMenu.setText("Menu");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        aboutMenuItem.setText("About");
        mainMenu.add(aboutMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitMenuItem.setText("Exit");
        mainMenu.add(exitMenuItem);

        mainMenuBar.add(mainMenu);

        setJMenuBar(mainMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton calculateButton;
    private javax.swing.JPanel chartsPanel;
    private javax.swing.JTextField downPaymentTextField;
    private javax.swing.JPanel earlyRepaymentsPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JTextField homeValueTextField;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField loadPayoffDateTextField;
    private javax.swing.JTextField loanAmountTextField;
    private javax.swing.JTextField loarTermTextField;
    private javax.swing.JPanel mainButtonsPanel;
    private javax.swing.JPanel mainDataPanel;
    private javax.swing.JPanel mainInputPanel;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JPanel mainOutputPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField monthlyPaymentTextField;
    private javax.swing.JButton openPaymentScheduleButton;
    private javax.swing.JTextField totalInterestPaidTextField;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/icons8-mortgage-40.png"));
        this.setIconImage(icon.getImage());
    }

    private void addListeners() {
        aboutMenuItem.addActionListener(new AboutDialogListener(this));
        exitMenuItem.addActionListener(new ExitListener(this));
        calculateButton.addActionListener(new CalculateButtonListener(this));
    }
    
    private void setDocumentFilters() {
        ((AbstractDocument) homeValueTextField.getDocument())
                .setDocumentFilter(new IntegerRangeDocumentFilter(0, 999999999));
        ((AbstractDocument) downPaymentTextField.getDocument())
                .setDocumentFilter(new IntegerRangeDocumentFilter(0, 999999999));
        ((AbstractDocument) interestRateTextField.getDocument())
                .setDocumentFilter(new IntegerRangeDocumentFilter(0, 99));
        ((AbstractDocument) loarTermTextField.getDocument())
                .setDocumentFilter(new IntegerRangeDocumentFilter(0, 50));
    }
    
    public boolean isInputValid() {
        Integer downPayment = Integer.parseInt(downPaymentTextField.getText());
        Integer homeValue = Integer.parseInt(homeValueTextField.getText());
        if (downPayment.compareTo(homeValue) >= 0) {
            JOptionPane.showMessageDialog(this, 
                    "Down Payment should be less than Home Value"
            , getTitle()
            , JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        return true;
    }

}
