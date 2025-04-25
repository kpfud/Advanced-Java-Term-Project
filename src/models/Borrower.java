package models;

import java.util.List;
import java.util.ArrayList;

public class Borrower {
    private String id;
    private String name;
    private String email;
    private String phoneNum;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Borrower(String id, String name, String email, String phoneNum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    //Getters and Setters
    public String getID() { return id; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPhoneNum() { return phoneNum; }

    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void setName(String name) { this.name = name; }

    public void setEmail(String email) { this.email = email; }

    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
 
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    } 

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nPhone" + phoneNum +
                "\nBorrowed Books: " + borrowedBooks.size();
    }
}
