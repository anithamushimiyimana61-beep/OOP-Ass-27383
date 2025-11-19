package _27383.Q1;
import java.time.LocalDate;
class Sale extends Purchase {
    private final LocalDate saleDate;
    private final int soldQuantity;
    private final String customerName;

    public Sale(int id, LocalDate createdDate, LocalDate updatedDate,
                String warehouseName, String location, String contactNumber,
                String categoryName, String categoryCode,
                String supplierName, String supplierEmail, String supplierPhone,
                String productName, double unitPrice, int stockLimit,
                int quantityAvailable, int reorderLevel,
                LocalDate purchaseDate, int purchasedQuantity, String supplierNamePurchase,
                LocalDate saleDate, int soldQuantity, String customerName) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber,
                categoryName, categoryCode, supplierName, supplierEmail, supplierPhone,
                productName, unitPrice, stockLimit, quantityAvailable, reorderLevel,
                purchaseDate, purchasedQuantity, supplierNamePurchase);
        if (saleDate == null) throw new ValidationException("saleDate must not be null");
        if (soldQuantity <= 0) throw new ValidationException("soldQuantity must be > 0");
        if (customerName == null || customerName.isBlank())
            throw new ValidationException("customerName must not be empty");
        this.saleDate = saleDate;
        this.soldQuantity = soldQuantity;
        this.customerName = customerName;
    }

    public LocalDate getSaleDate() { return saleDate; }
    public int getSoldQuantity() { return soldQuantity; }
    public String getCustomerName() { return customerName; }
}

