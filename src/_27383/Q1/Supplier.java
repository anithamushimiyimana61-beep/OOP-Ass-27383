package _27383.Q1;
import java.time.LocalDate;
public class Supplier extends Category {
    private final String supplierName;
    private final String supplierEmail;
    private final String supplierPhone; // 10 digits

    public Supplier(int id, LocalDate createdDate, LocalDate updatedDate,
                    String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode,
                    String supplierName, String supplierEmail, String supplierPhone) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, categoryName, categoryCode);
        if (supplierName == null || supplierName.isBlank())
            throw new ValidationException("supplierName must not be empty");
        if (!isValidEmail(supplierEmail))
            throw new ValidationException("supplierEmail is invalid");
        if (!isValidPhone(supplierPhone))
            throw new ValidationException("supplierPhone must be 10 digits");
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }

    private boolean isValidEmail(String e) {
        return e != null && e.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    private boolean isValidPhone(String p) { return p != null && p.matches("\\d{10}"); }

    public String getSupplierName() { return supplierName; }
    public String getSupplierEmail() { return supplierEmail; }
    public String getSupplierPhone() { return supplierPhone; }
}
