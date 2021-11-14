import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    File books = new File("Book.csv");
    csvToLibrary myCVS = new csvToLibrary(books);
    ArrayList<Book> bks = myCVS.allBooks;

    File students = new File("Students.csv");
    csvToStudents myCVS2 = new csvToStudents(students);
    ArrayList<Student> stus = myCVS2.allStudents;

    AllStudents allStudents = new AllStudents(stus);
    Library ourLibrary = new Library(bks);

    Student currentStudent;
    Book currentBook;

    Status emptyStatus = new Status(true, "");
    Student emptyStudent = new Student("", "", null, null);

    public Main() {
        ArrayList<Book> emptyArray = new ArrayList<Book>();
        BookList emptyBookList = new BookList(emptyArray);

        currentStudent = null;

        System.out.println("If you are an existing user enter '1', if you are a new user enter '2': ");

        int choice1 = sc.nextInt();
        if (choice1 == 1) {
            System.out.println("Enter username: ");
            String username = sc.next();

            if (allStudents.searchStudent(username).equals(null)) {
                System.out.println("User does not exist!");
                menu();
            } else
                currentStudent = allStudents.searchStudent(username);

            System.out.println("Enter password: ");

            String password = sc.next();

            if (!currentStudent.password.equals(password)) {
                System.out.println("Incorrect password!");
            }
            menu();
        } else if (choice1 == 2) {
            System.out.println("Enter your name: ");
            String name = sc.next();

            System.out.println("Enter desired username: ");
            String username = sc.next();

            if (allStudents.students.contains(allStudents.searchStudent(username))) {
                System.out.println("Username is not unique!");
                menu();
            }
            System.out.println("Enter desired password: ");
            String password = sc.next();

            allStudents.addStudent(name, username, password);

            currentStudent = allStudents.searchStudent(username);

        }
        menu();
    }

    public void menu() {
        System.out.println("What would you like to do? Press '1' to look up a book,"
                + " '2' see a list of my books, '3' view all available books: ");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                search();
                break;
            case 2:
                seeMyBooks();
                break;
            case 3:
                seeAllAvailableBooks();
                break;
        }
    }

    public void search() {
        System.out.println("Enter '1' to search by book name, '2' by author name, and '3' by ISBN: ");

        int toSearchBy = sc.nextInt();

        Book currentBook = null;

        if (toSearchBy == 1) {
            System.out.println("What is the name of the book?");
            String bookName = sc.next();
            currentBook = ourLibrary.searchByTitle(bookName);
        }
        if (toSearchBy == 2) {
            System.out.println("What is the author of the book: ");
            String authorName = sc.next();
            currentBook = ourLibrary.searchByAuthor(authorName);
        }
        if (toSearchBy == 3) {
            System.out.println("What is the ISBN: ");
            String ISBN = sc.next();
            currentBook = ourLibrary.searchByISBN(ISBN);
        }

        System.out.println(currentBook);

        System.out.println("Would you like to check it out? Y/N: ");
        String checkOut = sc.next();
        if (checkOut.equals("Y")) {
            System.out.println("How long do you want to check it out? Enter date (mm/dd/yyyy): ");
            String lengthOfTime = sc.next();

            currentBook.loanBook(lengthOfTime); // library class
            currentStudent.booklist.addToList(currentBook);
            menu();
        } else {
            menu();
        }
    }

    public void seeMyBooks() {
        BookList myBooks = currentStudent.booklist;
        System.out.println("myBOOKS");

        if (currentStudent.booklist != null) {
            for (Book b : currentStudent.booklist.list) {
                if (b == null) {
                    //continue
                } else {
                    System.out.print(b + "");
                }
            }
        }

    }

    public void seeAllAvailableBooks() {
        for (Book b : ourLibrary.availableBooks()) {
            System.out.println(b + "");
        }
        menu();
    }

    public static void main(String[] args) {
        Main test = new Main();
        System.out.println(test.currentStudent);
    }
}
