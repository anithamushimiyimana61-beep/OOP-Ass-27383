package _27383.Q5;

public class Instructor extends Course {
    private final String instructorName;
    private final String email;
    private final String phone;

    public Instructor(int id, String institutionName, String code, String address,
                      String departmentName, String departmentHead,
                      String courseName, String courseCode, int credits,
                      String instructorName, String email, String phone) throws ValidationException {
        super(id, institutionName, code, address, departmentName, departmentHead, courseName, courseCode, credits);
        if (!email.contains("@")) throw new ValidationException("Invalid email format");
        if (phone.length() != 10) throw new ValidationException("Phone must be 10 digits");
        this.instructorName = instructorName;
        this.email = email;
        this.phone = phone;
    }

    public String getInstructorName() { return instructorName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
