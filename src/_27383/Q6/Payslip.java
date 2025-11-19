package _27383.Q6;

import java.time.LocalDate;

public final class Payslip extends Payroll {
    private final String payslipNumber;
    public LocalDate issueDate;

    public Payslip(int id, String orgName, String orgCode, String rssbNumber, String contactEmail,
                   String deptName, String deptCode, String managerName,
                   int employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                   int month, int year, java.time.LocalDate startDate, java.time.LocalDate endDate,
                   double basicPay, double transportAllowance, double housingAllowance,
                   double payeTax, double loanDeduction,
                   double overtimeHours, double overtimeRate, double bonus,
                   String payslipNumber, LocalDate issueDate) throws ValidationException {
        super(id, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
                employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate,
                basicPay, transportAllowance, housingAllowance, payeTax, loanDeduction,
                overtimeHours, overtimeRate, bonus);
        this.payslipNumber = payslipNumber;
        this.issueDate = issueDate;
    }

    public String getPayslipNumber() { return payslipNumber; }
    public LocalDate getIssueDate() { return issueDate; }

    public void generatePayslip() {
        System.out.println("==== Payslip ====");
        System.out.println("Payslip No: " + payslipNumber + " | Issue Date: " + issueDate);
        System.out.println("Employee: " + getFullName() + " | ID: " + getEmployeeID());
        System.out.println("Position: " + getPosition() + " | Department: " + getDeptName());
        System.out.println("Basic Pay: " + getBasicPay() + " | Transport: " + getTransportAllowance() + " | Housing: " + getHousingAllowance());
        System.out.println("Overtime: " + getOvertimeHours() + "h * " + getOvertimeRate() + " = " + (getOvertimeHours()*getOvertimeRate()));
        System.out.println("Bonus: " + getBonus());
        System.out.println("Gross Salary: " + getGrossSalary());
        System.out.println("RSSB: " + getRssbContribution() + " | PAYE: " + getPayeTax() + " | Loan: " + getLoanDeduction());
        System.out.println("Total Deductions: " + getTotalDeductions());
        System.out.println("Net Salary: " + getNetSalary());
        System.out.println("================");
    }
}
