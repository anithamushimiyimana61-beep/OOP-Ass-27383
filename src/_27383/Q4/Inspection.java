package _27383.Q4;

public class Inspection extends Delivery {
    private final String inspectorName;
    private final String status;
    private final String remarks;

    public Inspection(int id, String orgName, String address, String contactEmail,
                      String deptName, String deptCode,
                      String supplierName, String supplierTIN, String contact,
                      String productName, double unitPrice, int quantity,
                      String poNumber, java.time.LocalDate orderDate,
                      java.time.LocalDate deliveryDate, String deliveredBy,
                      String inspectorName, String status, String remarks) throws ValidationException {
        super(id, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
                productName, unitPrice, quantity, poNumber, orderDate, deliveryDate, deliveredBy);
        if (!status.equals("Passed") && !status.equals("Failed")) throw new ValidationException("Status must be Passed/Failed");
        this.inspectorName = inspectorName;
        this.status = status;
        this.remarks = remarks;
    }

    public String getInspectorName() { return inspectorName; }
    public String getStatus() { return status; }
    public String getRemarks() { return remarks; }
}
