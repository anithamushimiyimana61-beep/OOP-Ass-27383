package _27383.Q4;

public class Department extends Organization {
    private final String deptName;
    private final String deptCode;

    public Department(int id, String orgName, String address, String contactEmail,
                      String deptName, String deptCode) throws ValidationException {
        super(id, orgName, address, contactEmail);
        if (deptCode.length() < 3) throw new ValidationException("Dept code must be ≥ 3 characters");
        this.deptName = deptName;
        this.deptCode = deptCode;
    }

    public String getDeptName() { return deptName; }
    public String getDeptCode() { return deptCode; }
}
