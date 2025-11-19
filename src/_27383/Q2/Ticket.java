package _27383.Q2;

import java.time.LocalDate;

public final class Ticket extends Payment {
    private final String ticketNumber;

    public Ticket(int id, LocalDate createdDate, LocalDate updatedDate,
                  String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail,
                  String flightNumber, String departure, String destination, double baseFare,
                  String pilotName, String licenseNumber, int experienceYears,
                  String crewName, String role, String shift,
                  String passengerName, int age, String gender, String contact,
                  LocalDate bookingDate, String seatNumber, String travelClass,
                  LocalDate paymentDate, String paymentMethod, double amountPaid,
                  String ticketNumber, LocalDate issueDate) {

        super(id, createdDate, updatedDate, airportName, code, location,
                airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears,
                crewName, role, shift,
                passengerName, age, gender, contact,
                bookingDate, seatNumber, travelClass,
                paymentDate, paymentMethod, amountPaid);

        if (ticketNumber == null || ticketNumber.isBlank())
            throw new ValidationException("Ticket number required");
        if (issueDate == null)
            throw new ValidationException("Issue date required");

        this.ticketNumber = ticketNumber;
    }

    public double calculateFare() {
        double tax = getBaseFare() * 0.18; // VAT 18%
        double discount = getTravelClass().equalsIgnoreCase("Business") ? 50 :
                getTravelClass().equalsIgnoreCase("First") ? 100 : 0;

        return getBaseFare() + tax - discount;
    }

    public void displayTicket() {
        System.out.println("\n===== FLIGHT TICKET =====");
        System.out.println("Ticket No: " + ticketNumber);
        System.out.println("Passenger: " + getPassengerName());
        System.out.println("Flight: " + getFlightNumber());
        System.out.println("From: " + getDeparture() + " To: " + getDestination());
        System.out.println("Seat: " + getSeatNumber());
        System.out.println("Class: " + getTravelClass());
        System.out.println("Fare: " + calculateFare());
        System.out.println("==========================");
    }
}
