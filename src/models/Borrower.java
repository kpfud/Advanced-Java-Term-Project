public class Borrower {
    private String id;
    private String name;
    Private String email;
    private String phoneNum;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Borrower(String id, String name, String email, String phoneNum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }
 
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    } 

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " email + "\nPhone" + phoneNum +
                "\nBorrowed Books: " + borrowedBooks.size();
    }
}
