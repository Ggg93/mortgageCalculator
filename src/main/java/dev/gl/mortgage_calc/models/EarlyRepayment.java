package dev.gl.mortgage_calc.models;

import dev.gl.mortgage_calc.enums.Frequency;
import dev.gl.mortgage_calc.enums.Strategy;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author gl
 */
public class EarlyRepayment {

    private BigDecimal amount;
    private Frequency frequency;
    private Strategy strategy;
    private LocalDate firstPaymentPeriod;
    
    public EarlyRepayment() {
    }
    
    public EarlyRepayment setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
    
    public EarlyRepayment setFrequency(Frequency frequency) {
        this.frequency = frequency;
        return this;
    }
    
    public EarlyRepayment setStrategy(Strategy strategy) {
        this.strategy = strategy;
        return this;
    }
    
    public EarlyRepayment setFirstPaymentPeriod(LocalDate firstPaymentPeriod) {
        this.firstPaymentPeriod = firstPaymentPeriod;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public LocalDate getFirstPaymentPeriod() {
        return firstPaymentPeriod;
    }

}
