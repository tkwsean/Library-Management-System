public class Student {
    String name;
    String username;
    String password;
    BookList booklist;

    public Student(String name, String username, String password, BookList booklist) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.booklist = booklist;
    }

    public void printStudentStatus() {
        System.out.println("Name: " + name);
        System.out.println("Books on loan: ");
        booklist.printStatus();
    }

    public String toString() {
        return name + ", Number of books on loan: " + booklist.getSize();
    }
}
