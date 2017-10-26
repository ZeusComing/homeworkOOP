import java.io.File;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Vladimir", "Belochkin", 20, "male", 4, "IT");
        Student student2 = new Student("Anna", "Petrova", 25, "female", 3, "Management");
        Student student3 = new Student("Yulia", "Tretiakova", 19, "female", 2, "Design");
        Student student4 = new Student("Ivan", "Vasilievich", 35, "male", 5, "Chemistry");
        Student student5 = new Student("Harry", "Potter", 14, "male", 1, "Magic");
        Student student6 = new Student("Konstantin", "Verbenko", 26, "male", 3, "Engineering");
        Student student7 = new Student("Vladislava", "Pavlenko", 21, "female", 2, "Mathematical analysis");
        Student student8 = new Student("Nikolay", "Biryuzenko", 23, "male", 5, "Marketing");
        Student student9 = new Student("Homer", "Simpson", 40, "male", 5, "Faculty of idleness");
        Student student10 = new Student("Eric", "Cartman", 10, "male", 1, "Culturology");
        Student student11 = new Student("Burry", "Borson", 18, "male", 3, "Architecture");
        File groups = new File("Groups");
        File testgroup = new File("Groups/testgroup.txt");
        Group luckyStudents = new Group();
        groups.mkdir();
        luckyStudents.addToGroup(student1);
        luckyStudents.addToGroup(student2);
        luckyStudents.addToGroup(student3);
        luckyStudents.addToGroup(student4);
        luckyStudents.addToGroup(student5);
        luckyStudents.addToGroup(student6);
        luckyStudents.addToGroup(student7);
        luckyStudents.addToGroup(student8);
        luckyStudents.addToGroup(student9);
        luckyStudents.addToGroup(student10);
        luckyStudents.addToGroup(student11);
//        System.out.println(luckyStudents.searchStudent("Cartman"));
//        System.out.println(luckyStudents.searchStudent("a2dasd"));
        luckyStudents.removeStudentFromGroup(student3);
        luckyStudents.removeStudentFromGroup(student8);
//        System.out.println(luckyStudents.toString());
//        System.out.println(Voenkomat.checkForRecruits(luckyStudents).toString());
//        luckyStudents.addToGroupInteractive();
//        System.out.println(luckyStudents.getGroup()[8].toString());
//        FileOperations.toFile(luckyStudents.getGroup(), "Groups/luckystudents.txt");
        Group newGroup = FileOperations.toGroup(testgroup);
        System.out.println(newGroup.toString());




    }
}
