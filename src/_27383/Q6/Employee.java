package _27383.Q6;

public class Employee extends Department {
    private final int employeeID;
    private final String fullName;
    private final String position;
    private final double baseSalary;
    private final boolean rssbRegistered;

    public Employee(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                    String deptName, String deptCode, String managerName,
                    int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered) throws ValidationException {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName);
        if (employeeID < 1000) throw new ValidationException("Employee ID must be ≥ 1000");
        if (baseSalary <= 0) throw new ValidationException("Base salary must be > 0");
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.position = position;
        this.baseSalary = baseSalary;
        this.rssbRegistered = rssbRegistered;
    }

    public int getEmployeeID() { return employeeID; }
    public String getFullName() { return fullName; }
    public String getPosition() { return position; }
    public double getBaseSalary() { return baseSalary; }
    public boolean isRssbRegistered() { return rssbRegistered; }
}
