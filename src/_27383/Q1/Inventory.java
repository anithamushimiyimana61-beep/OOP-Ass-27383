package _27383.Q1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
class Inventory extends Sale {
    private int totalItems;
    private double stockValue;
    private final List<Purchase> purchasesList = new ArrayList<>();
    private final List<Sale> salesList = new ArrayList<>();
    public List<StockItem> itemsList = new ArrayList<>();

    // We create a basic constructor chain (we won't use Inventory's inherited product fields for each item).
    public Inventory(int id, LocalDate createdDate, LocalDate updatedDate,
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
        this.totalItems = 0;
        this.stockValue = 0.0;
    }

    // Methods to manage items
    public void addStockItem(StockItem item) {
        itemsList.add(item);
        recalcTotals();
    }

    public void addPurchase(Purchase p) {
        purchasesList.add(p);
        // find matching StockItem by productName and add quantity
        for (StockItem si : itemsList) {
            if (si.getProductName().equalsIgnoreCase(p.getProductName())) {
                si.addQuantity(p.getPurchasedQuantity());
                break;
            }
        }
        recalcTotals();
    }

    public void addSale(Sale s) {
        salesList.add(s);
        // reduce matching StockItem
        for (StockItem si : itemsList) {
            if (si.getProductName().equalsIgnoreCase(s.getProductName())) {
                si.reduceQuantity(s.getSoldQuantity());
                break;
            }
        }
        recalcTotals();
    }

    private void recalcTotals() {
        totalItems = 0;
        stockValue = 0.0;
        for (StockItem si : itemsList) {
            totalItems += si.getQuantityAvailable();
            stockValue += si.getQuantityAvailable() * si.getUnitPrice();
        }
    }

    public int getTotalItems() { return totalItems; }
    public double getStockValue() { return stockValue; }
    public List<Purchase> getPurchasesList() { return purchasesList; }
    public List<Sale> getSalesList() { return salesList; }
    public List<StockItem> getItemsList() { return itemsList; }

    // Display all inserted data
    public void displayAllData() {
        System.out.println("=== WAREHOUSE ===");
        System.out.printf("Name: %s | Location: %s | Contact: %s%n",
                getWarehouseName(), getLocation(), getContactNumber());
        System.out.println("--- CATEGORIES / SUPPLIERS / PRODUCTS ---");
        for (StockItem si : itemsList) {
            System.out.println("Product: " + si.getProductName());
            System.out.printf("  Category: %s (%s)%n", getCategoryName(), getCategoryCode());
            System.out.printf("  Supplier: %s | Email: %s | Phone: %s%n", getSupplierName(), getSupplierEmail(), getSupplierPhone());
            System.out.printf("  UnitPrice: %.2f | StockLimit: %d%n", si.getUnitPrice(), si.getStockLimit());
            System.out.printf("  QtyAvailable: %d | ReorderLevel: %d%n", si.getQuantityAvailable(), si.getReorderLevel());
        }

        System.out.println("--- PURCHASES ---");
        for (Purchase p : purchasesList) {
            System.out.printf("Product: %s | Date: %s | Qty: %d | Supplier: %s%n",
                    p.getProductName(), p.getPurchaseDate(), p.getPurchasedQuantity(), p.getSupplierNamePurchase());
        }

        System.out.println("--- SALES ---");
        for (Sale s : salesList) {
            System.out.printf("Product: %s | Date: %s | Qty: %d | Customer: %s%n",
                    s.getProductName(), s.getSaleDate(), s.getSoldQuantity(), s.getCustomerName());
        }
    }
}

