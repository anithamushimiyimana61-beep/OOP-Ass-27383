package _27383.Q3;

import java.time.LocalDate;

public class Payment extends TaxAssessment {
    private final LocalDate paymentDate;
    public double paymentAmount;

    public Payment(int id, String authorityName, String region, String email,
                   String categoryName, double rate, String code,
                   String tin, String taxpayerName, String address,
                   String employerName, String employerTIN, String contact,
                   String employeeName, double salary, String employeeTIN,
                   String declarationMonth, double totalIncome,
                   LocalDate assessmentDate, double assessedTax,
                   LocalDate paymentDate, double paymentAmount) throws TaxDataException {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact,
                employeeName, salary, employeeTIN, declarationMonth, totalIncome,
                assessmentDate, assessedTax);
        if (paymentAmount <= 0) throw new TaxDataException("Payment must be > 0");
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
}
