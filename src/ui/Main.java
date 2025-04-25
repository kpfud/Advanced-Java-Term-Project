import services.LibraryService;
import services.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        LibraryService libServe = new LibraryService(); //our library service
        //contains books and borrowers
        //will be used throughout system

        //user input stuff
        Scanner keyboard = new Scanner(System.in);
        int exit = -1; //exit when user says to
        do {
            System.out.println("\n\f\nEnter a number to select from the menu.");
            System.out.println("0 - Exit Program\n"
                    + "1 - Add or Edit a Book\n"
                    + "2 - Access or Save to File\n"
                    + "3 - Search For Books\n"
                    + "4 - Borrow or Return Books\n"
                    + "5 - Register, Update, or Delete Borrowers");
            exit = keyboard.nextInt();

            //case for each possible input
            switch (exit) {
                case 0 -> {
                    System.out.println("EXITING...");
                    break;
                } //just exit
                case 1 -> {//Add or edit books, call method to get user choices
                    System.out.println("YOU CHOSE TO ADD/EDIT BOOKS...");
                    AlterBooks(libServe);
                }
                case 2 -> {//access or save to file, once again, get user choice
                    System.out.println("YOU CHOSE TO LOAD/SAVE FILES...");
                    AlterFiles(libServe);
                }
                case 3 -> {//search books by title, author, or genre, easiest to get user choice and then search
                    System.out.println("YOU CHOSE TO SEARCH BOOKS...");
                    SearchBooksMenu(libServe);
                }
                case 4 -> {//borrow or return books for borrowers
                    System.out.println("YOU CHOSE TO BORROW/RETURN BOOKS...");
                    BorrowedBooks(libServe);
                }
                case 5 -> {//manipulate the list of borrowers
                    System.out.println("YOU CHOSE TO ADD/EDIT BORROWERS...");
                    AlterBorrower(libServe);
                }
                default -> //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-5 (inclusive)");
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }

    //should function//
    static void AlterBooks(LibraryService ls) {//user choice to add, edit, or delete book
        Scanner keyboard = new Scanner(System.in);
        int exit = -1; //exit when user says to
        do {
            System.out.println("\nWould you like to add, edit, or delete a book?");
            System.out.println("0 - Return to Menu\n"
                    + "1 - Add a Book\n"
                    + "2 - Edit a Book\n"
                    + "3 - Delete a Book");
            exit = keyboard.nextInt();

            //case for each possible input
            switch (exit) {
                case 0 -> {
                    return;
                } //just exit
                case 1 -> {//Add book
                    System.out.println("ADDING BOOK...");
                    ls.addBook();
                }
                case 2 -> {//edit book
                    System.out.println("EDITING BOOK...");
                    ls.editBook();
                }
                case 3 -> {//delete book
                    System.out.println("DELETING BOOK...");
                    ls.deleteBook();
                }
                default -> { //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-3 (inclusive)");
                }
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }//end ALTERBOOKS

    //INCOMPLETE//
    //need to access the main arraylist of books or borrowers for save/load!
    //before this will work
    //also, maybe have a choice to save/load Borrowers OR Books. Currently it does both.
    static void AlterFiles(LibraryService ls) {//user choice to access or save file
        Scanner keyboard = new Scanner(System.in);

        FileHandler fh = new FileHandler(); //needed to reference non-static context

        int exit = -1; //exit when user says to
        do {
            System.out.println("\nWould you like to save to or load from a file?");
            System.out.println("0 - Return to Menu\n"
                    + "1 - Save to File\n"
                    + "2 - Load to File\n");
            exit = keyboard.nextInt();

            //case for each possible input
            switch (exit) {
                case 0 -> {
                    return;
                } //just exit
                case 1 -> {//Save
                    System.out.println("SAVING...");
                    fh.saveBooks(ls.getBooks());
                    fh.saveBorrowers(ls.getBorrowers());
                }
                case 2 -> {//Load
                    System.out.println("LOADING...");
                    fh.loadBooks();
                    fh.loadBorrowers();
                }
                default -> { //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-2 (inclusive)");
                }
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }//end ALTERFILES

    //should function//
    static void SearchBooksMenu(LibraryService ls) {//user choice to search Books by title, author, genre
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the keyword(s) you're searching for: ");
        String keyword = keyboard.nextLine();

        ls.searchBooks(keyword); //searches and displays found books, if any
        
    }//end SEARCHBOOKS

    //INCOMPLETE//
    //This method needs to find a borrower, then an existing book,
    //then update the library's and the borrower's books...
    static void BorrowedBooks(LibraryService ls) {//user choice to borrow OR return borrowed books
        Scanner keyboard = new Scanner(System.in);
        int exit = -1; //exit when user says to
        do {
            System.out.println("\nWould you like Borrow or Return a book?");
            System.out.println("0 - Return to Menu\n"
                    + "1 - Borrow a Book\n"
                    + "2 - Return a Book\n");
            exit = keyboard.nextInt();

            //case for each possible input
            switch (exit) {
                case 0 -> {
                    return;
                } //just exit
                case 1 -> {//borrow a book
                    System.out.println("BORROWING...");
                    //ls.borrowBook();
                }
                case 2 -> {//return a book
                    System.out.println("RETURNING...");
                    //ls.returnBook();
                }
                default -> { //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-2 (inclusive)");
                }
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }//end BORROWEDBOOKS

    static void AlterBorrower(LibraryService ls) {//user choice to add, edit, or delete borrowers
        Scanner keyboard = new Scanner(System.in);
        int exit = -1; //exit when user says to
        do {
            System.out.println("\nWould you like to add, edit, or delete a borrower?");
            System.out.println("0 - Return to Menu\n"
                    + "1 - Add a Borrower\n"
                    + "2 - Edit a Borrower\n"
                    + "3 - Delete a Borrower");
            exit = keyboard.nextInt();

            //case for each possible input
            switch (exit) {
                case 0 -> {
                    return;
                } //just exit
                case 1 -> {//Add borrower
                    System.out.println("ADDING BORROWER...");
                    ls.addBorrower();
                }
                case 2 -> {//edit borrower
                    System.out.println("EDITING BORROWER...");
                    ls.editBorrower();
                }
                case 3 -> {//delete borrower
                    System.out.println("DELETING BORROWER...");
                    ls.deleteBorrower();
                }
                default -> {//default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-3 (inclusive)");
                }
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }//end ALTERBORROWER
}//end MAIN
