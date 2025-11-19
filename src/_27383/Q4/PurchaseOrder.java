package _27383.Q4;

import java.time.LocalDate;

public class PurchaseOrder extends Product {
    private final String poNumber;
    private final LocalDate orderDate;
    private final double totalAmount;

    public PurchaseOrder(int id, String orgName, String address, String contactEmail,
                         String deptName, String deptCode,
                         String supplierName, String supplierTIN, String contact,
                         String productName, double unitPrice, int quantity,
                         String poNumber, LocalDate orderDate) throws ValidationException {
        super(id, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
                productName, unitPrice, quantity);
        if (poNumber.isEmpty()) throw new ValidationException("PO number cannot be empty");
        this.poNumber = poNumber;
        this.orderDate = orderDate;
        this.totalAmount = calculateTotalPrice();
    }

    public String getPoNumber() { return poNumber; }
    public LocalDate getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }
}
