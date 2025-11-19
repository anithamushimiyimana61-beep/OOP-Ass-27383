package _27383.Q1;
import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Stock Management System (Professional) ===");

        // Gather warehouse, category, supplier base details (used as defaults for chain)
        System.out.println("\nEnter warehouse details:");
        String whName = promptNonEmpty("Warehouse Name");
        String whLocation = promptNonEmpty("Warehouse Location");
        String whContact = promptPhone("Warehouse Contact Number (10 digits)");

        System.out.println("\nEnter category details:");
        String catName = promptNonEmpty("Category Name");
        String catCode = promptAlnumMinLen("Category Code (alphanumeric, >=3)", 3);

        System.out.println("\nEnter supplier details:");
        String supName = promptNonEmpty("Supplier Name");
        String supEmail = promptEmail("Supplier Email");
        String supPhone = promptPhone("Supplier Phone (10 digits)");

        // Create a base StockReport object to hold inventory (we pass dummy product fields; inventory keeps its own items)
        StockReport report = new StockReport(
                1, LocalDate.now(), LocalDate.now(),
                whName, whLocation, whContact,
                catName, catCode,
                supName, supEmail, supPhone,
                "DUMMY", 1.0, 0,
                0, 0,
                LocalDate.now(), 1, supName,
                LocalDate.now(), 1, "customer"
        );

        // Add products (stock items)
        int productCount = promptIntInRange("How many products will you add?", 1, 100);
        for (int i = 1; i <= productCount; i++) {
            System.out.println("\n--- Product " + i + " ---");
            String pName = promptNonEmpty("Product Name");
            double unitPrice = promptDoubleGreater("Unit Price (> 0)", 0.0);
            int stockLimit = promptIntMin("Stock Limit (>=0)", 0);
            int qtyAvailable = promptIntMin("Initial Quantity Available (>=0)", 0);
            int reorderLevel = promptIntMin("Reorder Level (>=0)", 0);

            // Create StockItem (we reuse warehouse/category/supplier info entered above)
            StockItem si = new StockItem(
                    i + 1,
                    LocalDate.now(),
                    LocalDate.now(),
                    whName, whLocation, whContact,
                    catName, catCode,
                    supName, supEmail, supPhone,
                    pName, unitPrice, stockLimit,
                    qtyAvailable, reorderLevel
            );
            report.addStockItem(si);
            System.out.printf("Added product '%s' with %d units.%n", pName, qtyAvailable);
        }

        // Purchases
        int purchaseCount = promptIntInRange("\nHow many purchase transactions to record?", 0, 500);
        for (int i = 1; i <= purchaseCount; i++) {
            System.out.println("\n--- Purchase " + i + " ---");
            String pName = promptExistingProductName(report, "Product name for purchase");
            LocalDate pDate = promptDate("Purchase Date (YYYY-MM-DD)");
            int qty = promptIntMin("Purchased Quantity (>0)", 1);
            String supplierForPurchase = promptNonEmpty("Supplier Name for this purchase");

            // Build Purchase object. We must provide many inherited fields; we'll fill required ones with defaults where not applicable.
            Purchase p = new Purchase(
                    100 + i,
                    LocalDate.now(), LocalDate.now(),
                    whName, whLocation, whContact,
                    catName, catCode,
                    supplierForPurchase, supEmail, supPhone,
                    pName, findUnitPrice(report, pName), 0,
                    0, 0,
                    pDate, qty, supplierForPurchase
            );

            report.addPurchase(p);
            System.out.printf("Recorded purchase of %d units of '%s'.%n", qty, pName);
        }

        // Sales
        int saleCount = promptIntInRange("\nHow many sale transactions to record?", 0, 500);
        for (int i = 1; i <= saleCount; i++) {
            System.out.println("\n--- Sale " + i + " ---");
            String pName = promptExistingProductName(report, "Product name for sale");
            LocalDate sDate = promptDate("Sale Date (YYYY-MM-DD)");
            int qty = promptIntMin("Sold Quantity (>0)", 1);
            String customer = promptNonEmpty("Customer Name");

            // Ensure stock available
            StockItem si = findStockItem(report, pName);
            if (si == null) {
                System.out.println("Error: product not found in inventory. Skipping sale.");
                continue;
            }
            if (qty > si.getQuantityAvailable()) {
                System.out.printf("Not enough stock for '%s' (available %d). Sale aborted.%n", pName, si.getQuantityAvailable());
                continue;
            }

            Sale s = new Sale(
                    200 + i,
                    LocalDate.now(), LocalDate.now(),
                    whName, whLocation, whContact,
                    catName, catCode,
                    supName, supEmail, supPhone,
                    pName, si.getUnitPrice(), si.getStockLimit(),
                    si.getQuantityAvailable(), si.getReorderLevel(),
                    LocalDate.now(), 0, supName,
                    sDate, qty, customer
            );

            report.addSale(s);
            System.out.printf("Recorded sale of %d units of '%s'.%n", qty, pName);
        }

        // Display all inserted data and generate report
        System.out.println("\n\n******** Inventory Snapshot ********");
        report.displayAllData();
        report.generateReport();

        System.out.println("Program finished. Thank you.");
    }

    /* ----------------- Helper input & utility methods ----------------- */

    private static String promptNonEmpty(String prompt) {
        String s;
        while (true) {
            System.out.print(prompt + ": ");
            s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input must not be empty.");
        }
    }

    private static String promptPhone(String prompt) {
        String s;
        while (true) {
            System.out.print(prompt + ": ");
            s = sc.nextLine().trim();
            if (s.matches("\\d{10}")) return s;
            System.out.println("Phone must be exactly 10 digits (numbers only).");
        }
    }

    private static String promptEmail(String prompt) {
        String s;
        while (true) {
            System.out.print(prompt + ": ");
            s = sc.nextLine().trim();
            if (s.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) return s;
            System.out.println("Invalid email format. Try again.");
        }
    }

    private static String promptAlnumMinLen(String prompt, int minLen) {
        String s;
        while (true) {
            System.out.print(prompt + ": ");
            s = sc.nextLine().trim();
            if (s.length() >= minLen && s.matches("[A-Za-z0-9]+")) return s;
            System.out.printf("Must be alphanumeric and at least %d characters.%n", minLen);
        }
    }

    private static int promptIntInRange(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt + " ");
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v < min || v > max) {
                    System.out.printf("Enter a number between %d and %d.%n", min, max);
                    continue;
                }
                return v;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    private static int promptIntMin(String prompt, int min) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v < min) {
                    System.out.printf("Value must be >= %d.%n", min);
                    continue;
                }
                return v;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    private static double promptDoubleGreater(String prompt, double minExclusive) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                double v = Double.parseDouble(sc.nextLine().trim());
                if (!(v > minExclusive)) {
                    System.out.printf("Value must be greater than %.2f.%n", minExclusive);
                    continue;
                }
                return v;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static LocalDate promptDate(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String s = sc.nextLine().trim();
                return LocalDate.parse(s);
            } catch (Exception ex) {
                System.out.println("Invalid date format. Use YYYY-MM-DD. Try again.");
            }
        }
    }

    private static String promptExistingProductName(Inventory inv, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String name = sc.nextLine().trim();
            for (StockItem si : inv.getItemsList()) {
                if (si.getProductName().equalsIgnoreCase(name)) return si.getProductName();
            }
            System.out.println("Product not found in inventory. Available products:");
            for (StockItem si : inv.getItemsList()) System.out.println(" - " + si.getProductName());
        }
    }

    private static double findUnitPrice(Inventory inv, String productName) {
        for (StockItem si : inv.getItemsList()) {
            if (si.getProductName().equalsIgnoreCase(productName)) return si.getUnitPrice();
        }
        return 0.0;
    }

    private static StockItem findStockItem(Inventory inv, String productName) {
        for (StockItem si : inv.getItemsList()) {
            if (si.getProductName().equalsIgnoreCase(productName)) return si;
        }
        return null;
    }
}


