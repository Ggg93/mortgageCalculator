package dev.gl.mortgage_calc.gui;

import dev.gl.mortgage_calc.listeners.OkDisposingAction;
import dev.gl.mortgage_calc.listeners.saveButtonAbstractAction;
import dev.gl.mortgage_calc.models.MonthData;
import dev.gl.mortgage_calc.models.UneditableTableModel;
import dev.gl.mortgage_calc.utils.BigDecimalCellRenderer;
import dev.gl.mortgage_calc.utils.HorizontalAlignedCellRenderer;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author gl
 */
public class PaymentScheduleDialog extends javax.swing.JDialog {

    private AbstractAction okButtonAction;
    private AbstractAction saveButtonAction;
    private List<MonthData> monthsData;

    public PaymentScheduleDialog(java.awt.Frame parent, boolean modal, List<MonthData> monthsData) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.monthsData = monthsData;

        okButtonAction = new OkDisposingAction(this);
        saveButtonAction = new saveButtonAbstractAction(this);
        setIcon();
        attachListenerToOkButton();
        bindKeyListenersToOkButton();
        changeFontInTable();
        loadDataIntoTheTable();
        applyDefaultCellRenderer();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        paymentsScrollPane = new javax.swing.JScrollPane();
        paymentsTable = new javax.swing.JTable();
        buttonsPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mortgage Calculator");
        setMinimumSize(new java.awt.Dimension(900, 400));
        setPreferredSize(new java.awt.Dimension(900, 400));

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payments Schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        paymentsScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        paymentsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        paymentsScrollPane.setViewportView(paymentsTable);

        mainPanel.add(paymentsScrollPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        okButton.setText("OK");
        buttonsPanel.add(okButton);

        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saveButton.setText("Save");
        buttonsPanel.add(saveButton);

        getContentPane().add(buttonsPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JScrollPane paymentsScrollPane;
    private javax.swing.JTable paymentsTable;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/icons8-mortgage-40.png"));
        this.setIconImage(icon.getImage());
    }

    private void attachListenerToOkButton() {
        okButton.addActionListener(okButtonAction);
        saveButton.addActionListener(saveButtonAction);
    }

    private void bindKeyListenersToOkButton() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = this.getRootPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ok");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "save");

        actionMap.put("ok", okButtonAction);
        actionMap.put("save", saveButtonAction);
    }

    private void changeFontInTable() {
        JTableHeader tableHeader = paymentsTable.getTableHeader();
        tableHeader.setFont(new Font("Segou UI", Font.PLAIN, 14));
        tableHeader.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public void setHorizontalAlignment(int alignment) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
            }

            @Override
            public void setBorder(Border border) {
                super.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            }
        });
    }

    private void loadDataIntoTheTable() {
        String[] columnNames = {
            "N",
            "Year",
            "Month",
            "Payment",
            "Incl.: debt",
            "Incl.: percents",
            "Early Repayments",
            "Debt remaining"
        };
        Object[][] stats = loadStats(columnNames);

        UneditableTableModel model = new UneditableTableModel(stats, columnNames);
        paymentsTable.setModel(model);
    }

    private Object[][] loadStats(String[] columnNames) {
        Object[][] data = new Object[monthsData.size()][columnNames.length];

        for (int i = 0; i < monthsData.size(); i++) {

            MonthData monthData = monthsData.get(i);

            int columnIdx = 0;
            data[i][columnIdx++] = i + 1;
            data[i][columnIdx++] = monthData.period.getYear();
            data[i][columnIdx++] = monthData.period.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
            data[i][columnIdx++] = monthData.paymentMainTotal;
            data[i][columnIdx++] = monthData.paymentMainDebt;
            data[i][columnIdx++] = monthData.paymentMainPercents;
            data[i][columnIdx++] = monthData.paymentEarlyRepayments;
            data[i][columnIdx++] = monthData.debtRemaining;
        }

        return data;
    }

    private void applyDefaultCellRenderer() {
        BigDecimalCellRenderer bigDecimalCellRenderer = new BigDecimalCellRenderer();
        HorizontalAlignedCellRenderer rightAlignedCellRenderer = new HorizontalAlignedCellRenderer(SwingConstants.RIGHT);
        HorizontalAlignedCellRenderer centerAlignedCellRenderer = new HorizontalAlignedCellRenderer(SwingConstants.CENTER);
        
        paymentsTable.getColumnModel().getColumn(0).setCellRenderer(rightAlignedCellRenderer);
        paymentsTable.getColumnModel().getColumn(1).setCellRenderer(centerAlignedCellRenderer);
        paymentsTable.getColumnModel().getColumn(2).setCellRenderer(centerAlignedCellRenderer);
        paymentsTable.getColumnModel().getColumn(3).setCellRenderer(bigDecimalCellRenderer);
        paymentsTable.getColumnModel().getColumn(4).setCellRenderer(bigDecimalCellRenderer);
        paymentsTable.getColumnModel().getColumn(5).setCellRenderer(bigDecimalCellRenderer);
        paymentsTable.getColumnModel().getColumn(6).setCellRenderer(bigDecimalCellRenderer);
        paymentsTable.getColumnModel().getColumn(7).setCellRenderer(bigDecimalCellRenderer);
    }

    public List<MonthData> getData() {
        return monthsData;
    }

}
