package _27383.Q6;

public class Deduction extends SalaryStructure {
    private final double rssbContribution;
    private final double payeTax;
    private final double loanDeduction;

    public Deduction(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                     String deptName, String deptCode, String managerName,
                     int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                     int month, int year, java.time.LocalDate startDate, java.time.LocalDate endDate,
                     double basicPay, double transportAllowance, double housingAllowance,
                     double payeTax, double loanDeduction) throws ValidationException {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
                employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance);
        this.rssbContribution = getBasicPay() * 0.05;
        this.payeTax = payeTax;
        this.loanDeduction = loanDeduction;
        if (payeTax < 0 || loanDeduction < 0) throw new ValidationException("Deductions ≥ 0");
    }

    public double getRssbContribution() { return rssbContribution; }
    public double getPayeTax() { return payeTax; }
    public double getLoanDeduction() { return loanDeduction; }
}
