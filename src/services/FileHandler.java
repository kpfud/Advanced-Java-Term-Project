import java.io;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String BOOK_FILE = "Books.txt";
    private static final String BORROWER_FILE = "Borrowers.txt";

    //---- Save Methods ----
    public void saveBooks(List<Book> books) {
        //write book info to book file
    }

    public void saveBorrowers(List<Borrower> borrowers) {
        //writes borrower info to borrower file
    }

    //---- Load methods ----
    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        //reads from book file and reconstructs book objects
        return books;
    }

    public List<Borrower> loadBorrowers() {
        List<Borrower> borrowers = new ArrayList<>();
        //read from borrower file and reconstructs borrower objects
        return borrowers;
    }
}
