package _27383.Q5;

import java.time.LocalDate;

public class Main {
    static void main() {
        try {
            AttendanceSummary summary = new AttendanceSummary(1, "XYZ University", "UNI01", "Kigali",
                    "Computer Science", "Dr. Smith",
                    "Java Programming", "CS101", 3,
                    "Dr. John", "john@uni.edu", "0788123456",
                    "Alice", "S12345", 20,
                    LocalDate.now(), "OOP Concepts",
                    1, "Present",
                    LocalDate.now(), "Sick", true,
                    LocalDate.now(), 18, 2);

            System.out.println("Attendance %: " + summary.generateSummary() + "%");
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

