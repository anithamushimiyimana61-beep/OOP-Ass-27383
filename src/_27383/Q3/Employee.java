package _27383.Q3;

public class Employee extends Employer {
    private final String employeeName;
    private final double salary;
    private final String employeeTIN;

    public Employee(int id, String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address,
                    String employerName, String employerTIN, String contact,
                    String employeeName, double salary, String employeeTIN) throws TaxDataException {
        super(id, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact);
        if (salary <= 0) throw new TaxDataException("Salary must be > 0");
        this.employeeName = employeeName;
        this.salary = salary;
        this.employeeTIN = employeeTIN;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmployeeTIN() {
        return employeeTIN;
    }

    public double computeTax(double rate, double credits) {
        return (salary * rate) - credits;
    }
}
