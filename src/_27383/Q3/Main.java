package _27383.Q3;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee Name: ");
            String empName = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // consume newline

            Employee employee = new Employee(1, "Rwanda Revenue Authority", "Kigali", "info@rra.gov.rw",
                    "Income Tax", 0.3, "ITX",
                    "123456789", "John Doe", "Kigali",
                    "Tech Ltd", "987654321", "0788123456",
                    empName, salary, "123456789");

            double tax = employee.computeTax(0.3, 500); // example credits
            System.out.println("Payable Tax: " + tax);

        } catch (TaxDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
