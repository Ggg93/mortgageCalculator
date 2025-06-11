package dev.gl.mortgage_calc.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author gl
 */
public class DoubleRangeDocumentFilter extends DocumentFilter {

    private Double min;
    private Double max;

    public DoubleRangeDocumentFilter(Double min, Double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void insertString(FilterBypass fb,
            int offset,
            String string,
            AttributeSet attr) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
        sb.insert(offset, string);
        if (isValid(sb.toString())) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb,
            int offset,
            int length,
            String text,
            AttributeSet attrs) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
        sb.replace(offset, offset + length, text);
        if (isValid(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
        }

    }

    @Override
    public void remove(FilterBypass fb, 
            int offset, 
            int length) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
        sb.delete(offset, offset + length);
        if (isValid(sb.toString())) {
            super.remove(fb, offset, length);
        } else if (sb.length() == 0) {
            super.remove(fb, offset, length);
        }
    }

    private boolean isValid(String text) {

        if (text.isEmpty()) {
            return true;
        }
        
        if (text.length() > 1 && text.charAt(0) == '0' && text.charAt(1) == '0') {
            return false;
        }

        try {
            Double value = Double.parseDouble(text);
            int decimalPointIdx = text.indexOf('.');
            if (decimalPointIdx >= 0) {
                int decimalPlaces = text.length() - decimalPointIdx - 1;
                if (decimalPlaces > 2) {
                    return false;
                }
            }
            return value >= min && value <= max;

        } catch (Exception ignored) {
            return false;
        }
    }
}


