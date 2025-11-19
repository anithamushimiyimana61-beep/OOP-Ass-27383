package _27383.Q1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

     public class Warehouse extends Entity {
        private final String warehouseName;
        private final String location;
        private final String contactNumber; // 10 digits

        public Warehouse(int id, LocalDate createdDate, LocalDate updatedDate,
                         String warehouseName, String location, String contactNumber) {
            super(id, createdDate, updatedDate);
            if (warehouseName == null || warehouseName.isBlank())
                throw new ValidationException("warehouseName must not be empty");
            if (location == null || location.isBlank())
                throw new ValidationException("location must not be empty");
            if (!isValidPhone(contactNumber))
                throw new ValidationException("contactNumber must be 10 digits");
            this.warehouseName = warehouseName;
            this.location = location;
            this.contactNumber = contactNumber;
        }

        private boolean isValidPhone(String p) {
            return p != null && p.matches("\\d{10}");
        }

        public String getWarehouseName() { return warehouseName; }
        public String getLocation() { return location; }
        public String getContactNumber() { return contactNumber; }
    }


