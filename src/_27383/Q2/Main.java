package _27383.Q2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    static void main() {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("===== FLIGHT BOOKING SYSTEM =====");

            // ---------------- AIRPORT ----------------
            System.out.println("\n--- Airport Information ---");
            System.out.print("Airport Name: ");
            String airportName = sc.nextLine();

            System.out.print("Airport Code (3 letters): ");
            String airportCode = sc.nextLine();

            System.out.print("Airport Location: ");
            String airportLocation = sc.nextLine();

            // ---------------- AIRLINE ----------------
            System.out.println("\n--- Airline Information ---");
            System.out.print("Airline Name: ");
            String airlineName = sc.nextLine();

            System.out.print("Airline Code (2-4 letters): ");
            String airlineCode = sc.nextLine();

            System.out.print("Airline Contact Email: ");
            String contactEmail = sc.nextLine();

            // ---------------- FLIGHT ----------------
            System.out.println("\n--- Flight Information ---");
            System.out.print("Flight Number: ");
            String flightNumber = sc.nextLine();

            System.out.print("Departure Airport: ");
            String departure = sc.nextLine();

            System.out.print("Destination Airport: ");
            String destination = sc.nextLine();

            System.out.print("Base Fare: ");
            double baseFare = Double.parseDouble(sc.nextLine());

            // ---------------- PILOT ----------------
            System.out.println("\n--- Pilot Information ---");
            System.out.print("Pilot Name: ");
            String pilotName = sc.nextLine();

            System.out.print("Pilot License Number: ");
            String licenseNumber = sc.nextLine();

            System.out.print("Years of Experience (>=2): ");
            int experienceYears = Integer.parseInt(sc.nextLine());

            // ---------------- CABIN CREW ----------------
            System.out.println("\n--- Cabin Crew Information ---");
            System.out.print("Crew Name: ");
            String crewName = sc.nextLine();

            System.out.print("Crew Role: ");
            String crewRole = sc.nextLine();

            System.out.print("Shift (Day/Night): ");
            String shift = sc.nextLine();

            // ---------------- PASSENGER ----------------
            System.out.println("\n--- Passenger Information ---");
            System.out.print("Passenger Name: ");
            String passengerName = sc.nextLine();

            System.out.print("Passenger Age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Passenger Gender (Male/Female): ");
            String gender = sc.nextLine();

            System.out.print("Passenger Contact: ");
            String contact = sc.nextLine();

            // ---------------- BOOKING ----------------
            System.out.println("\n--- Booking Information ---");
            System.out.print("Booking Date (YYYY-MM-DD): ");
            LocalDate bookingDate = LocalDate.parse(sc.nextLine());

            System.out.print("Seat Number: ");
            String seatNumber = sc.nextLine();

            System.out.print("Travel Class (Economy/Business/First): ");
            String travelClass = sc.nextLine();

            // ---------------- PAYMENT ----------------
            System.out.println("\n--- Payment Information ---");
            System.out.print("Payment Date (YYYY-MM-DD): ");
            LocalDate paymentDate = LocalDate.parse(sc.nextLine());

            System.out.print("Payment Method: ");
            String paymentMethod = sc.nextLine();

            System.out.print("Amount Paid: ");
            double amountPaid = Double.parseDouble(sc.nextLine());

            // ---------------- TICKET ----------------
            System.out.println("\n--- Ticket Information ---");
            System.out.print("Ticket Number: ");
            String ticketNumber = sc.nextLine();

            LocalDate issueDate = LocalDate.now(); // Auto-issue today


            // CREATE FINAL TICKET OBJECT
            Ticket ticket = new Ticket(
                    1, LocalDate.now(), LocalDate.now(),
                    airportName, airportCode, airportLocation,
                    airlineName, airlineCode, contactEmail,
                    flightNumber, departure, destination, baseFare,
                    pilotName, licenseNumber, experienceYears,
                    crewName, crewRole, shift,
                    passengerName, age, gender, contact,
                    bookingDate, seatNumber, travelClass,
                    paymentDate, paymentMethod, amountPaid,
                    ticketNumber, issueDate
            );

            // DISPLAY TICKET
            ticket.displayTicket();

            System.out.println("\nBooking completed successfully!");

        } catch (ValidationException ve) {
            System.out.println("\nERROR: " + ve.getMessage());
        } catch (Exception ex) {
            System.out.println("\nSomething went wrong: " + ex.getMessage());
        }

        sc.close();
    }
}
