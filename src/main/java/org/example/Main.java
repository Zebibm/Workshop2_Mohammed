package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //  20 books
        Book[] books = new Book[20];

        books[0] = new Book(1, "ISBN1000", "Harry Potter");
        books[1] = new Book(2, "ISBN1001", "The Hobbit");
        books[2] = new Book(3, "ISBN1002", "Atomic Habits");
        books[3] = new Book(4, "ISBN1003", "Rich Dad Poor Dad");
        books[4] = new Book(5, "ISBN1004", "The Alchemist");
        books[5] = new Book(6, "ISBN1005", "Think and Grow Rich");
        books[6] = new Book(7, "ISBN1006", "1984");
        books[7] = new Book(8, "ISBN1007", "To Kill a Mockingbird");
        books[8] = new Book(9, "ISBN1008", "The Great Gatsby");
        books[9] = new Book(10, "ISBN1009", "Moby Dick");
        books[10] = new Book(11, "ISBN1010", "The Catcher in the Rye");
        books[11] = new Book(12, "ISBN1011", "Pride and Prejudice");
        books[12] = new Book(13, "ISBN1012", "The Lord of the Rings");
        books[13] = new Book(14, "ISBN1013", "The Book Thief");
        books[14] = new Book(15, "ISBN1014", "Dune");
        books[15] = new Book(16, "ISBN1015", "Fahrenheit 451");
        books[16] = new Book(17, "ISBN1016", "The Hunger Games");
        books[17] = new Book(18, "ISBN1017", "The Da Vinci Code");
        books[18] = new Book(19, "ISBN1018", "Brave New World");
        books[19] = new Book(20, "ISBN1019", "The Silent Patient");

        //  MENU LOOP
        while (true) {

            System.out.println("\n===== Neighborhood Library =====");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            if (choice == 1) {
                showAvailableBooks(books, input);

            } else if (choice == 2) {
                showCheckedOutBooks(books, input);

            } else if (choice == 3) {
                System.out.println("Thank you for visiting the Neighborhood Library. Come back soon ");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }

    //  AVAILABLE BOOKS
    public static void showAvailableBooks(Book[] books, Scanner input) {

        System.out.println("\n--- Available Books ---");

        boolean found = false;

        for (Book b : books) {
            if (!b.isCheckedOut()) {
                System.out.println(b.getId() + " | " + b.getIsbn() + " | " + b.getTitle());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books.");
            return;
        }

        System.out.print("\nEnter book id to check out (0 to go back): ");
        int id = input.nextInt();

        if (id == 0) return;

        input.nextLine();

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        for (Book b : books) {
            if (b.getId() == id && !b.isCheckedOut()) {
                b.checkOut(name);
                System.out.println("Book checked out successfully!");
                return;
            }
        }

        System.out.println("Book not available or already checked out.");
    }

    //  CHECKED OUT BOOKS
    public static void showCheckedOutBooks(Book[] books, Scanner input) {

        System.out.println("\n--- Checked Out Books ---");

        boolean found = false;

        for (Book b : books) {
            if (b.isCheckedOut()) {
                System.out.println(
                        b.getId() + " | " +
                                b.getIsbn() + " | " +
                                b.getTitle() + " | " +
                                b.getCheckedOutTo()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.println("\nC - Check In a Book");
        System.out.println("X - Back to Menu");
        System.out.print("Choose: ");

        String choice = input.next();

        if (choice.equalsIgnoreCase("C")) {

            System.out.print("Enter book id: ");
            int id = input.nextInt();

            for (Book b : books) {
                if (b.getId() == id && b.isCheckedOut()) {
                    b.checkIn();
                    System.out.println("Book checked in successfully!");
                    return;
                }
            }

            System.out.println("That book is not currently checked out.");
        }
    }
}