package _27383.Q5;

import java.time.LocalDate;

public class ClassSession extends Student {
    private final LocalDate sessionDate;
    private final String topic;

    public ClassSession(int id, String institutionName, String code, String address,
                        String departmentName, String departmentHead,
                        String courseName, String courseCode, int credits,
                        String instructorName, String email, String phone,
                        String studentName, String studentID, int age,
                        LocalDate sessionDate, String topic) throws ValidationException {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age);
        this.sessionDate = sessionDate;
        this.topic = topic;
    }

    public LocalDate getSessionDate() { return sessionDate; }
    public String getTopic() { return topic; }
}
