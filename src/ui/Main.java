//imports 
//apparently, imports in the same package don't need to be imported for other classes...?
//That's what I read but idk. Doesn't seem to work for me.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("LIBRARY MANAGEMENT SYSTEM");

        //testing things
        //I plan to make a simple, reusable list to test sorting algorithms
        //and other features
        Book testbook = new Book();
        Borrower testborrow = new Borrower();

        //user input stuff
        Scanner keyboard = new Scanner(System.in);
        int exit = -1; //exit when user says to
        do {
            System.out.println("\f" + "Enter a number to select from the menu.");
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
                    break;
                } //just exit
                case 1 -> {//Add or edit books, call method to get user choices
                    AlterBooks();
                }
                case 2 -> {//access or save to file, once again, get user choice
                    AlterFiles();
                }
                case 3 -> {//search books by title, author, or genre, easiest to get user choice and then search
                    SearchBooks();
                }
                case 4 -> {//borrow or return books for borrowers
                    BorrowedBooks();
                }
                case 5 -> {//manipulate the list of borrowers
                    AlterBorrower();
                }
                default -> //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-5 (inclusive)");
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }

    static void AlterBooks() {//user choice to add, edit, or delete book
        Scanner keyboard = new Scanner(System.in);

        LibraryService ls = new LibraryService(); //needed to reference non-static context

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
                    ls.addBook();
                }
                case 2 -> {//edit book
                    ls.editBook();
                }
                case 3 -> {//delete book
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
    static void AlterFiles() {//user choice to access or save file
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
                    fh.saveBooks(books);
                    fh.saveBorrowers(borrowers);
                }
                case 2 -> {//Load
                    fh.loadBooks();
                    fh.loadBorrowers();
                }
                default -> { //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-2 (inclusive)");
                }
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }//end ALTERFILES

    //INCOMPLETE//
    //need to access main arraylist to search for books... I think.
    //also need three different search algorithms for title, author, & genre... maybe
    //also some way to avoid "EXACT REQUIREMENTS" for searching...
    //maybe add some extra validation for keywords
    static void SearchBooks() {//user choice to search Books by title, author, genre
        Scanner keyboard = new Scanner(System.in);

        LibraryService ls = new LibraryService(); //needed to reference non-static context
        
        System.out.print("Please enter the keyword(s) you're searching for: ");
        String keyword = keyboard.nextLine();

        int exit = -1; //exit when user says to
        do {
            System.out.println("You're looking for: '" + keyword + "'");
            System.out.println("\nAre you searching for a book title, author, or genre?");
            System.out.println("0 - Return to Menu\n"
                    + "1 - Search by Title\n"
                    + "2 - Search by Author\n"
                    + "3 - Search by Genre\n");
            exit = keyboard.nextInt();

            //case for each possible input
            switch (exit) {
                case 0 -> {
                    return;
                } //just exit
                case 1 -> {//Title
                    ls.searchBooks(keyword);
                }
                case 2 -> {//Author
                    ls.searchBooks(keyword);
                }
                case 3 -> {//Genre
                    ls.searchBooks(keyword);
                }
                default -> { //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-3 (inclusive)");
                }
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }//end SEARCHBOOKS

    //INCOMPLETE//
    //This method needs to find a borrower, then an existing book,
    //then update the library's and the borrower's books...
    static void BorrowedBooks() {//user choice to borrow OR return borrowed books
        Scanner keyboard = new Scanner(System.in);

        LibraryService ls = new LibraryService(); //needed to reference non-static context

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
                case 1 -> {//Add borrower
                    ls.borrowBook();
                }
                case 2 -> {//edit borrower
                    ls.returnBook();
                }
                default -> { //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-2 (inclusive)");
                }
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }//end BORROWEDBOOKS

    static void AlterBorrower() {//user choice to add, edit, or delete borrowers
        Scanner keyboard = new Scanner(System.in);

        LibraryService ls = new LibraryService(); //needed to reference non-static context

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
                    ls.addBorrower();
                }
                case 2 -> {//edit borrower
                    ls.editBorrower();
                }
                case 3 -> {//delete borrower
                    ls.deleteBorrower();
                }
                default -> {//default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from 0-3 (inclusive)");
                }
            }// end switch statement
        } while (!(exit == 0)); //repeat this until user enters '0' to exit
    }//end ALTERBORROWER
}//end MAIN
