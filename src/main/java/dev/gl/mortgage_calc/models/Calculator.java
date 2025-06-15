package dev.gl.mortgage_calc.models;

import static dev.gl.mortgage_calc.enums.Frequency.QUARTERLY;
import static dev.gl.mortgage_calc.enums.Strategy.PAY_REDUCTION;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private Map<LocalDate, List<EarlyRepayment>> earlyRepayments;

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
        this.earlyRepayments = convertEarlyRepaymentsToMap(earlyRepayments);
        this.monthsData = new ArrayList<>();
        payOffDate = LocalDate.now().withDayOfMonth(1).plusMonths(1);
        totalInterestPaid = BigDecimal.ZERO;
        System.out.println("repayments = " + earlyRepayments.size());
    }

    public void calculateMortgage() {
        loanAmount = calculateLoanAmount();
        remainingDebt = loanAmount;

        monthInterestRate = calculateMonthInterestRate();
        monthsNumber = calculateMonthsNumber();
        monthlyPayment = calculateAnnuityPayment(loanAmount, monthsNumber);
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

    private BigDecimal calculateAnnuityPayment(BigDecimal loanAmount, Integer months) {

        // if interest rate is zero
        if (monthInterestRate.compareTo(BigDecimal.ZERO) == 0) {
            return loanAmount.divide(new BigDecimal(months), 2, RoundingMode.HALF_UP);
        }
        System.out.println("ann: loanAmount = " + loanAmount + ", months = " + months);

        BigDecimal growthFactor = BigDecimal.ONE.add(monthInterestRate).pow(months);
        BigDecimal numerator = loanAmount.multiply(monthInterestRate).multiply(growthFactor);
        BigDecimal denominator = growthFactor.subtract(BigDecimal.ONE);
        return numerator.divide(denominator, 4, RoundingMode.HALF_UP);
    }

    private void calculateMonthsData() {

        while (remainingDebt.compareTo(BigDecimal.ZERO) > 0) {
            monthsNumber--;

            // percents
            BigDecimal paymentPercents = remainingDebt.multiply(monthInterestRate).setScale(4, RoundingMode.HALF_UP);
            totalInterestPaid = totalInterestPaid.add(paymentPercents);

            // main debt
            BigDecimal paymentMainDebt = monthlyPayment.subtract(paymentPercents);
            remainingDebt = remainingDebt.subtract(paymentMainDebt);
            if (remainingDebt.compareTo(new BigDecimal(0.01d)) <= 0) {
                remainingDebt = BigDecimal.ZERO;
            }

            // early repayments
            BigDecimal monthlyPaymentBeforeAdjustments = monthlyPayment;
            BigDecimal earlyRepayments = applyEarlyRepayments(payOffDate);

            // check remainingDebt after early repayments
            if (remainingDebt.compareTo(new BigDecimal(0.01d)) <= 0) {
                remainingDebt = BigDecimal.ZERO;
            }

            MonthData monthData = new MonthData(payOffDate,
                    monthlyPaymentBeforeAdjustments,
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

    private BigDecimal applyEarlyRepayments(LocalDate currentPeriod) {
        List<EarlyRepayment> repayments = earlyRepayments.get(currentPeriod);
        if (repayments == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal repaymentsAmount = BigDecimal.ZERO;
        System.out.println("Calculation er: " + currentPeriod);
        for (EarlyRepayment repayment : repayments) {
            BigDecimal sumToPayInPeriod = BigDecimal.valueOf(Math.min(
                                    remainingDebt.doubleValue(),
                                    repayment.getAmount().doubleValue()));
            System.out.println("sumToPayInPeriod: " + sumToPayInPeriod);
            repaymentsAmount = repaymentsAmount.add(sumToPayInPeriod);
            
            switch (repayment.getStrategy()) {
                case PAY_REDUCTION:
                    remainingDebt = remainingDebt.subtract(sumToPayInPeriod);
                    monthlyPayment = calculateAnnuityPayment(remainingDebt, monthsNumber);
                    System.out.println("remainingDebt: " + remainingDebt + ", monthlyPayment: " + monthlyPayment);
                    break;
                case TERM_REDUCTION:

                    break;
            }

            if (remainingDebt.compareTo(BigDecimal.ZERO) == 0) {
                break;
            }
        }
        return repaymentsAmount;
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

    private Map<LocalDate, List<EarlyRepayment>> convertEarlyRepaymentsToMap(List<EarlyRepayment> repayments) {

        LocalDate lastMonth = LocalDate.now().withDayOfMonth(1)
                .plusMonths(loanTerm.multiply(new BigDecimal(12)).subtract(BigDecimal.ONE).longValue());

        Map<LocalDate, List<EarlyRepayment>> map = new HashMap<>();
        for (EarlyRepayment repayment : repayments) {
            LocalDate firstPayment = repayment.getFirstPaymentPeriod();
            List<EarlyRepayment> paymentsByDate = map.getOrDefault(firstPayment, new ArrayList<>());
            paymentsByDate.add(repayment);
            map.put(firstPayment, paymentsByDate);

            LocalDate period;
            switch (repayment.getFrequency()) {
                case SINGLE:
                    break;
                case MONTHLY:
                    period = firstPayment.plusMonths(1L);
                    while (!period.isAfter(lastMonth)) {
                        List<EarlyRepayment> paymentsByPeriod = map.getOrDefault(period, new ArrayList<>());
                        paymentsByPeriod.add(repayment);
                        map.put(period, paymentsByPeriod);

                        period = period.plusMonths(1L);
                    }
                    break;
                case QUARTERLY:
                    period = firstPayment.plusMonths(3L);
                    while (!period.isAfter(lastMonth)) {
                        List<EarlyRepayment> paymentsByPeriod = map.getOrDefault(period, new ArrayList<>());
                        paymentsByPeriod.add(repayment);
                        map.put(period, paymentsByPeriod);

                        period = period.plusMonths(3L);
                    }
                    break;
                case SEMI_ANNUAL:
                    period = firstPayment.plusMonths(6L);
                    while (!period.isAfter(lastMonth)) {
                        List<EarlyRepayment> paymentsByPeriod = map.getOrDefault(period, new ArrayList<>());
                        paymentsByPeriod.add(repayment);
                        map.put(period, paymentsByPeriod);

                        period = period.plusMonths(6L);
                    }
                    break;
                case ANNUAL:
                    period = firstPayment.plusYears(1L);
                    while (!period.isAfter(lastMonth)) {
                        List<EarlyRepayment> paymentsByPeriod = map.getOrDefault(period, new ArrayList<>());
                        paymentsByPeriod.add(repayment);
                        map.put(period, paymentsByPeriod);

                        period = period.plusYears(1L);
                    }
                    break;
            }
        }
        return map;
    }

}
