import java.util.Scanner;

public class LibraryService {
    //Assume lists to store current books and borrowers
    private List<Book> books = new ArrayList<>();
    private List<Borrower> borrowers = new ArrayList<>();
    private int nextBookID = 1;

    private String generateBookID() {
        return "B" + String.format("%03d", nextBookID++);
    }

    //---- Book related methods ----
    public void addBook(Book book) {
        Scanner keyboard = new Scanner(System.in);

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

    public void editBook(Book book) {
        Scanner keyboard = new Scanner(System.in);

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

        System.out.println("Editing Book: " + bookToEdit.getTitle());

        System.out.print("Enter new title (leave blank to keep current): ");
        String newTitle = keyboard.nextLine().trim();
        if (!newTitle.isEmpty()) {
            bookToEdit.setTitle(newTitle);
        }

        System.out.print("Enter new author (leave blank to keep current): ");
        String newAuthor = keyboard.nextLine().trim();
        if (!newAuthor.isEmpty()) {
            bookToEdit.setAuthor(newTitle);
        }

        System.out.print("Enter new genre (leave blank to keep current: )");
        String newGenre = keyboard.nextLine().trim();
        if (!newGenre.isEmpty()) {
            bookToEdit.setGenre(newGenre);
        }

        System.out.println("Book updated successfully!");
    }

    public void deleteBook(Book book) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("=== Delete Book ===");
        
        System.out.print("Enter the ID of the book to delete: ");
        String id = keyboard.nextLine().trim();

        Book bootToDelete = null;

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
