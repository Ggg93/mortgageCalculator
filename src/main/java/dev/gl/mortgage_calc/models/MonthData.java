package dev.gl.mortgage_calc.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;

/**
 *
 * @author gl
 */
public class MonthData {
    public LocalDate period;
    public BigDecimal paymentMainTotal;
    public BigDecimal paymentMainPercents;
    public BigDecimal paymentMainDebt;
    public BigDecimal paymentEarlyRepayments;
    public BigDecimal debtRemaining;

    public MonthData(LocalDate period, 
            BigDecimal paymentTotal, 
            BigDecimal paymentPercents, 
            BigDecimal paymentMainDebt, 
            BigDecimal paymentEarlyRepayments,
            BigDecimal debtRemaining) {
        
        if (Stream
                .of(period, paymentTotal, paymentPercents, paymentMainDebt, paymentEarlyRepayments, debtRemaining)
                .anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        
        this.period = period;
        this.paymentMainTotal = paymentTotal;
        this.paymentMainPercents = paymentPercents;
        this.paymentMainDebt = paymentMainDebt;
        this.paymentEarlyRepayments = paymentEarlyRepayments;
        this.debtRemaining = debtRemaining;
    }
    
    
}
