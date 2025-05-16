
import java.util.*;

class RESERVATION {

    String name;
    String Email;
    String Phone;
    String checkIn;
    String checkOut;
    public static int Total;

    public RESERVATION() {
    }

    public RESERVATION(String name, String Email, String Phone, String checkIn, String checkOut) {
        this.name = name;
        this.Email = Email;
        this.Phone = Phone;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Store customer info statically to use later
    static RESERVATION currentReservation;

    public static void Booking() {
        int rooms[] = {1, 2, 3, 4, 5};

        if (isAvailability(rooms)) {
            System.out.println("Available");
            System.out.println("Enter Your Details ");
            System.out.println("--------------------");
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your Good name: ");
            String name = sc.nextLine();
            System.out.print("Enter your Email Id: ");
            String Email = sc.nextLine();
            System.out.print("Enter your Phone Number: ");
            String Phone = sc.nextLine();

            System.out.println("--------------------");
            System.out.println("Enter your checkInOut details [dd/mm/yy]");
            System.out.print("Checkin Date: ");
            String checkIn = sc.nextLine();
            System.out.print("Checkout Date: ");
            String checkOut = sc.nextLine();
            checkInOut(checkIn, checkOut);
            currentReservation = new RESERVATION(name, Email, Phone, checkIn, checkOut);
            System.out.println("Booking Successful!");
            System.out.println("[" + name + " - " + Email + " - " + Phone + "]");
        } else {
            System.out.println("Not Available");
            System.out.println("Don't worry , LET TRY OUR COUSINS ");
            Sweet();

        }
    }

    public static void Login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Register Now");
        System.out.print("Enter UserName: ");
        String storedName = sc.nextLine();
        System.out.print("Enter Password: ");
        String storedPassword = sc.nextLine();

        System.out.println("Registration successful!");

        System.out.println("Login Now");
        System.out.print("Enter UserName: ");
        String name = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (name.equals(storedName) && password.equals(storedPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }
    }

    public static boolean isAvailability(int[] arr) {
        if (arr.length > 0) {
            System.out.println("Choose Room Type Facility: AC | Non AC");
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine().trim();

            switch (choose.toUpperCase()) {
                case "AC":
                    System.out.println("FACILITIES\n--------------------");
                    System.out.println("Room Price - 3000");
                    System.out.println("Room Service 24/7");
                    System.out.println("Wi-Fi & Entertainment");
                    System.out.println("Luxury Bath Amenities");
                    break;
                case "NON AC":
                    System.out.println("FACILITIES\n--------------------");
                    System.out.println("Room Price - 1500");
                    System.out.println("Room Service");
                    System.out.println("Ceiling Fans & Ventilation");
                    System.out.println("Comfortable Bedding");
                    break;
                default:
                    System.out.println("Choose Only AC or Non AC");
                    return false;
            }
            return true;
        }
        return false;
    }

    public static void checkInOut(String checkIn, String checkOut) {
        System.out.println("Check-in: " + checkIn + " ==> Check-out: " + checkOut);
    }

    public static void cakes() {
        System.out.println("1. Ice Cream Cake - 550");
        System.out.println("2. Chocolate Cake - 600");
        System.out.println("3. Vanilla Cake   - 500");
        int price[] = {550, 600, 500};
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Items Wanted: ");
        int n = sc.nextInt();
        // int Total = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Choose an Item (1-3): ");
            int choose = sc.nextInt();
            RESERVATION.Total += price[choose - 1];
            itemCakes(choose, price[choose - 1], RESERVATION.Total);
        }
    }

    public static void itemCakes(int index, int price, int Total) {
        String[] cakeItems = {"Ice Cream Cake", "Chocolate Cake", "Vanilla Cake"};
        if (index >= 1 && index <= cakeItems.length) {
            System.out.println("You successfully ordered -> " + cakeItems[index - 1] + " -- " + "Bill Price " + price + " -- " + "Total Price " + Total);
            System.out.println("Total Price = " + Total);
        } else {
            System.out.println("Invalid Cake Choice.");
        }
    }

    public static void chicken() {
        System.out.println("1. Grill Chicken - 200");
        System.out.println("2. Pepper Chicken - 900");
        System.out.println("3. Crispy Chicken - 500");
        int price[] = {200, 900, 500};
        Scanner sc = new Scanner(System.in);
        System.out.print("How Many Items Wanted: ");
        int n = sc.nextInt();
        // int Total = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Choose an Item (1-3): ");
            int choose = sc.nextInt();
            RESERVATION.Total += price[choose - 1];
            itemChicken(choose, price[choose - 1], RESERVATION.Total);
        }
    }

    public static void itemChicken(int index, int Amount, int Total) {

        String[] chickenItems = {"Grill Chicken", "Pepper Chicken", "Crispy Chicken"};
        if (index >= 1 && index <= chickenItems.length) {
            System.out.println("You successfully ordered -> " + chickenItems[index - 1] + " -- " + "Bill Price " + Amount + " -- " + "   Total Price " + Total);
            System.out.println("TOTAL FOOD PRICE = " + Total);
        } else {
            System.out.println("Invalid Chicken Choice.");
        }
    }

    public static void Sweet() {
        System.out.println("SWEET ITEMS\n------------");
        System.out.println("1. Cakes");
        System.out.println("2. Chicken");
        System.out.println("3. Candies");
        System.out.println("4. Frozen");
        System.out.print("Enter your Choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                cakes();
                break;
            case 2:
                chicken();
                break;
            default:
                System.out.println("Option not implemented.");
        }
    }

    public void customerDetailes() {
        if (currentReservation != null) {
            System.out.println(currentReservation.name + " - " + currentReservation.Email + " - " + currentReservation.Phone + " - " + currentReservation.checkIn + " ==> " + currentReservation.checkOut);
        } else {
            System.out.println("No customer details found.");
        }
    }

    //Entertainment part
    public void entermentPart(String ePart, int ticketAmount) {
        if (ePart.equals("K") && ticketAmount <= 100) {
            System.out.println("🖍️CREATIVE CORNER");
            System.out.println("---------------------------------");
            System.out.println("Drawing and coloring tables");
            System.out.println("LEGO or block building station");
            System.out.println("Storytelling corner / Puppet shows");
            System.out.println("Mini indoor slides & tunnels");

        } else if (ePart.equals("P") && ticketAmount >= 100) {
            System.out.println("☕ RRELAXATION AREA");
            System.out.println("---------------------------------");
            System.out.println("Calming ambiance with music or soft lights");
            System.out.println("Comfortable seating with charging points");
            System.out.println("Quick spa/foot soak area");
            System.out.println("Foot massagers or recliners");
        } else {
            System.out.println("You Entered Wrongly!!!");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        int rooms[] = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        RESERVATION reserve = new RESERVATION();

        while (true) {
            System.out.println("\nWelcome To Prithivi Hotel");
            System.out.println("****************************");
            System.out.println("1. REGISTER AND LOGIN");
            System.out.println("2. ROOM AVAILABILITY");
            System.out.println("3. BOOK YOUR ROOMS");
            System.out.println("4. ORDER YOUR FOODS");
            System.out.println("5. CUSTOMER DETAILS");
            System.out.println("6. ENTERMENTPART");
            System.out.println("Q. QUIT");
            System.out.println("****************************");
            System.out.print("Enter Your Choice: ");

            String input = sc.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thank you for using the system!");
                break;
            }

            switch (input) {
                case "1":
                    reserve.Login();
                    break;
                case "2":
                    reserve.isAvailability(rooms);
                    break;
                case "3":
                    reserve.Booking();
                    break;
                case "4":
                    reserve.Sweet();
                    break;
                case "5":
                    reserve.customerDetailes();
                    break;
                case "6":
                    System.out.println("Enter Ticket Amount -- 100");
                    int ticketAmount = sc.nextInt();
                    sc.nextLine();
                    System.out.println("k - kids Section | P - Parent Section");
                    String ePart = sc.nextLine().toUpperCase();
                    reserve.entermentPart(ePart, ticketAmount);
                    break;
                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
        sc.close();
    }
}
