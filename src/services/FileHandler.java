//imports
package services;

import models.Book;
import models.Borrower;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String BOOK_FILE = "../data/books.txt";
    private static final String BORROWER_FILE = "../data/borrowers.txt";

    //---- Save Methods ----
    public void saveBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book book : books) {
                String line = String.join("~",
                    book.getID(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    String.valueOf(book.availableStatus())
                );
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Books saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public void saveBorrowers(List<Borrower> borrowers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BORROWER_FILE))) {
            for (Borrower borrower : borrowers) {
                StringBuilder borrowedBookIDs = new StringBuilder();
                for (Book book : borrower.getBorrowedBooks()) {
                    borrowedBookIDs.append(book.getID()).append(",");
                }

                // remove trailing comma
                if (borrowedBookIDs.length() > 0) {
                    borrowedBookIDs.deleteCharAt(borrowedBookIDs.length() - 1);
                }

                String line = String.join("~",
                    borrower.getID(),
                    borrower.getName(),
                    borrower.getEmail(),
                    borrower.getPhoneNum(),
                    borrowedBookIDs.toString()
                );
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Borrowers saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving borrowers: " + e.getMessage());
        }
    }

    //---- Load methods ----
    public List<Book> loadBooks(List<Book> books) {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("~");
                if (parts.length == 5) {
                    String id = parts[0];
                    String title = parts[1];
                    String author = parts[2];
                    String genre = parts[3];
                    boolean isAvailable = Boolean.parseBoolean(parts[4]);

                    Book book = new Book(id, title, author, genre, isAvailable);
                    books.add(book);
                }
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
        return books;
    }

    public List<Borrower> loadBorrowers(List<Book> allBooks) {
        List<Borrower> borrowers = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(BORROWER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("~");
                if (parts.length == 5) {
                    String id = parts[0];
                    String name = parts[1];
                    String email = parts[2];
                    String phoneNum = parts[3];
                    String[] bookIDs = parts[4].split(",");

                    Borrower borrower = new Borrower(id, name, email, phoneNum);

                    for (String bookID : bookIDs) {
                        for (Book book : allBooks) {
                            if (book.getID().equalsIgnoreCase(bookID.trim())) {
                                borrower.borrowBook(book);
                                break;
                            }
                        }
                    }

                    borrowers.add(borrower);
                }
            }
            System.out.println("Borrowers loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading borrowers: " + e.getMessage());
        }
        return borrowers;
    }
}
