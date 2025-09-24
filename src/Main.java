import entities.Rent;

import java.io.ByteArrayInputStream;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void fillRooms(Rent[] rooms, Scanner scanner) {
        System.out.print("How many rooms will be rented? ");
        byte quantity = scanner.nextByte();

        for (byte i = 1; i <= quantity; i++) {
            System.out.println("\nRent #" + i + ":");
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("\nE-mail: ");
            String email = scanner.next();
            System.out.print("\nRoom: ");
            byte roomNumber = scanner.nextByte();
            System.out.println();

            Rent rent = new Rent(name, email);
            rooms[roomNumber] = rent;
        }
    }

    public static void printBusyRooms(Rent[] rooms) {
        System.out.println("\n\nBusy Rooms: ");
        for (byte i = 1; i < 10; i++)
            if (rooms[i] != null)
                System.out.println(i + ": " + rooms[i]);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String fakeInputString = "3\nMarco Antonio\nmarco@gmail.com\n5\nMaria Green\nmaria@gmail.com\n1\nAlex Grey\nalex@gmail.com\n8";
        ByteArrayInputStream fakeInput = new ByteArrayInputStream(fakeInputString.getBytes());
        System.setIn(fakeInput);

        Scanner scanner = new Scanner(System.in);

        Rent[] rooms = new Rent[10];
        fillRooms(rooms, scanner);
        printBusyRooms(rooms);
    }
}