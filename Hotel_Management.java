import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hotel {
    String hotel_name;
    List<Room> room;

    Hotel(String hotel_name) {
        this.hotel_name = hotel_name;
        this.room = new ArrayList<>();
    }

    public String getHotelName() {
        return hotel_name;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void addRoom(Room e) {
        room.add(e);
    }
}

class Room {
    int roomnumber;
    String roomtype;
    boolean isbooked;
    String guestname;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime check_in;
    LocalDateTime check_out;

    public Room(int roomnumber, String roomtype) {
        this.roomnumber = roomnumber;
        this.roomtype = roomtype;
        this.isbooked = false;
        this.guestname = "";
        this.check_in = null;
        this.check_out = null;
    }

    public int getroomnumber() {
        return roomnumber;
    }

    public String getroomtype() {
        return roomtype;
    }

    public boolean isbooked() {
        return isbooked;
    }

    public String getguestname() {
        return guestname;
    }

    public LocalDateTime getcheckin() {
        return check_in;
    }

    public LocalDateTime getcheckout() {
        return check_out;
    }

    public void bookRoom(String guestname) {
        if (!isbooked) {
            this.isbooked = true;
            this.guestname = guestname;
            this.check_in = LocalDateTime.now();

            System.out.println(
                    "Room " + roomnumber + " is successfully booked for " + guestname + " at " + dtf.format(check_in));
        } else
            System.out.println("Room " + roomnumber + " is already booked.");
    }

    public void freeRoom() {
        if (isbooked) {
            this.isbooked = false;
            // this.guestname = "";
            this.check_out = LocalDateTime.now();

            System.out.println("Room was free at " + dtf.format(check_out));
            System.out.println("Room " + roomnumber + " is now available.");
        } else
            System.out.println("Room " + roomnumber + " already free.");
    }
}

public class Hotel_Management {
    private static Scanner sc = new Scanner(System.in);
    private static List<Hotel> hotels = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("----- Hotel Management System -----");
            System.out.println("1. Add Hotel");
            System.out.println("2. Add Room to Hotel");
            System.out.println("3. Book Room");
            System.out.println("4. Free room");
            System.out.println("5. View All");
            System.out.println("6. Check-in/out details.");
            System.out.println("7. Exit");
            System.out.println("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addhotel();
                    break;

                case 2:
                    addroomtohotel();
                    break;

                case 3:
                    bookroom();
                    break;

                case 4:
                    freeroom();
                    break;

                case 5:
                    viewhotelsandroom();
                    break;

                case 6:
                    System.out.println("Details of Guests:");
                    check_details();
                    break;

                case 7:
                    System.out.println("Exiting...............");
                    break;

                default:
                    System.out.println("Not valid choice, please enter a valid choice.");
            }
        } while (choice != 7);
    }

    private static void addhotel() {
        System.out.println("Enter Hotel name: ");
        String hotelname = sc.next();

        if (findhotelbyname(hotelname) == null) {
            hotels.add(new Hotel(hotelname));
            System.out.println("Hotel " + hotelname + " has been added.");
        } else
            System.out.println("Hotel already exist.");
    }

    private static void bookroom() {
        System.out.println("Enter Hotel name: ");
        String hotelname = sc.next();
        Hotel hotel = findhotelbyname(hotelname);

        if (hotel != null) {
            System.out.println("Enter room number: ");
            int roomnumber = sc.nextInt();
            Room room = findroombynumber(hotel, roomnumber);

            if (room != null) {
                System.out.println("Enter Your Name: ");
                String guestname = sc.next();

                room.bookRoom(guestname);
            } else
                System.out.println("Room not found.");
        } else
            System.out.println("Hotel not found.");
    }

    private static void freeroom() {
        System.out.println("Enter Hotel name: ");
        String hotelname = sc.next();
        Hotel hotel = findhotelbyname(hotelname);

        if (hotel != null) {
            System.out.println("Enter room number: ");
            int roomnumber = sc.nextInt();
            Room room = findroombynumber(hotel, roomnumber);

            if (room != null) {
                room.freeRoom();
            } else
                System.out.println("Room not found.");
        } else
            System.out.println("Hotel not found.");
    }

    private static void addroomtohotel() {
        System.out.println("Enter Hotel name: ");
        String hotelname = sc.next();
        Hotel hotel = findhotelbyname(hotelname);

        if (hotel != null) {
            System.out.println("Enter room number: ");
            int roomnumber = sc.nextInt();

            System.out.println("Enter type of room (Single/Double/Suite).");
            String roomtype = sc.next();

            if (findroombynumber(hotel, roomnumber) == null) {
                hotel.addRoom(new Room(roomnumber, roomtype));
                System.out.println("Room " + roomnumber + " (" + roomtype + ") has been added to " + hotelname);
            } else
                System.out.println("Room already exist.");

        } else
            System.out.println("Hotel not found.");
    }

    private static void viewhotelsandroom() {
        for (Hotel hotel : hotels) {
            System.out.println("\nHotel " + hotel.getHotelName());

            for (Room room : hotel.getRoom()) {
                String status = room.isbooked() ? "Booked by " + room.getguestname() : "Available";
                System.out.println(
                        "Room: " + room.getroomnumber() + " Type: " + room.getroomtype() + " Status: " + status);
            }
        }
    }

    private static Hotel findhotelbyname(String hotelname) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelname)) {
                return hotel;
            }
        }
        return null;
    }

    // private static boolean checkhotelbyname(String hotelname) {
    // for (Hotel hotel : hotels) {
    // if (hotel.getHotelName().equals(hotelname)) {
    // return false;
    // }
    // }
    // return true;
    // }

    private static Room findroombynumber(Hotel hotel, int roomnumber) {
        for (Room room : hotel.getRoom()) {
            if (room.getroomnumber() == roomnumber)
                return room;
        }
        return null;
    }

    // private static boolean checkroomnumber(Hotel hotel, int roomnumber) {
    // for (Room room : hotel.getRoom()) {
    // if (room.getroomnumber() == roomnumber)
    // return false;
    // }
    // return true;
    // }

    private static void check_details() {
        for (Hotel hotel : hotels) {
            for (Room room : hotel.getRoom()) {
                if (room.getcheckin() != null && room.getcheckout() != null)
                    System.out.println("Guest name: " + room.getguestname() + " booked the room " + room.getroomnumber()
                            + " at Hotel " + hotel.getHotelName() + " at " + room.getcheckin() + " and checked out at "
                            + room.getcheckout());

                else if (room.getcheckin() != null && room.getcheckout() == null)
                    System.out.println("Guest name: " + room.getguestname() + " booked the room " + room.getroomnumber()
                            + " at Hotel " + hotel.getHotelName() + " at " + room.getcheckin());

                else if (!room.isbooked())
                    System.out.println("Room " + room.getroomnumber() + " is available, You can book it.");
            }
        }
    }
}