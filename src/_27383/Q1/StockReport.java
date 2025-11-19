package _27383.Q1;
import java.time.LocalDate;
final class StockReport extends Inventory {

    public StockReport(int id, LocalDate createdDate, LocalDate updatedDate,
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
                purchaseDate, purchasedQuantity, supplierNamePurchase,
                saleDate, soldQuantity, customerName);
    }

    public void generateReport() {
        System.out.println("\n====== STOCK REPORT ======");
        System.out.printf("Report Date: %s%n", LocalDate.now());
        System.out.printf("Total distinct products: %d%n", getItemsList().size());
        System.out.printf("Total items in stock: %d%n", getTotalItems());
        System.out.printf("Total stock value: %.2f%n", getStockValue());
        int totalSold = 0;
        double totalSalesValue = 0.0;
        for (Sale s : getSalesList()) {
            totalSold += s.getSoldQuantity();
            totalSalesValue += s.getSoldQuantity() * s.getUnitPrice();
        }
        System.out.printf("Total items sold: %d%n", totalSold);
        System.out.printf("Total sales value: %.2f%n", totalSalesValue);
        System.out.println("==========================\n");
    }
}
