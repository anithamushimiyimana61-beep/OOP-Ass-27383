package _27383.Q2;
import java.time.LocalDate;

public class Airport extends Entity {
    public String airportName;
    public String code;
    private final String location;

    public Airport(int id, LocalDate createdDate, LocalDate updatedDate,
                   String airportName, String code, String location) {
        super(id, createdDate, updatedDate);

        if (airportName == null || airportName.isBlank())
            throw new ValidationException("Airport name required");
        if (!code.matches("[A-Z]{3}"))
            throw new ValidationException("Airport code must be 3 uppercase letters");
        if (location == null || location.isBlank())
            throw new ValidationException("Location required");

        this.airportName = airportName;
        this.code = code;
        this.location = location;
    }

    public String getAirportName() { return airportName; }
    public String getCode() { return code; }
    public String getLocation() { return location; }
}

