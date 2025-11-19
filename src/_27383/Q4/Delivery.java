package _27383.Q4;

import java.time.LocalDate;

public class Delivery extends PurchaseOrder {
    private final LocalDate deliveryDate;
    private final String deliveredBy;

    public Delivery(int id, String orgName, String address, String contactEmail,
                    String deptName, String deptCode,
                    String supplierName, String supplierTIN, String contact,
                    String productName, double unitPrice, int quantity,
                    String poNumber, LocalDate orderDate,
                    LocalDate deliveryDate, String deliveredBy) throws ValidationException {
        super(id, orgName, address, contactEmail, deptName, deptCode,
                supplierName, supplierTIN, contact, productName, unitPrice, quantity,
                poNumber, orderDate);
        if (deliveredBy.isEmpty()) throw new ValidationException("DeliveredBy cannot be empty");
        this.deliveryDate = deliveryDate;
        this.deliveredBy = deliveredBy;
    }

    public LocalDate getDeliveryDate() { return deliveryDate; }
    public String getDeliveredBy() { return deliveredBy; }
}
