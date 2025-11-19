package _27383.Q2;

import java.time.LocalDate;

public class Airline extends Airport {
    private final String airlineName;
    private final String airlineCode;
    public String contactEmail;

    public Airline(int id, LocalDate createdDate, LocalDate updatedDate,
                   String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail) {
        super(id, createdDate, updatedDate, airportName, code, location);

        if (airlineName == null || airlineName.isBlank())
            throw new ValidationException("Airline name required");
        if (!airlineCode.matches("[A-Za-z]{2,4}"))
            throw new ValidationException("Airline code must be 2–4 letters");
        if (!contactEmail.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))
            throw new ValidationException("Invalid email format");

        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.contactEmail = contactEmail;
    }

    public String getAirlineName() { return airlineName; }
    public String getAirlineCode() { return airlineCode; }
    public String getContactEmail() { return contactEmail; }
}

