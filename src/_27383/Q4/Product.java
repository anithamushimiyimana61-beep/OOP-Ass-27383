package _27383.Q4;

public class Product extends Supplier {
    private final String productName;
    private final double unitPrice;
    private final int quantity;

    public Product(int id, String orgName, String address, String contactEmail,
                   String deptName, String deptCode,
                   String supplierName, String supplierTIN, String contact,
                   String productName, double unitPrice, int quantity) throws ValidationException {
        super(id, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact);
        if (unitPrice <= 0) throw new ValidationException("Unit price must be > 0");
        if (quantity < 0) throw new ValidationException("Quantity cannot be negative");
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductName() { return productName; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }
    public double calculateTotalPrice() { return unitPrice * quantity; }
}
