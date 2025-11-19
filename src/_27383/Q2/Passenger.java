package _27383.Q2;

import java.time.LocalDate;

public class Passenger extends CabinCrew {
    private final String passengerName;
    public int age;
    public String gender;
    public String contact;

    public Passenger(int id, LocalDate createdDate, LocalDate updatedDate,
                     String airportName, String code, String location,
                     String airlineName, String airlineCode, String contactEmail,
                     String flightNumber, String departure, String destination, double baseFare,
                     String pilotName, String licenseNumber, int experienceYears,
                     String crewName, String role, String shift,
                     String passengerName, int age, String gender, String contact) {

        super(id, createdDate, updatedDate, airportName, code, location,
                airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears,
                crewName, role, shift);

        if (passengerName == null || passengerName.isBlank())
            throw new ValidationException("Passenger name required");
        if (age <= 0) throw new ValidationException("Age must be > 0");
        if (!gender.matches("(?i)Male|Female"))
            throw new ValidationException("Gender must be Male or Female");
        if (contact == null || contact.isBlank())
            throw new ValidationException("Contact required");

        this.passengerName = passengerName;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }

    public String getPassengerName() { return passengerName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContact() { return contact; }
}
