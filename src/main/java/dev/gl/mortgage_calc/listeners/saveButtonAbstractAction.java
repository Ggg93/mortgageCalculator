package dev.gl.mortgage_calc.listeners;

import dev.gl.mortgage_calc.gui.PaymentScheduleDialog;
import dev.gl.mortgage_calc.utils.ExcelFiller;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author gl
 */
public class saveButtonAbstractAction extends AbstractAction {

    private static final Font FILE_CHOOSER_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private PaymentScheduleDialog parent;

    public saveButtonAbstractAction(PaymentScheduleDialog parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        updateFont(fileChooser, FILE_CHOOSER_FONT);
        fileChooser.setDialogTitle(parent.getTitle());
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Book (*.xlsx)", "xlsx"));

        int result = fileChooser.showSaveDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // add xlsx extension if it is missing
            if (!selectedFile.getName().endsWith(".xlsx")) {
                selectedFile = new File(selectedFile.getAbsoluteFile() + ".xlsx");
            }

            ExcelFiller excelFiller = new ExcelFiller(selectedFile);
            boolean isSuccess = excelFiller.createXlsxFile(parent.getData());
            if (isSuccess) {
                JOptionPane.showMessageDialog(parent, "Excel book saved successfully");
            } else {
                JOptionPane.showMessageDialog(parent,
                        "Error occured: could not save the file.",
                        parent.getTitle(),
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void updateFont(Component comp, Font font) {
        comp.setFont(font);
        if (comp instanceof Container) {
            for (Component child : ((Container) comp).getComponents()) {
                updateFont(child, font);
            }
        }
    }

}
