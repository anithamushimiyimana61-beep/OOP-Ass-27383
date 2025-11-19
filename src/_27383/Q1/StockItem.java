package _27383.Q1;
import java.time.LocalDate;

public class StockItem extends Product {
    private int quantityAvailable; // >=0
    private final int reorderLevel; // >=0

    public StockItem(int id, LocalDate createdDate, LocalDate updatedDate,
                     String warehouseName, String location, String contactNumber,
                     String categoryName, String categoryCode,
                     String supplierName, String supplierEmail, String supplierPhone,
                     String productName, double unitPrice, int stockLimit,
                     int quantityAvailable, int reorderLevel) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber,
                categoryName, categoryCode, supplierName, supplierEmail, supplierPhone,
                productName, unitPrice, stockLimit);
        if (quantityAvailable < 0) throw new ValidationException("quantityAvailable must be >= 0");
        if (reorderLevel < 0) throw new ValidationException("reorderLevel must be >= 0");
        this.quantityAvailable = quantityAvailable;
        this.reorderLevel = reorderLevel;
    }

    public int getQuantityAvailable() { return quantityAvailable; }
    public int getReorderLevel() { return reorderLevel; }

    public void addQuantity(int q) {
        if (q < 0) throw new ValidationException("added quantity must be >= 0");
        this.quantityAvailable += q;
    }

    public void reduceQuantity(int q) {
        if (q < 0) throw new ValidationException("sold quantity must be >= 0");
        if (q > this.quantityAvailable) throw new ValidationException("insufficient stock");
        this.quantityAvailable -= q;
    }
}
