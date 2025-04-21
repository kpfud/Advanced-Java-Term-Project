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
    public void addBook() {
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

    public void editBook() {
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

    public void deleteBook() {
        Scanner keyboard = new Scanner(System.in);

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

    public List<Book> searchBooks(String keyword) {
        //returns books matching keyword
        return new ArrayList<>();
    }

    public List<Book> filterByAvailability() {
        //return only books that aren't being borrowed
        return new ArrayList<>();
    }

    //---- Borrower related methods -----
    public String generateBorrowerID() {
        return "P" + String.format("%03d", borrowers.size() + 1);
    }

    public void addBorrower() {
        Scanner keyboard = new Scanner(System.in);

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
        Scanner keyboard = new Scanner(System.in);

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
            system.out.println("Borrower with ID " + borrowerID + " not found.");
            return;
        }

        //Display current borrower info
        System.out.println("Current Borrower Information:");
        System.out.println("Name: " + borrowerToEdit(getName());
        System.out.println("Email: " + borrowerToEdit.getEmail());
        System.out.println("Phone Number: " + borrowerToEdit.getPhoneNum());

        //Prompt for which field to edit
        System.out.println("What would you like to edit?");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Phone Number");
        System.out.print("Enter the number corresponding to the field: ");
        int choice = keyboard.nextInt();

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
                System.out.println("Phone number updated successfully.");
                break;
            default:
                System.out.println("Invalid option. No changes made.");
                break;       
        }
    }

    public void deleteBorrower() {
        Scanner keyboard = new Scanner(System.in);

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
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("y")) {
            borrowers.remove(borrowerToDelete);
            System.out.println("Borrower deleted successfully.");
        } else {
            System.out.println("Deletion canceled.");
        }
    }

    //---- Book borrowing methods ----
    public void borrowBook(Book book, Borrower borrower) {
        //calls book.borrowBook() and borrower.borrowBook()
    }

    public void returnBook(Book book, Borrower borrower){
        // calls book.returnBook() and borrower.returnBook()
    }
}
