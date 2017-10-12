import java.util.Arrays;

public class Group {
    private Student[] group = new Student[10];
    private int count = 0;

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
                        System.out.println(student.getFirstName() +
                                student.getLastName() +
                                " is added to group");
                        count++;
                        break;
                    }
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
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
}
