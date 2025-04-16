public class LibraryService {
    
    //Assume lists to store current books and borrowers
    private List<Book> books = new ArrayList<>();
    private List<Borrower> borrowers = new ArrayList<>();

    //---- Book related methods ----
    public void addBook(Book book) {
        //adds books to list
    }

    public void editBook(Book book) {
        //updates existing book info
    }

    public void deleteBook(Book book) {
        // remove books from list
    }

    public List<Book> searchBooks(String keyword) {
        //returns books matching keyword
        return new ArrayList<>();
    }

    public List<Book> filterByAvailability() {
        //return only books that aren't being borrowed
        return new ArrayList<>();
    }

    //---- Borrower related methods -----
    public void addBorrower(Borrower borrower) {
        //adds borrowers to list
    }

    public void deleteBorrower(Borrower borrower) {
        //removes borrowers from list
    }

    //---- Book borrowing methods ----
    public void borrowBook(Book book, Borrower borrower) {
        //calls book.borrowBook() and borrower.borrowBook()
    }

    public void returnBook(Book book, Borrower borrower){
        // calls book.returnBook() and borrower.returnBook()
    }
}
