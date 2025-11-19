package _27383.Q4;

public class Supplier extends Department {
    private final String supplierName;
    private final String supplierTIN;
    private final String contact;

    public Supplier(int id, String orgName, String address, String contactEmail,
                    String deptName, String deptCode,
                    String supplierName, String supplierTIN, String contact) throws ValidationException {
        super(id, orgName, address, contactEmail, deptName, deptCode);
        if (supplierTIN.length() != 9) throw new ValidationException("TIN must be 9 digits");
        if (contact.length() != 10) throw new ValidationException("Contact must be 10 digits");
        this.supplierName = supplierName;
        this.supplierTIN = supplierTIN;
        this.contact = contact;
    }

    public String getSupplierName() { return supplierName; }
    public String getSupplierTIN() { return supplierTIN; }
    public String getContact() { return contact; }
}
