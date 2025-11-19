package _27383.Q4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        List<Invoice> invoices = new ArrayList<>();

        try {
            System.out.print("Enter Product Name: ");
            String productName = sc.nextLine();
            System.out.print("Enter Unit Price: ");
            double unitPrice = sc.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // consume newline

            Invoice invoice = new Invoice(1, "Procurement Org", "Kigali", "contact@procure.org",
                    "Procurement Dept", "PD01",
                    "Supplier Ltd", "123456789", "0788123456",
                    productName, unitPrice, quantity,
                    "PO001", LocalDate.now(),
                    LocalDate.now(), "Driver X",
                    "Inspector A", "Passed", "No issues",
                    "INV001", unitPrice*quantity);

            invoices.add(invoice);

            double totalPurchase = ProcurementReport.calculateTotal(invoices);
            System.out.println("Total Purchase Amount: " + totalPurchase);

        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
