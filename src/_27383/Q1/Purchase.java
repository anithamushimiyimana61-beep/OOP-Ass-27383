package _27383.Q1;

import java.time.LocalDate;

public class Purchase extends StockItem {
    private final LocalDate purchaseDate;
    private final int purchasedQuantity;
    private final String supplierNamePurchase;

    public Purchase(int id, LocalDate createdDate, LocalDate updatedDate,
                    String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode,
                    String supplierName, String supplierEmail, String supplierPhone,
                    String productName, double unitPrice, int stockLimit,
                    int quantityAvailable, int reorderLevel,
                    LocalDate purchaseDate, int purchasedQuantity, String supplierNamePurchase) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber,
                categoryName, categoryCode, supplierName, supplierEmail, supplierPhone,
                productName, unitPrice, stockLimit, quantityAvailable, reorderLevel);
        if (purchaseDate == null) throw new ValidationException("purchaseDate must not be null");
        if (purchasedQuantity <= 0) throw new ValidationException("purchasedQuantity must be > 0");
        if (supplierNamePurchase == null || supplierNamePurchase.isBlank())
            throw new ValidationException("supplierNamePurchase must not be empty");
        this.purchaseDate = purchaseDate;
        this.purchasedQuantity = purchasedQuantity;
        this.supplierNamePurchase = supplierNamePurchase;
    }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public int getPurchasedQuantity() { return purchasedQuantity; }
    public String getSupplierNamePurchase() { return supplierNamePurchase; }
}

