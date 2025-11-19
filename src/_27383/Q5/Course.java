package _27383.Q5;

public class Course extends Department {
    private final String courseName;
    private final String courseCode;
    private final int credits;

    public Course(int id, String institutionName, String code, String address,
                  String departmentName, String departmentHead,
                  String courseName, String courseCode, int credits) throws ValidationException {
        super(id, institutionName, code, address, departmentName, departmentHead);
        if (credits <= 0) throw new ValidationException("Credits must be > 0");
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getCredits() { return credits; }
}
