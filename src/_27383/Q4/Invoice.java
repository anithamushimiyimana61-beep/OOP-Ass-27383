package _27383.Q4;

public class Invoice extends Inspection {
    private final String invoiceNo;
    private final double invoiceAmount;

    public Invoice(int id, String orgName, String address, String contactEmail,
                   String deptName, String deptCode,
                   String supplierName, String supplierTIN, String contact,
                   String productName, double unitPrice, int quantity,
                   String poNumber, java.time.LocalDate orderDate,
                   java.time.LocalDate deliveryDate, String deliveredBy,
                   String inspectorName, String status, String remarks,
                   String invoiceNo, double invoiceAmount) throws ValidationException {
        super(id, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
                productName, unitPrice, quantity, poNumber, orderDate, deliveryDate, deliveredBy,
                inspectorName, status, remarks);
        if (invoiceAmount <= 0) throw new ValidationException("Invoice amount must be > 0");
        this.invoiceNo = invoiceNo;
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceNo() { return invoiceNo; }
    public double getInvoiceAmount() { return invoiceAmount; }
}
