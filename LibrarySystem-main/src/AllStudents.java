import java.util.ArrayList;

public class AllStudents {
    ArrayList<Student> students;

    public AllStudents(ArrayList<Student> list) {
        this.students = list;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (Student student : students) {
            list.append(student).append("\n");
        }
        return list.toString();
    }

    public Student searchStudent(String username) {
        for (Student student : students) {
            if (student.username.equals(username)) {
                return student;
            }
        }
        return null;
    }

    public void addStudent(String name, String username, String password) {
        ArrayList<Book> tempBL = new ArrayList<>();
        BookList newBookList = new BookList(tempBL);
        Student newStudent = new Student(name, username, password, newBookList);
        students.add(newStudent);
    }
}
