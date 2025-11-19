package _27383.Q6;

import java.time.LocalDate;

public class Main {
    static void main() {
        try {
            Payslip payslip = new Payslip(1, "ABC Corp", "ORG01", "12345678", "contact@abc.com",
                    "Finance", "FIN01", "Mr. Manager",
                    1001, "John Doe", "Accountant", 1200, true,
                    11, 2025, LocalDate.of(2025,11,1), LocalDate.of(2025,11,30),
                    1200, 100, 200, 50, 20,
                    10, 15, 100,
                    "PS001", LocalDate.now());
            payslip.generatePayslip();
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
