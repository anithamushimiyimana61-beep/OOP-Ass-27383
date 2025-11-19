package _27383.Q2;

import java.time.LocalDate;

public class Payment extends Booking {
    private final LocalDate paymentDate;
    public String paymentMethod;
    private final double amountPaid;

    public Payment(int id, LocalDate createdDate, LocalDate updatedDate,
                   String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail,
                   String flightNumber, String departure, String destination, double baseFare,
                   String pilotName, String licenseNumber, int experienceYears,
                   String crewName, String role, String shift,
                   String passengerName, int age, String gender, String contact,
                   LocalDate bookingDate, String seatNumber, String travelClass,
                   LocalDate paymentDate, String paymentMethod, double amountPaid) {

        super(id, createdDate, updatedDate, airportName, code, location,
                airlineName, airlineCode, contactEmail,
                flightNumber, departure, destination, baseFare,
                pilotName, licenseNumber, experienceYears,
                crewName, role, shift,
                passengerName, age, gender, contact,
                bookingDate, seatNumber, travelClass);

        if (paymentDate == null)
            throw new ValidationException("Payment date required");
        if (paymentMethod == null || paymentMethod.isBlank())
            throw new ValidationException("Payment method required");
        if (amountPaid <= 0)
            throw new ValidationException("Amount paid must be > 0");

        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
    }

    public LocalDate getPaymentDate() { return paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public double getAmountPaid() { return amountPaid; }
}
