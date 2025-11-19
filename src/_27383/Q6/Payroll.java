package _27383.Q6;

public class Payroll extends Allowance {
    private final double grossSalary;
    private final double totalDeductions;
    private final double netSalary;

    public Payroll(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                   String deptName, String deptCode, String managerName,
                   int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                   int month, int year, java.time.LocalDate startDate, java.time.LocalDate endDate,
                   double basicPay, double transportAllowance, double housingAllowance,
                   double payeTax, double loanDeduction,
                   double overtimeHours, double overtimeRate, double bonus) throws ValidationException {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
                employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance, payeTax, loanDeduction,
                overtimeHours, overtimeRate, bonus);
        this.grossSalary = getBasicPay() + getTransportAllowance() + getHousingAllowance() + (overtimeHours * overtimeRate) + bonus;
        this.totalDeductions = getRssbContribution() + getPayeTax() + getLoanDeduction();
        this.netSalary = grossSalary - totalDeductions;
    }

    public double getGrossSalary() { return grossSalary; }
    public double getTotalDeductions() { return totalDeductions; }
    public double getNetSalary() { return netSalary; }
}
