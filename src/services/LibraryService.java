package services;

import models.Book;
import models.Borrower;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class LibraryService {
    //Assume lists to store current books and borrowers
    private List<Book> books = new ArrayList<>();
    private List<Borrower> borrowers = new ArrayList<>();
    private int nextBookID = 1;
    static Scanner keyboard = new Scanner(System.in);

    private String generateBookID() {
        return "B" + String.format("%03d", nextBookID++);
    }
    
    //---- Getters ----
    public List<Book> getBooks() {
        return books;
    }
    
    public List<Borrower> getBorrowers() {
        return borrowers;
    }
    //---- Book related methods ----
    public void addBook() {
        System.out.println("=== Add New Book ===");

        String id = generateBookID();   // Auto-generate ID
        System.out.println("Generated Book ID: " + id);

        System.out.print("Enter book title: ");
        String title = keyboard.nextLine().trim();

        System.out.print("Enter book author: ");
        String author = keyboard.nextLine().trim();

        System.out.print("Enter book genre: ");
        String genre = keyboard.nextLine().trim();

        Book newBook = new Book(id, title, author, genre);
        books.add(newBook);

        System.out.println("Book added successfully!");
    }

    public void editBook() {
        System.out.println("=== Edit Book ===");

        System.out.print("Enter the ID of the book to edit: ");
        String id = keyboard.nextLine().trim();

        Book bookToEdit = null;

        for (Book b : books) {
            if (b.getID().equalsIgnoreCase(id)) {
                bookToEdit = b;
                break;
            }
        }

        if (bookToEdit == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        System.out.println("Editing Book: " + bookToEdit);

        System.out.print("Enter new title (leave blank to keep as '" + bookToEdit.getTitle() + "'): ");
        String newTitle = keyboard.nextLine().trim();
        if (!newTitle.isEmpty()) {
            bookToEdit.setTitle(newTitle);
        }

        System.out.print("Enter new author (leave blank to keep as '" + bookToEdit.getAuthor() + "'): ");
        String newAuthor = keyboard.nextLine().trim();
        if (!newAuthor.isEmpty()) {
            bookToEdit.setAuthor(newAuthor);
        }

        System.out.print("Enter new genre (leave blank to keep as '" + bookToEdit.getGenre() + "'): ");
        String newGenre = keyboard.nextLine().trim();
        if (!newGenre.isEmpty()) {
            bookToEdit.setGenre(newGenre);
        }

        System.out.println("Book updated successfully!");
    }

    public void deleteBook() {
        System.out.println("=== Delete Book ===");
        
        System.out.print("Enter the ID of the book to delete: ");
        String id = keyboard.nextLine().trim();

        Book bookToDelete = null;

        for (Book b : books) {
            if (b.getID().equalsIgnoreCase(id)) {
                bookToDelete = b;
                break;
            }
        }

        if (bookToDelete == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        System.out.println("Book found: " + bookToDelete.getTitle());
        System.out.print("Are you sure you want to delete this book? (y/n): ");
        String confirm = keyboard.nextLine().trim();

        if (confirm.equalsIgnoreCase("y")) {
            books.remove(bookToDelete);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Deletion canceled.");
        }
    }

    public void searchBooks(String key) {
        //returns books matching keyword
        List<Book> matchingBooks = new ArrayList<>();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("You're looking for: '" + key + "'");
        System.out.println("\nAre you searching for a book title, author, or genre?");
        System.out.println("0 - Return to Menu\n"
                + "1 - Search by Title\n"
                + "2 - Search by Author\n"
                + "3 - Search by Genre\n");
        int exit = keyboard.nextInt();

        //case for each possible input
        switch (exit) {
            case 0 -> {
                return;
            } //just exit
            case 1 -> {//Title
                System.out.println("SEARCHING BY TITLE...");
                for (Book e : books) {
                    String tempTitle = e.getTitle().toLowerCase(); //lowercase title
                    if ( tempTitle.contains(key.toLowerCase())) { //check against lowercase key
                        matchingBooks.add(e); //add all matching books to the arraylist
                    }
                }
            }
            case 2 -> {//Author
                System.out.println("SEARCHING BY AUTHOR...");
                for (Book e : books) {
                    String tempAuthor = e.getAuthor().toLowerCase(); //lowercase 
                    if ( tempAuthor.contains(key.toLowerCase())) { //check against lowercase key
                        matchingBooks.add(e); //add all matching books to the arraylist
                    }
                }
            }
            case 3 -> {//Genre
                System.out.println("SEARCHING BY GENRE...");
                for (Book e : books) {
                    String tempGenre = e.getGenre().toLowerCase(); //lowercase title
                    if ( tempGenre.contains(key.toLowerCase())) { //check against lowercase key
                        matchingBooks.add(e); //add all matching books to the arraylist
                    }
                }
            }
            default -> { //default returns to menu
                System.out.println("INVALID INPUT. Aborting search...");
                return;
            }
        }// end switch statement
        
        //do nothing if the list is empty 
        if (matchingBooks.isEmpty()) {
        System.out.println("\nSorry! No books matching that keyword were found.");
        }
        else {//search through and display books
            System.out.println("\nHere are the books we found: ");
            for(Book var : matchingBooks) {
                System.out.println(var); //utilize toString override in Book object
            }
        
        }
    }// end searchBooks

    public List<Book> filterByAvailability() {
        //return only books that aren't being borrowed
        return new ArrayList<>();
    }

    //---- Borrower related methods -----
    public String generateBorrowerID() {
        return "P" + String.format("%03d", borrowers.size() + 1);
    }

    public void addBorrower() {
        System.out.println("=== Add Borrower ===");

        //Generate a unique borrower ID (similar to the book ID)
        String borrowerID = generateBorrowerID();
        System.out.println("Assigned Borrower ID: " + borrowerID);

        System.out.print("Enter borrower's name: ");
        String name = keyboard.nextLine().trim();

        System.out.print("Enter borrower's email: ");
        String email = keyboard.nextLine().trim();

        System.out.print("Enter borrower's phone number: ");
        String phoneNum = keyboard.nextLine().trim();

        Borrower newBorrower = new Borrower(borrowerID, name, email, phoneNum);
        borrowers.add(newBorrower);

        System.out.println("Borrower added successfully!");
    }

    public void editBorrower() {
        System.out.println("=== Edit Borrower ===");

        System.out.print("Enter the ID of the borrower to edit: ");
        String borrowerID = keyboard.nextLine().trim();

        Borrower borrowerToEdit = null;

        //Find the borrower by ID
        for (Borrower b : borrowers) {
            if (b.getID().equalsIgnoreCase(borrowerID)) {
                borrowerToEdit = b;
                break;
            }
        }

        if (borrowerToEdit == null) {
            System.out.println("Borrower with ID " + borrowerID + " not found.");
            return;
        }

        //Display current borrower info
        System.out.println("Current Borrower Information:");
        System.out.println("Name: " + borrowerToEdit.getName());
        System.out.println("Email: " + borrowerToEdit.getEmail());
        System.out.println("Phone Number: " + borrowerToEdit.getPhoneNum());

        //Prompt for which field to edit
        System.out.println("What would you like to edit?");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Phone Number");
        System.out.print("Enter the number corresponding to the field: ");
        int choice = keyboard.nextInt();
        keyboard.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = keyboard.nextLine().trim();
                borrowerToEdit.setName(newName);
                System.out.println("Name updated successfully.");
                break;
            case 2:
                System.out.print("Enter new email: ");
                String newEmail = keyboard.nextLine().trim();
                borrowerToEdit.setEmail(newEmail);
                System.out.println("Email updated successfully.");
                break; 
            case 3:
                System.out.print("Enter new phone number: ");
                String newPhoneNum = keyboard.nextLine().trim();
                borrowerToEdit.setPhoneNum(newPhoneNum);
                System.out.println("Phone number updated successfully.");
                break;
            default:
                System.out.println("Invalid option. No changes made.");
                break;       
        }
    }

    public void deleteBorrower() {
        System.out.println("=== Delete Borrower ===");

        System.out.print("Enter the ID of the borrower to delete: ");
        String borrowerID = keyboard.nextLine().trim();

        Borrower borrowerToDelete = null;

        for (Borrower b : borrowers) {
            if (b.getID().equalsIgnoreCase(borrowerID)) {
                borrowerToDelete = b;
                break;
            }
        }

        if (borrowerToDelete == null) {
            System.out.println("Borrower with ID " + borrowerID + " not found.");
            return;
        }

        borrowerToDelete.getBorrowedBooks().clear();

        System.out.println("Borrower found: " + borrowerToDelete.getName());
        System.out.print("Are you sure you want to delete this borrower? (y/n): ");
        String confirm = keyboard.nextLine().trim();

        if (confirm.equalsIgnoreCase("y")) {
            borrowers.remove(borrowerToDelete);
            System.out.println("Borrower deleted successfully.");
        } else {
            System.out.println("Deletion canceled.");
        }
    }

    //---- Book borrowing methods ----
    public void borrowBook() {
        System.out.println("=== Borrow Book ===");

        //Get borrower ID
        System.out.print("Enter Borrower ID: ");
        String borrowerID = keyboard.nextLine().trim();

        //Find borrower
        Borrower borrower = null;
        for (Borrower b : borrowers) {
            if (b.getID().equalsIgnoreCase(borrowerID)) {
                borrower = b;
                break;
            }
        }
        

        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        // Get book ID
        System.out.print("Enter Book ID to borrow: ");
        String bookID = keyboard.nextLine().trim();

        //Find book
        Book bookToBorrow = null;
        for (Book b : books) {
            if (b.getID().equalsIgnoreCase(bookID)) {
                bookToBorrow = b;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!bookToBorrow.availableStatus()) {
            System.out.println("Sorry, this book is checked out.");
            return;
        }

        //Borrow the book
        bookToBorrow.borrowBook();
        borrower.borrowBook(bookToBorrow);

        System.out.println("Book borrowed successfully!");
    }//end borrowbook

    

    public void returnBook(){
        System.out.println("=== Return Book ===");

        // Get borrower ID
        System.out.print("Enter borrower ID: ");
        String borrowerID = keyboard.nextLine().trim();

        //Find borrower
        Borrower borrower = null;
        for (Borrower b : borrowers) {
            if (b.getID().equalsIgnoreCase(borrowerID)) {
                borrower = b;
                break;
            }
        }

        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        //Get book ID
        System.out.print("Enter Book ID to return: ");
        String bookID = keyboard.nextLine().trim();

        //Find the book in the borrower's list
        Book bookToReturn = null;
        for (Book book: borrower.getBorrowedBooks()) {
            if (book.getID().equalsIgnoreCase(bookID)) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("This borrower did not borrow that book.");
            return;
        }

        //Return the book
        bookToReturn.returnBook();
        borrower.returnBook(bookToReturn);

        System.out.println("Book returned successfully!");
    }
}
