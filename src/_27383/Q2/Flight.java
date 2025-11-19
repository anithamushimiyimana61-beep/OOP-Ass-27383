package _27383.Q2;


import java.time.LocalDate;

public class Flight extends Airline {
    private final String flightNumber;
    private final String departure;
    private final String destination;
    private final double baseFare;

    public Flight(int id, LocalDate createdDate, LocalDate updatedDate,
                  String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail,
                  String flightNumber, String departure, String destination, double baseFare) {

        super(id, createdDate, updatedDate, airportName, code, location,
                airlineName, airlineCode, contactEmail);

        if (flightNumber == null || flightNumber.isBlank())
            throw new ValidationException("Flight number required");
        if (departure == null || departure.isBlank())
            throw new ValidationException("Departure required");
        if (destination == null || destination.isBlank())
            throw new ValidationException("Destination required");
        if (baseFare <= 0)
            throw new ValidationException("Base fare must be > 0");

        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.baseFare = baseFare;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDeparture() { return departure; }
    public String getDestination() { return destination; }
    public double getBaseFare() { return baseFare; }
}
