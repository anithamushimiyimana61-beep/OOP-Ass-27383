package _27383.Q5;

import java.time.LocalDate;

public class LeaveRequest extends AttendanceRecord {
    private final LocalDate requestDate;
    private final String reason;
    private final boolean approved;

    public LeaveRequest(int id, String institutionName, String code, String address,
                        String departmentName, String departmentHead,
                        String courseName, String courseCode, int credits,
                        String instructorName, String email, String phone,
                        String studentName, String studentID, int age,
                        LocalDate sessionDate, String topic,
                        int sessionID, String status,
                        LocalDate requestDate, String reason, boolean approved) throws ValidationException {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age, sessionDate, topic, sessionID, status);
        if (reason.isEmpty()) throw new ValidationException("Reason cannot be empty");
        this.requestDate = requestDate;
        this.reason = reason;
        this.approved = approved;
    }

    public LocalDate getRequestDate() { return requestDate; }
    public String getReason() { return reason; }
    public boolean isApproved() { return approved; }
}
