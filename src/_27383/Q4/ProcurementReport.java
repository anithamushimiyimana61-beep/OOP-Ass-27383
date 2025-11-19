package _27383.Q4;

import java.time.LocalDate;
import java.util.List;

public final class ProcurementReport extends Invoice {
    private final LocalDate reportDate;
    private final String summary;

    public ProcurementReport(int id, String orgName, String address, String contactEmail,
                             String deptName, String deptCode,
                             String supplierName, String supplierTIN, String contact,
                             String productName, double unitPrice, int quantity,
                             String poNumber, java.time.LocalDate orderDate,
                             java.time.LocalDate deliveryDate, String deliveredBy,
                             String inspectorName, String status, String remarks,
                             String invoiceNo, double invoiceAmount,
                             LocalDate reportDate, String summary) throws ValidationException {
        super(id, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
                productName, unitPrice, quantity, poNumber, orderDate, deliveryDate, deliveredBy,
                inspectorName, status, remarks, invoiceNo, invoiceAmount);
        this.reportDate = reportDate;
        this.summary = summary;
    }

    public LocalDate getReportDate() { return reportDate; }
    public String getSummary() { return summary; }

    public static double calculateTotal(List<Invoice> invoices) {
        double total = 0;
        for (Invoice inv : invoices) {
            total += inv.getInvoiceAmount();
        }
        return total;
    }
}
