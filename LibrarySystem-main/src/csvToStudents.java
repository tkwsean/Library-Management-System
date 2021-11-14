import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class csvToStudents {
    ArrayList<String[]> columns = new ArrayList<String[]>();
    int numberOfColumns = 0;

    ArrayList<Book> allBooks = new ArrayList<Book>();
    ArrayList<Student> allStudents = new ArrayList<Student>();
    AllStudents listStu = new AllStudents(new ArrayList<Student>());

    File books = new File("Book.csv");
    csvToLibrary myCVS = new csvToLibrary(books);
    ArrayList<Book> bks = myCVS.allBooks;

    Library ourBooks = new Library(bks);

    public csvToStudents(File inputfile) {
        try {
            Scanner in = new Scanner(inputfile);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] row = line.split(",");
                int numOfEntries = 0;

                for (int i = 0; i < row.length; i++) {
                    if (!row[i].isEmpty() && !row[i].equals(" "))
                        numOfEntries++;
                }

                String[] fullRow = new String[numOfEntries];

                for (int i = 0; i < numOfEntries; i++) {
                    fullRow[i] = row[i];
                }
                if (fullRow.length != 0) {
                    numberOfColumns = fullRow.length;
                    columns.add(fullRow);
                }
            }
            in.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        for (String[] stuInfo : columns) {
            if (stuInfo.length >= 2) {
                String name = stuInfo[0];
                String username = stuInfo[1];
                String password = stuInfo[2];
                String bl = stuInfo[3];

                if (!bl.equals(null)) {
                    String[] bookNames = bl.split("|");

                    for (int i = 0; i < bookNames.length; i++) {
                        allBooks.add(ourBooks.searchByTitle(bookNames[i]));
                    }
                } else
                    allBooks = null;

                BookList myBookList = new BookList(allBooks);
                Student st = new Student(name, username, password, myBookList);
                allStudents.add(st);

            }
            listStu = new AllStudents(allStudents);
        }
    }
}
