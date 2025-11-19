package _27383.Q1;

import java.time.LocalDate;

public class Product extends Supplier {
    private final String productName;
    public double unitPrice; // >0
    public int stockLimit; // >=0

    public Product(int id, LocalDate createdDate, LocalDate updatedDate,
                   String warehouseName, String location, String contactNumber,
                   String categoryName, String categoryCode,
                   String supplierName, String supplierEmail, String supplierPhone,
                   String productName, double unitPrice, int stockLimit) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber,
                categoryName, categoryCode, supplierName, supplierEmail, supplierPhone);
        if (productName == null || productName.isBlank())
            throw new ValidationException("productName must not be empty");
        if (unitPrice <= 0) throw new ValidationException("unitPrice must be > 0");
        if (stockLimit < 0) throw new ValidationException("stockLimit must be >= 0");
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stockLimit = stockLimit;
    }

    public String getProductName() { return productName; }
    public double getUnitPrice() { return unitPrice; }
    public int getStockLimit() { return stockLimit; }
}
