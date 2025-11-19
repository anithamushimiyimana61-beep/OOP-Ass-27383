package _27383.Q5;

public class AttendanceRecord extends ClassSession {
    private final String studentID;
    private final int sessionID;
    private final String status;

    public AttendanceRecord(int id, String institutionName, String code, String address,
                            String departmentName, String departmentHead,
                            String courseName, String courseCode, int credits,
                            String instructorName, String email, String phone,
                            String studentName, String studentID, int age,
                            java.time.LocalDate sessionDate, String topic,
                            int sessionID, String status) throws ValidationException {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age, sessionDate, topic);
        if (!status.equals("Present") && !status.equals("Absent")) throw new ValidationException("Status must be Present/Absent");
        this.studentID = studentID;
        this.sessionID = sessionID;
        this.status = status;
    }

    public String getStudentID() { return studentID; }
    public int getSessionID() { return sessionID; }
    public String getStatus() { return status; }
}
