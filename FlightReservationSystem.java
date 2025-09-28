import java.util.*;

class Flight {
    int flightId;
    String source;
    String destination;
    int seatsAvailable;

    Flight(int flightId, String source, String destination, int seatsAvailable) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    public String toString() {
        return "Flight ID: " + flightId + ", From: " + source + ", To: " + destination + ", Seats Available: " + seatsAvailable;
    }
}

class Reservation {
    int reservationId;
    String passengerName;
    int flightId;

    Reservation(int reservationId, String passengerName, int flightId) {
        this.reservationId = reservationId;
        this.passengerName = passengerName;
        this.flightId = flightId;
    }

    public String toString() {
        return "Reservation ID: " + reservationId + ", Passenger: " + passengerName + ", Flight ID: " + flightId;
    }
}

public class FlightReservationSystem {
    static List<Flight> flights = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int reservationCounter = 1;

    public static void main(String[] args) {
        initializeFlights();
        int choice;

        do {
            System.out.println("\n--- Flight Reservation Menu ---");
            System.out.println("1. View Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: viewFlights(); break;
                case 2: bookFlight(); break;
                case 3: cancelReservation(); break;
                case 4: viewReservations(); break;
                case 5: System.out.println("Thank you for using the system."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    static void initializeFlights() {
        flights.add(new Flight(101, "Mumbai", "Delhi", 5));
        flights.add(new Flight(102, "Pune", "Bangalore", 3));
        flights.add(new Flight(103, "Chennai", "Kolkata", 4));
    }

    static void viewFlights() {
        System.out.println("\nAvailable Flights:");
        for (Flight f : flights) {
            System.out.println(f);
        }
    }

    static void bookFlight() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter Flight ID to book: ");
        int flightId = sc.nextInt();

        for (Flight f : flights) {
            if (f.flightId == flightId && f.seatsAvailable > 0) {
                f.seatsAvailable--;
                reservations.add(new Reservation(reservationCounter++, name, flightId));
                System.out.println("Reservation successful!");
                return;
            }
        }
        System.out.println("Flight not found or no seats available.");
    }

    static void cancelReservation() {
        System.out.print("Enter Reservation ID to cancel: ");
        int resId = sc.nextInt();
        Iterator<Reservation> iterator = reservations.iterator();

        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.reservationId == resId) {
                iterator.remove();
                for (Flight f : flights) {
                    if (f.flightId == r.flightId) {
                        f.seatsAvailable++;
                        break;
                    }
                }
                System.out.println("Reservation cancelled.");
                return;
            }
        }
        System.out.println("Reservation ID not found.");
    }

    static void viewReservations() {
        System.out.println("\nAll Reservations:");
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
}

