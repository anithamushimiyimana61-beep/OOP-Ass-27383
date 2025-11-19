package _27383.Q2;

import java.time.LocalDate;

public class CabinCrew extends Pilot {
    private final String crewName;
    public String role;
    public String shift; // Day or Night

    public CabinCrew(int id, LocalDate createdDate, LocalDate updatedDate,
                     String airportName, String code, String location,
                     String airlineName, String airlineCode, String contactEmail,
                     String flightNumber, String departure, String destination, double baseFare,
                     String pilotName, String licenseNumber, int experienceYears,
                     String crewName, String role, String shift) {

        super(id, createdDate, updatedDate, airportName, code, location,
                airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears);

        if (crewName == null || crewName.isBlank())
            throw new ValidationException("Crew name required");
        if (role == null || role.isBlank())
            throw new ValidationException("Role required");
        if (!shift.equalsIgnoreCase("Day") && !shift.equalsIgnoreCase("Night"))
            throw new ValidationException("Shift must be Day or Night");

        this.crewName = crewName;
        this.role = role;
        this.shift = shift;
    }

    public String getCrewName() { return crewName; }
    public String getRole() { return role; }
    public String getShift() { return shift; }
}
