package _27383.Q6;

public class Allowance extends Deduction {
    private final double overtimeHours;
    private final double overtimeRate;
    private final double bonus;

    public Allowance(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                     String deptName, String deptCode, String managerName,
                     int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                     int month, int year, java.time.LocalDate startDate, java.time.LocalDate endDate,
                     double basicPay, double transportAllowance, double housingAllowance,
                     double payeTax, double loanDeduction,
                     double overtimeHours, double overtimeRate, double bonus) throws ValidationException {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
                employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance, payeTax, loanDeduction);
        if (overtimeHours < 0 || overtimeRate < 0 || bonus < 0) throw new ValidationException("Allowances ≥ 0");
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
        this.bonus = bonus;
    }

    public double getOvertimeHours() { return overtimeHours; }
    public double getOvertimeRate() { return overtimeRate; }
    public double getBonus() { return bonus; }
}
