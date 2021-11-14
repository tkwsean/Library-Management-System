import java.util.ArrayList;

public class BookList {
    ArrayList<Book> list;

    public BookList(ArrayList<Book> books) {
        this.list = books;
    }

    public int getSize() {
        return list.size();
    }

    public void addToList(Book book) {
        list.add(book);
    }

    public void printStatus() {
        if (!list.isEmpty()) {
            for (Book book : list) {
                System.out.println(book);
                System.out.println("\n Remember to return your books on time!");
            }
        } else {
            System.out.println("You do not have any books on loan currently.");
        }
    }
}
