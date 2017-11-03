import java.io.*;

public class FileOperations {

    public static void writeToFile(String text, File file) {
        try (PrintWriter printWriter = new PrintWriter(
                                        new FileOutputStream(file, true))) {
            printWriter.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String[] getStringArray(File file) {
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String resultString = "";
                for (String text = ""; (text = br.readLine()) != null; ) {
                    resultString += text + "\n";
                }
                String[] result = resultString.split("\n");
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Student[] getStudents(String[] students) {
        Student[] result = new Student[students.length];
        for (int i = 0; i < students.length ; i++) {
            result[i] = getStudent(students[i]);
        }
        return result;
    }

    public static Student getStudent(String studentParameters) {
        Student student = new Student();
        String[] parameters = studentParameters.split("[- ,;:.!?\\s]+");
        student.setFirstName(parameters[0]);
        student.setLastName(parameters[1]);
        student.setAge(Integer.parseInt(parameters[2]));
        student.setSex(parameters[3]);
        student.setCourse(Integer.parseInt(parameters[4]));
        student.setFaculty(parameters[5]);
        return student;
    }

    public static Group toGroup(File file) {
        Group g = new Group();
        String [] stringArray = getStringArray(file);
        Student[] students = getStudents(stringArray);
        for (int i = 0; i <students.length ; i++) {
            g.addToGroup(students[i]);
        }
        return g;
    }

    public static void toFile(Student[] group, String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("File create error");
        }
        for (Student student : group) {
            if (student != null) {
                writeToFile(student.toString(), file);
            }
        }
    }

    public static void serialize(Object object, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream (
                new FileOutputStream(file))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            Object res = ois.readObject();
            return res;
        } catch (IOException e) {
            System.out.println("IO Exception");
        } catch (ClassNotFoundException e) {
            System.out.println("File not found");;
        }
        return null;
    }
}
