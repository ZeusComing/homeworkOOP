import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Group implements Voenkomat {
    private Student[] group = new Student[10];
    private int count = 0;

    public Student[] getGroup() {
        return group;
    }

    public int getCount() {
        return count;
    }

    public void addToGroup(Student student) {
        try {
            if (student == null) {
                throw new IllegalArgumentException("Sorry");
            } else if (count > 9) {
                throw new MyException();
            } else {
                for (int i = 0; i < group.length; i++) {
                    if (group[i] == null) {
                        group[i] = student;
                        System.out.println(student.getFirstName() + " " +
                                student.getLastName() + " is added to group");
                        count++;
                        break;
                    }
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToGroupInteractive() {
        addToGroup(newStudent());
    }

    public void removeStudentFromGroup (Student student) {
        for (int i = 0; i < group.length; i++) {
            if (group[i].equals(student)) {
                count--;
                group[i] = group[count];
                group[count] = null;
                System.out.println("Student " + student.getLastName() +
                        " removed from group. " + "Now group have " + (group.length - count) +
                        " slot(s).");
                break;
            }
        }
    }

    public Student searchStudent(String lastName) {
        for (int i = 0; i < count; i++) {
            if (group[i].getLastName() == lastName) {
                return group[i];
                }
            }
        System.out.println(lastName + " not in the group");
        return null;
    }

    public void sortByParameter() {
        System.out.println("Avaliable parameters: first name, last name, age, course");
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine().toLowerCase();
        switch (p) {
            case ("first name"):
                Arrays.sort(group, 0, count - 1, (studentOne, studentTwo) ->
                        studentOne.getFirstName().compareTo(studentTwo.getFirstName()));
                break;
            case ("last name"):
                Arrays.sort(group, 0, count - 1, (studentOne, studentTwo) ->
                        studentOne.getLastName().compareTo(studentTwo.getLastName()));
                break;
            case ("age"):
                Arrays.sort(group, 0, count - 1, (studentOne, studentTwo) ->
                        studentOne.getAge() - studentTwo.getAge());
                break;
            case ("course"):
                Arrays.sort(group, 0, count - 1, (studentOne, studentTwo) ->
                        studentOne.getCourse() - studentTwo.getCourse());
                break;
            default:
                System.out.println("Wrong parameter");


        }
    }

    @Override
    public String toString() {
        Arrays.sort(group, 0, count-1);
        StringBuilder stringBuilder = new StringBuilder("Students list: \n");
        for (int i = 0; i < count; i++) {
            stringBuilder.append(group[i].getLastName() + "\n");
        }
        String result = stringBuilder.toString();
        return result;
    }

    private Student newStudent() {
        String firstName;
        String lastName;
        int age;
        String sex;
        int course;
        String faculty;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name");
        for (;;) {
            firstName = scanner.nextLine() ;
            if (firstName.length() >= 1) {
                break;
            }
        }
        System.out.println("Enter last name");
        for (;;) {
            lastName = scanner.nextLine();
            if (lastName.length() >= 1) {
                break;
            }
        }
        System.out.println("Enter age");
        for (;;) {
            try {
                age = (int) scanner.nextDouble();
                if (age >= 1) {
                    break;
                }
                System.out.println("Age can't be 0 or negative");
            } catch (InputMismatchException e) {
                System.out.println("It's not number");
                scanner.skip(".*");
            }
        }
        System.out.println("Enter sex (male/female)");
        for (;;) {
            sex = scanner.nextLine();
            if (sex.equals("male") || sex.equals("female")) {
                break;
            }
            System.out.println(" \"male\" or \"female\"");
        }
        System.out.println("Enter course");
        for (;;) {
            try {
                course = (int) scanner.nextDouble();
                if ((course >= 1) && (course <= 6)) {
                    break;
                }
                System.out.println("Course can't be negative or bigger then 6");
            } catch (InputMismatchException e) {
                System.out.println("It's not number");
                scanner.skip(".*");
            }
        }
        System.out.println("Enter faculty");
        for (;;) {
            faculty = scanner.nextLine();
            if (faculty.length() > 0) {
                break;
            }
        }
        return new Student(firstName, lastName, age, sex, course, faculty);
    }
}
