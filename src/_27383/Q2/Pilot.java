package _27383.Q2;
import java.time.LocalDate;

public class Pilot extends Flight {
    public String pilotName;
    public String licenseNumber;
    public int experienceYears;

    public Pilot(int id, LocalDate createdDate, LocalDate updatedDate,
                 String airportName, String code, String location,
                 String airlineName, String airlineCode, String contactEmail,
                 String flightNumber, String departure, String destination, double baseFare,
                 String pilotName, String licenseNumber, int experienceYears) {

        super(id, createdDate, updatedDate, airportName, code, location,
                airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare);

        if (pilotName == null || pilotName.isBlank())
            throw new ValidationException("Pilot name required");
        if (licenseNumber == null || licenseNumber.isBlank())
            throw new ValidationException("License number required");
        if (experienceYears < 2)
            throw new ValidationException("Experience must be >= 2 years");

        this.pilotName = pilotName;
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
    }

    public String getPilotName() { return pilotName; }
    public String getLicenseNumber() { return licenseNumber; }
    public int getExperienceYears() { return experienceYears; }
}

