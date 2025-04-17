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
        //this will simply loop until valid input is taken. You literally CANNOT enter invalid input.
        do 
        {
            System.out.println("\f" + "Enter a number to select from the menu.");
            System.out.println("0 - Exit Program\n" + 
				            "1 - Add or Edit a Book\n" +
              			"2 - Access or Save to File\n" + 
				            "3 - Search For Books\n" +
              			"4 - Borrow or Return Books\n"+
				            "5 - Register, Update, or Delete Borrowers");
            exit = keyboard.nextInt();
            
            //case for each possible input
            switch(exit)
            {
                case 0 -> {break;} //just exit
                case 1 -> {//Add or edit books, call method to get user choices
                    break;
                } 
                case 2 -> {//access or save to file, once again, get user choice
                    break;
                } 
                case 3 -> {//search books by title, author, or genre, easiest to get user choice and then search
                    break;
                } 
                case 4 -> {//borrow or return books for borrowers
                    break;
                } 
                case 5 -> {//manipulate the list of borrowers
                    break;
                } 
                default -> //default is essentially for invalid input
                    System.out.println("INVALID INPUT. Please enter an integer from #-# (inclusive)");
            }// end switch statement
        }    
        while(!(exit == 0)); //repeat this until user enters '0' to exit
    }
}
