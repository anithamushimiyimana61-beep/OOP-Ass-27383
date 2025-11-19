package _27383.Q6;

public class Department extends Organization {
    private final String deptName;
    private final String deptCode;
    private final String managerName;

    public Department(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                      String deptName, String deptCode, String managerName) throws ValidationException {
        super(id, orgName, orgCode, rssbNumber, contactEmail);
        if (deptCode.length() < 3) throw new ValidationException("Dept code must be ≥ 3 chars");
        this.deptName = deptName;
        this.deptCode = deptCode;
        this.managerName = managerName;
    }

    public String getDeptName() { return deptName; }
    public String getDeptCode() { return deptCode; }
    public String getManagerName() { return managerName; }
}
