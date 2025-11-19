package _27383.Q5;

public class Department extends Institution {
    private final String departmentName;
    private final String departmentHead;

    public Department(int id, String institutionName, String code, String address,
                      String departmentName, String departmentHead) throws ValidationException {
        super(id, institutionName, code, address);
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
    }

    public String getDepartmentName() { return departmentName; }
    public String getDepartmentHead() { return departmentHead; }
}
