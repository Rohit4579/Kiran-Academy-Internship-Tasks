import java.util.Random;
import java.util.Scanner;

public class CabBookingChatbot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int[] rates = {12, 18, 25};
        String[] cabTypes = {"Auto", "Sedan", "SUV"};

        String[] sources = {
            "Pune Station",
            "Swargate",
            "Hinjawadi"
        };

        String[] destinations = {
            "Shivajinagar",
            "Kothrud",
            "Wakad"
        };

        int[] distances = {5, 8, 10};

        while (true) {
            System.out.println("\n===== CAB BOOKING CHATBOT =====");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter 1 or 2.");
                sc.nextLine();
                continue;
            }

            int mainChoice = sc.nextInt();
            sc.nextLine();

            if (mainChoice == 2) {
                System.out.println("Thank you for using Cab Booking Chatbot!");
                System.out.println("Goodbye!");
                break;
            }

            if (mainChoice != 1) {
                System.out.println("Invalid choice! Please select 1 or 2.");
                continue;
            }

            System.out.println("\nSelect Cab Type:");
            System.out.println("1. Auto  - Rs. 12/km");
            System.out.println("2. Sedan - Rs. 18/km");
            System.out.println("3. SUV   - Rs. 25/km");
            System.out.print("Enter cab choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            int cabChoice = sc.nextInt();
            sc.nextLine();

            if (cabChoice < 1 || cabChoice > cabTypes.length) {
                System.out.println("Invalid cab choice! Returning to main menu.");
                continue;
            }

            System.out.println("\nSelect Route:");
            System.out.println("1. Pune Station to Shivajinagar (5 km)");
            System.out.println("2. Swargate to Kothrud (8 km)");
            System.out.println("3. Hinjawadi to Wakad (10 km)");
            System.out.print("Enter route choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            int routeChoice = sc.nextInt();
            sc.nextLine();

            if (routeChoice < 1 || routeChoice > sources.length) {
                System.out.println("Invalid route choice! Returning to main menu.");
                continue;
            }

            int cabIndex = cabChoice - 1;
            int routeIndex = routeChoice - 1;
            int rate = rates[cabIndex];
            int distance = distances[routeIndex];
            int fare = distance * rate;

            System.out.println("\n===== FARE DETAILS =====");
            System.out.println("Cab Type    : " + cabTypes[cabIndex]);
            System.out.println("Source      : " + sources[routeIndex]);
            System.out.println("Destination : " + destinations[routeIndex]);
            System.out.println("Distance    : " + distance + " km");
            System.out.println("Rate        : Rs. " + rate + "/km");
            System.out.println("Total Fare  : Rs. " + fare);

            System.out.println("\nConfirm your booking:");
            System.out.println("1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Booking not confirmed.");
                sc.nextLine();
                continue;
            }

            int confirmChoice = sc.nextInt();
            sc.nextLine();

            if (confirmChoice == 2) {
                System.out.println("Ride cancelled successfully.");
                System.out.println("No OTP has been shared.");
                continue;
            }

            if (confirmChoice != 1) {
                System.out.println("Invalid choice! Booking not confirmed.");
                System.out.println("No OTP has been shared.");
                continue;
            }

            int otp = random.nextInt(9000) + 1000;
            System.out.println("\nOTP shared with the user: " + otp);
            System.out.println("Booking confirmed successfully!");
            System.out.println("Cancellation is not allowed after OTP sharing.");
            System.out.println("Have a safe journey!");
        }

        sc.close();
    }
}
