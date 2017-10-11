public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Vladimir", "Belochkin", 20, 4, "IT");
        Student student2 = new Student("Anna", "Petrova", 25, 3, "Management");
        Student student3 = new Student("Yulia", "Tretiakova", 19, 2, "Design");
        Student student4 = new Student("Ivan", "Vasilievich", 35, 5, "Chemistry");
        Student student5 = new Student("Harry", "Potter", 14, 1, "Magic");
        Student student6 = new Student("Konstantin", "Verbenko", 26, 3, "Engineering");
        Student student7 = new Student("Vladislava", "Pavlenko", 21, 2, "Mathematical analysis");
        Student student8 = new Student("Nikolay", "Biryuzenko", 23, 5, "Marketing");
        Student student9 = new Student("Homer", "Simpson", 40, 5, "Faculty of idleness");
        Student student10 = new Student("Eric", "Cartman", 10, 1, "Culturology");
        Student student11 = new Student("Burry", "Borson", 21, 3, "Architecture");
        Group luckyStudents = new Group();
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
        luckyStudents.searchStudent("Verbenko");
        luckyStudents.removeStudentFromGroup(student3);
        luckyStudents.removeStudentFromGroup(student8);
        System.out.println(luckyStudents.toString());
    }
}
