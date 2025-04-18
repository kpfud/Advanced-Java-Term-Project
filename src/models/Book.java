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

    //Getters
    public String getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
    
    public boolean availableStatus() {
        return isAvailable;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void borrowBook() {this.isAvailable = false;}
    public void returnBook() {this.isAvailable = true;}

    public String toString() {
        return id + "-" + title + " by " + author + " [" + (isAvailable?"Available":"Borrowed") + "]";
    }
}
