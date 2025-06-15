package dev.gl.mortgage_calc.utils;

import dev.gl.mortgage_calc.models.MonthData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author gl
 */
public class ExcelFiller {

    private final File output;
    private CellStyle decimalCellStyle;
    
    public ExcelFiller(File output) {
        this.output = output;
    }
    
    public boolean createXlsxFile(List<MonthData> data) {
        try {
            InputStream template = this.getClass().getClassLoader().getResourceAsStream("excel/schedule.xlsx");
            Workbook wb = new XSSFWorkbook(template);
            
            createCellStyles(wb);
            
            Sheet schedule = wb.getSheet("schedule");
            Integer rowIdx = 1;
            
            for (MonthData monthData : data) {
                Row row = schedule.createRow(rowIdx);
                
                // fill data
                row.createCell(0).setCellValue(rowIdx);
                row.createCell(1).setCellValue(monthData.period.getYear());
                row.createCell(2).setCellValue(monthData.period.getMonth().name());
                row.createCell(3).setCellValue(monthData.paymentMainTotal.doubleValue());
                row.createCell(4).setCellValue(monthData.paymentMainDebt.doubleValue());
                row.createCell(5).setCellValue(monthData.paymentMainPercents.doubleValue());
                row.createCell(6).setCellValue(monthData.paymentEarlyRepayments.doubleValue());
                row.createCell(7).setCellValue(monthData.debtRemaining.doubleValue());
                
                // set styles
                row.getCell(3).setCellStyle(decimalCellStyle);
                row.getCell(4).setCellStyle(decimalCellStyle);
                row.getCell(5).setCellStyle(decimalCellStyle);
                row.getCell(6).setCellStyle(decimalCellStyle);
                row.getCell(7).setCellStyle(decimalCellStyle);
                
                rowIdx++;
            }
            
            FileOutputStream fos = new FileOutputStream(output);
            wb.write(fos);
            return true;
            
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    private void createCellStyles(Workbook wb) {
        decimalCellStyle = wb.createCellStyle();
        DataFormat dataFormat = wb.createDataFormat();
        decimalCellStyle.setDataFormat(dataFormat.getFormat("#,##0.00"));
    }
    
}
