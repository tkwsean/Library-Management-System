public class Book {
    String title;
    String author;
    String ISBN;
    String lendingID;
    Status status;

    public Book(String title, String author, String ISBN, Status status) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getLendingID() {
        return this.lendingID;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public Status getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return this.title + ", " + this.author;
    }

    public void loanBook(String date) {
        this.status.available = false;
        this.status.returnDate = date;
    }
}
