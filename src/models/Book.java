public class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true; // Default to available
    }

    public void borrowBook() {this.isAvailable = false;}
    public void returnBook() {this.isAvailable = true;}

    public String toString() {
        return id + "-" + title + " by " + author + " [" + (isAvailable?"Available":"Borrowed") + "]";
    }
}
