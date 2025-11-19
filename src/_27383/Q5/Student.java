package _27383.Q5;

public class Student extends Instructor {
    private final String studentName;
    private final String studentID;
    private final int age;

    public Student(int id, String institutionName, String code, String address,
                   String departmentName, String departmentHead,
                   String courseName, String courseCode, int credits,
                   String instructorName, String email, String phone,
                   String studentName, String studentID, int age) throws ValidationException {
        super(id, institutionName, code, address, departmentName, departmentHead,
                courseName, courseCode, credits, instructorName, email, phone);
        if (age <= 0) throw new ValidationException("Age must be > 0");
        this.studentName = studentName;
        this.studentID = studentID;
        this.age = age;
    }

    public String getStudentName() { return studentName; }
    public String getStudentID() { return studentID; }
    public int getAge() { return age; }
}
