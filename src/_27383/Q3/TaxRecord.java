package _27383.Q3;

public final class TaxRecord extends Payment {
    private final String receiptNo;
    private final double totalTax;

    public TaxRecord(int id, String authorityName, String region, String email,
                     String categoryName, double rate, String code,
                     String tin, String taxpayerName, String address,
                     String employerName, String employerTIN, String contact,
                     String employeeName, double salary, String employeeTIN,
                     String declarationMonth, double totalIncome,
                     java.time.LocalDate assessmentDate, double assessedTax,
                     java.time.LocalDate paymentDate, double paymentAmount,
                     String receiptNo, double totalTax) throws TaxDataException {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact,
                employeeName, salary, employeeTIN, declarationMonth, totalIncome,
                assessmentDate, assessedTax, paymentDate, paymentAmount);
        this.receiptNo = receiptNo;
        this.totalTax = totalTax;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public double getTotalTax() {
        return totalTax;
    }
}
