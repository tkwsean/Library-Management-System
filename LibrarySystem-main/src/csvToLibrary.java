import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class csvToLibrary {
    ArrayList<String[]> columns = new ArrayList<String[]>();
    int numberOfColumns = 0;
    ArrayList<Book> allBooks = new ArrayList<Book>();

    public csvToLibrary(File inputfile) {
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

        for (String[] bookInfo : columns) {
            if (bookInfo.length >= 5) {
                String name = bookInfo[0];
                String author = bookInfo[1];
                String ISBN = bookInfo[2];
                String status = bookInfo[3];
                String retDate = bookInfo[4];

                Book book = new Book(name, author, ISBN, new Status(Boolean.parseBoolean(status), retDate));
                allBooks.add(book);
            }
        }
    }
}
