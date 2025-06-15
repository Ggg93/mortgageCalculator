package dev.gl.mortgage_calc.gui;

import dev.gl.mortgage_calc.listeners.OkDisposingAction;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.Properties;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

/**
 *
 * @author gl
 */
public class AboutDialog extends javax.swing.JDialog {

    private AbstractAction okButtonAction;

    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        okButtonAction = new OkDisposingAction(this);
        initComponents();
        setupIcon();
        this.setLocationRelativeTo(null);
        attachListenerToOkButton();
        bindKeyListenersToOkButton();
        loadLogo();
        getVersion();
        setHomeLink();
        setMortgageSourceLink();
        setLibrary1SourceLink();
        setLibrary2SourceLink();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        upperSubpanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        programNameLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        linksPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        homeLinkLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mortgageLinkLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        apachePOILinkLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jFreeChartLinkLabel = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QR Generator");
        setMinimumSize(new java.awt.Dimension(520, 380));
        setResizable(false);

        mainPanel.setLayout(new java.awt.BorderLayout());

        upperSubpanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        upperSubpanel.add(logoPanel);

        infoPanel.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        programNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        programNameLabel.setText("Mortgage Calculator");
        jPanel4.add(programNameLabel);

        infoPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Version: ");
        jPanel3.add(jLabel3);

        versionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        versionLabel.setText("jLabel4");
        jPanel3.add(versionLabel);

        infoPanel.add(jPanel3, java.awt.BorderLayout.SOUTH);

        upperSubpanel.add(infoPanel);

        mainPanel.add(upperSubpanel, java.awt.BorderLayout.CENTER);

        linksPanel.setLayout(new java.awt.GridLayout(6, 1));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Home: ");
        jPanel1.add(jLabel4);

        homeLinkLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeLinkLabel.setText("jLabel5");
        homeLinkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(homeLinkLabel);

        linksPanel.add(jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mortgage image: ");
        jPanel2.add(jLabel6);

        mortgageLinkLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mortgageLinkLabel.setText("jLabel7");
        mortgageLinkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(mortgageLinkLabel);

        linksPanel.add(jPanel2);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Dependencies: ");
        jPanel6.add(jLabel8);

        linksPanel.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("1. Apache POI: ");
        jPanel7.add(jLabel5);

        apachePOILinkLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        apachePOILinkLabel.setText("jLabel5");
        apachePOILinkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel7.add(apachePOILinkLabel);

        linksPanel.add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("2. JFreeChart 1.5.3:  ");
        jPanel8.add(jLabel7);

        jFreeChartLinkLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jFreeChartLinkLabel.setText("jLabel5");
        jFreeChartLinkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel8.add(jFreeChartLinkLabel);

        linksPanel.add(jPanel8);

        mainPanel.add(linksPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apachePOILinkLabel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel homeLinkLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jFreeChartLinkLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel linksPanel;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mortgageLinkLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel programNameLabel;
    private javax.swing.JPanel upperSubpanel;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables

    private void loadLogo() {
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/icons8-mortgage-80.png"));
        JLabel logoLabel = new JLabel(icon);
        logoPanel.add(logoLabel);
    }

    private void getVersion() {
        Properties props = new Properties();
        try {
            props.load(this.getClass().getClassLoader().getResourceAsStream(".properties"));
            versionLabel.setText(props.getProperty("version", "undefined"));
        } catch (Exception e) {
        }
    }

    private void setHomeLink() {
        final String homeLink = "https://github.com/Ggg93";
        homeLinkLabel.setText("<html><a href=\"\">" + homeLink + "</a></html>");
        homeLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        homeLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(homeLink));
                } catch (Exception urlException) {
                }
            }
        });
    }

    private void setMortgageSourceLink() {
        final String imageLink = "https://icons8.com/icon/25993/mortgage";
        final String icons8Link = """
                                <html>
                                <a href="https://icons8.com/icon/25993/mortgage">Mortgage</a>
                                icon by 
                                <a href="https://icons8.com/icon/25993/mortgage">Icons8</a>
                                </html>
                                """;
        mortgageLinkLabel.setText(icons8Link);
        mortgageLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mortgageLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(imageLink));
                } catch (Exception urlException) {
                }
            }
        });
    }

    private void setLibrary1SourceLink() {
        final String imageLink = "https://github.com/apache/poi";
        final String githubLink = """
                                <html>
                                <a href="https://github.com/apache/poi">Apache POI</a>
                                , licensed under Apache License 2.0
                                </html>
                                """;
        apachePOILinkLabel.setText(githubLink);
        apachePOILinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        apachePOILinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(imageLink));
                } catch (Exception urlException) {
                }
            }
        });
    }

    private void setLibrary2SourceLink() {
        final String imageLink = "https://github.com/jfree/jfreechart";
        final String githubLink = """
                                <html>
                                <a href="https://github.com/jfree/jfreechart">JFreeChart</a>
                                , licensed under LGPL-2.1
                                </html>
                                """;
        jFreeChartLinkLabel.setText(githubLink);
        jFreeChartLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jFreeChartLinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(imageLink));
                } catch (Exception urlException) {
                }
            }
        });
    }

    private void attachListenerToOkButton() {
        okButton.addActionListener(okButtonAction);
    }

    private void bindKeyListenersToOkButton() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = this.getRootPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ok");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");

        actionMap.put("ok", okButtonAction);
    }

    private void setupIcon() {
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/icons8-mortgage-40.png"));
        this.setIconImage(icon.getImage());
    }
}
