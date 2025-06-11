package dev.gl.mortgage_calc.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 *
 * @author gl
 */
public class Calculator {

    // input
    private BigDecimal homeValue;
    private BigDecimal downPayment;
    private BigDecimal interestRate;
    private BigDecimal loanTerm;
    private List<EarlyRepayment> earlyRepayments;

    // output
    private BigDecimal loanAmount;
    private BigDecimal monthlyPayment;
    private BigDecimal totalInterestPaid;
    private LocalDate payOffDate;
    private List<MonthData> monthsData;

    // internal
    private BigDecimal monthInterestRate;
    private Integer monthsNumber;
    private BigDecimal remainingDebt;

    public Calculator(BigDecimal homeValue,
            BigDecimal downPayment,
            BigDecimal interestRate,
            BigDecimal loanTerm,
            List<EarlyRepayment> earlyRepayments) {

        if (Stream
                .of(homeValue, downPayment, interestRate, loanTerm, earlyRepayments)
                .anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Arguments must not be null");
        }

        this.homeValue = homeValue;
        this.downPayment = downPayment;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.earlyRepayments = earlyRepayments;
        this.monthsData = new ArrayList<>();
        payOffDate = LocalDate.now().withDayOfMonth(1).plusMonths(1);
        totalInterestPaid = BigDecimal.ZERO;
    }

    public void calculateMortgage() {
        loanAmount = calculateLoanAmount();
        remainingDebt = loanAmount;
        
        monthInterestRate = calculateMonthInterestRate();
        monthsNumber = calculateMonthsNumber();
        monthlyPayment = calculateAnnuityPayment();
        calculateMonthsData();
    }

    private BigDecimal calculateLoanAmount() {
        return homeValue.subtract(downPayment);
    }

    private BigDecimal calculateMonthInterestRate() {
        return interestRate.divide(new BigDecimal(1200), 4, RoundingMode.HALF_UP);
    }

    private Integer calculateMonthsNumber() {
        return loanTerm.multiply(new BigDecimal(12)).intValue();
    }

    private BigDecimal calculateAnnuityPayment() {
        
        // if interest rate is zero
        if (monthInterestRate.compareTo(BigDecimal.ZERO) == 0) {
            return loanAmount.divide(new BigDecimal(monthsNumber), 2, RoundingMode.HALF_UP);
        }
        
        BigDecimal growthFactor = BigDecimal.ONE.add(monthInterestRate).pow(monthsNumber);
        BigDecimal numerator = loanAmount.multiply(monthInterestRate).multiply(growthFactor);
        BigDecimal denominator = growthFactor.subtract(BigDecimal.ONE);
        return numerator.divide(denominator, 4, RoundingMode.HALF_UP);
    }

    private void calculateMonthsData() {
        
        while (remainingDebt.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal paymentPercents = remainingDebt.multiply(monthInterestRate).setScale(4, RoundingMode.HALF_UP);
            BigDecimal paymentMainDebt = monthlyPayment.subtract(paymentPercents);
            BigDecimal earlyRepayments = applyEarlyRepayments();
            remainingDebt = remainingDebt.subtract(paymentMainDebt);
            if (remainingDebt.compareTo(new BigDecimal(0.01d)) <= 0) {
                remainingDebt = BigDecimal.ZERO;
            }
            totalInterestPaid = totalInterestPaid.add(paymentPercents);
            System.out.println("payOffDate = " + payOffDate);
            System.out.println("paymentPercents = " + paymentPercents);
            System.out.println("paymentMainDebt = " + paymentMainDebt);
            System.out.println("earlyRepayments = " + earlyRepayments);
            System.out.println("remainingDebt = " + remainingDebt);
            System.out.println("totalInterestPaid = " + totalInterestPaid);
            
            MonthData monthData = new MonthData(payOffDate, 
                    monthlyPayment, 
                    paymentPercents, 
                    paymentMainDebt, 
                    earlyRepayments, 
                    remainingDebt);
            monthsData.add(monthData);
            
            if (remainingDebt.compareTo(BigDecimal.ZERO) > 0) {
                payOffDate = payOffDate.plusMonths(1L);
            }
        }
    }

    private BigDecimal applyEarlyRepayments() {
        return BigDecimal.ZERO; // stub
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public BigDecimal getTotalInterestPaid() {
        return totalInterestPaid;
    }

    public LocalDate getPayOffDate() {
        return payOffDate;
    }

    public List<MonthData> getMonthsData() {
        return monthsData;
    }
    
}



