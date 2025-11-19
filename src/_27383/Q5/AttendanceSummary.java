package _27383.Q5;

import java.time.LocalDate;
import java.util.List;

public final class AttendanceSummary extends LeaveRequest {
    private final LocalDate reportDate;
    private final int totalPresent;
    private final int totalAbsent;

    public AttendanceSummary(int id, String institutionName, String code, String address,
                             String departmentName, String departmentHead,
                             String courseName, String courseCode, int credits,
                             String instructorName, String email, String phone,
                             String studentName, String studentID, int age,
                             java.time.LocalDate sessionDate, String topic,
                             int sessionID, String status,
                             LocalDate requestDate, String reason, boolean approved,
                             LocalDate reportDate, int totalPresent, int totalAbsent) throws ValidationException {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age, sessionDate, topic, sessionID, status,
                requestDate, reason, approved);
        this.reportDate = reportDate;
        this.totalPresent = totalPresent;
        this.totalAbsent = totalAbsent;
    }

    public LocalDate getReportDate() { return reportDate; }
    public int getTotalPresent() { return totalPresent; }
    public int getTotalAbsent() { return totalAbsent; }

    public double generateSummary() {
        int totalSessions = totalPresent + totalAbsent;
        return totalSessions == 0 ? 0 : ((double) totalPresent / totalSessions) * 100;
    }
}
