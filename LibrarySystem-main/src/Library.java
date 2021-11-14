import java.util.ArrayList;

public class Library {
    private ArrayList<Book> catalogue;

    public Library(ArrayList<Book> list) {
        this.catalogue = list;
    }

    public void addBook(Book newBook) {
        this.catalogue.add(newBook);
    }

    public void removeBook(Book book) {
        this.catalogue.remove(book);
    }

    public void printBooks() {
        for (Book entry : this.catalogue) {
            System.out.println(entry);
        }
    }

    public Book searchByTitle(String title) {
        for (Book book : this.catalogue) {
            if (StringUtils.included(book.getTitle(), title)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        for (Book book : this.catalogue) {
            if (StringUtils.included(book.getAuthor(), author)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByISBN(String ISBN) {
        for (Book book : this.catalogue) {
            if (StringUtils.included(book.getISBN(), ISBN)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> availableBooks() {
        ArrayList<Book> found = new ArrayList<Book>();
        for (Book book : this.catalogue) {
            if (book.status.available) {
                found.add(book);
            }
        }
        return found;
    }

    public ArrayList<Book> booksLoanedOut() {
        ArrayList<Book> found = new ArrayList<>();
        for (Book book : this.catalogue) {
            if (!book.status.available) {
                found.add(book);
            }
        }
        return found;
    }

    public String toString() {
        String allBooks = "";
        for (Book book : this.catalogue) {
            allBooks = allBooks + book.getTitle() + ", " + book.getAuthor() + "\n";
        }
        return allBooks;
    }
    
}
