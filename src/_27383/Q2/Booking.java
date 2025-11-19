package _27383.Q2;

import java.time.LocalDate;

public class Booking extends Passenger {
    private final LocalDate bookingDate;
    public String seatNumber;
    public String travelClass;

    public Booking(int id, LocalDate createdDate, LocalDate updatedDate,
                   String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail,
                   String flightNumber, String departure, String destination, double baseFare,
                   String pilotName, String licenseNumber, int experienceYears,
                   String crewName, String role, String shift,
                   String passengerName, int age, String gender, String contact,
                   LocalDate bookingDate, String seatNumber, String travelClass) {

        super(id, createdDate, updatedDate, airportName, code, location,
                airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears,
                crewName, role, shift,
                passengerName, age, gender, contact);

        if (bookingDate == null)
            throw new ValidationException("Booking date required");
        if (seatNumber == null || seatNumber.isBlank())
            throw new ValidationException("Seat number required");

        if (!travelClass.matches("(?i)Economy|Business|First"))
            throw new ValidationException("Travel class must be Economy, Business, or First");

        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.travelClass = travelClass;
    }

    public LocalDate getBookingDate() { return bookingDate; }
    public String getSeatNumber() { return seatNumber; }
    public String getTravelClass() { return travelClass; }
}
