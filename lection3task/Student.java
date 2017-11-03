import java.io.Serializable;
import java.util.Scanner;

public class Student extends Human implements Comparable<Student>, Serializable {
    private int course;
    private String faculty;

    public Student(String firstName, String lastName, int age, String sex, int course, String faculty) {
        super(firstName, lastName, age, sex);
        this.course = course;
        this.faculty = faculty;
    }

    public Student() {
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course='" + course + '\'' +
                ", faculty='" + faculty + '\'' +
                '}' + super.toString();
    }
    public String setLastName() {
        String lastName = inputLine();
        return lastName;
    }

    private String inputLine() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        return line;
    }
    @Override
    public int compareTo(Student o) {
        return this.getLastName().compareTo(o.getLastName());
    }
}
