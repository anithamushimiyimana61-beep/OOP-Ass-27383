package _27383.Q1;
import java.time.LocalDate;
class Category extends Warehouse {
    private final String categoryName;
    private final String categoryCode; // alphanumeric, >=3 chars

    public Category(int id, LocalDate createdDate, LocalDate updatedDate,
                    String warehouseName, String location, String contactNumber,
                    String categoryName, String categoryCode) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber);
        if (categoryName == null || categoryName.isBlank())
            throw new ValidationException("categoryName must not be empty");
        if (categoryCode == null || categoryCode.length() < 3 || !categoryCode.matches("[A-Za-z0-9]+"))
            throw new ValidationException("categoryCode must be alphanumeric and at least 3 characters");
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() { return categoryName; }
    public String getCategoryCode() { return categoryCode; }
}

