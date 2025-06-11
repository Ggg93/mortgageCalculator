package dev.gl.mortgage_calc.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author gl
 */
public class BigDecimalCellRenderer extends DefaultTableCellRenderer {
    private final DecimalFormat decimalFormat;

    public BigDecimalCellRenderer() {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        dfs.setGroupingSeparator(' ');
        decimalFormat = new DecimalFormat("#,##0.00", dfs);
        decimalFormat.setGroupingUsed(true);
    }

    @Override
    protected void setValue(Object value) {
        if (value instanceof BigDecimal) {
            super.setValue(decimalFormat.format(value));
        } else {
            super.setValue(value);
        }
    }

    @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(SwingConstants.RIGHT); 
    }
    
}
