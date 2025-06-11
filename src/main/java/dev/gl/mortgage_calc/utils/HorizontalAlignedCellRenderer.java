package dev.gl.mortgage_calc.utils;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author gl
 */
public class HorizontalAlignedCellRenderer extends DefaultTableCellRenderer {

    public HorizontalAlignedCellRenderer(int horizontalAlignmentRule) {
        setHorizontalAlignment(horizontalAlignmentRule);
    }

    @Override
    protected void setValue(Object value) {
        super.setValue(value);
    }

}
