import java.io.*;
import java.util.*;

public class Group implements Voenkomat, Serializable {
    private List<Student> group = new ArrayList<>();

    public List<Student> getGroup() {
        return group;
    }

    public int getCount() {
        return group.size();
    }

    public void addToGroup(Student student) {
        try {
            if (student == null) {
                throw new IllegalArgumentException("Sorry");
            } else if (group.size() > 9) {
                throw new MyException();
            } else {
                group.add(student);
                System.out.println(student.getFirstName() + " "
                        + student.getLastName() + " is added to group");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToGroupInteractive() {
        addToGroup(new Student(setFirstName(), setLastName(), setAge(),
                setSex(), setCourse(), setFaculty()));
    }

    public void removeStudentFromGroup (Student student) {
        group.remove(student);
        System.out.println("Student " + student.getLastName()
                + " removed from group. " + "Now group have "
                + (10 - group.size()) + " slot(s).");
    }

    public Student searchStudent(String lastName) {
        for (int i = 0; i < group.size(); i++) {
            if (group.get(i).getLastName() == lastName) {
                return group.get(i);
                }
            }
        System.out.println(lastName + " not in the group");
        return null;
    }

    public void sortByParameter() {
        System.out.println("Avaliable parameters: first name, last name, age, course");
        String p = inputLine().toLowerCase();
        switch (p) {
            case ("first name"):
                Collections.sort(group, (studentOne, studentTwo) ->
                        studentOne.getLastName().compareTo(studentTwo.getLastName()));
                break;
            case ("last name"):
                Collections.sort(group, (studentOne, studentTwo) ->
                        studentOne.getLastName().compareTo(studentTwo.getLastName()));
                break;
            case ("age"):
                Collections.sort(group, (studentOne, studentTwo) ->
                        studentOne.getAge() - studentTwo.getAge());
                break;
            case ("course"):
                Collections.sort(group, (studentOne, studentTwo) ->
                        studentOne.getCourse() - studentTwo.getCourse());
                break;
            default:
                System.out.println("Wrong parameter");
        }
    }

    @Override
    public String toString() {
        Collections.sort(group, (studentOne, studentTwo) ->
                studentOne.getLastName().compareTo(studentTwo.getLastName()));
        StringBuilder stringBuilder = new StringBuilder("Students list: \n");
        for (int i = 0; i < group.size(); i++) {
            stringBuilder.append(group.get(i).getLastName() + "\n");
        }
        String result = stringBuilder.toString();
        return result;
    }

    private String setFirstName() {
        String firstName;
        System.out.println("Enter first name");
        firstName = inputLine();
        return firstName;
    }

    private String setLastName() {
        String lastName;
        System.out.println("Enter last name");
        lastName = inputLine();
        return lastName;
    }

    private int setAge() {
        int age;
        System.out.println("Enter age");
        age = (int) inputNumber();
        return age;
    }

    private String setSex() {
        String sex;
        System.out.println("Enter sex (male/female)");
        for (;;) {
            sex = inputLine().toLowerCase();
            if (sex.equals("male") || sex.equals("female")) {
                break;
            }
            System.out.println(" \"male\" or \"female\"");
        }
        return sex;
    }

    private int setCourse() {
        int course;
        System.out.println("Enter course");
        for (;;) {
            course = (int) inputNumber();
            if (course <= 6) {
                break;
            } else {
                System.out.println("Course can't be higher then 6");
            }
        }
        return course;
    }

    private String setFaculty() {
        String faculty;
        System.out.println("Enter faculty");
        faculty = inputLine();
        return faculty;
    }

    private String inputLine() {
        String line;
        Scanner sc = new Scanner(System.in);
        for (;;) {
            line = sc.nextLine() ;
            if (line.length() >= 1) {
                break;
            }
        }
        return line;
    }

    private double inputNumber() {
        double number;
        Scanner sc = new Scanner(System.in);
        for (;;) {
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Can't be negative or 0");
                }
            } catch (InputMismatchException e) {
                sc.skip(".*");
                System.out.println("It's not number");
            }
        }
        return number;
    }
}
