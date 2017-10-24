import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File dir1 = new File("My folder");
        File dir2 = new File("Second Folder");
        File myFile = new File("My folder\\abc.txt");
        File fileOne = new File("My folder\\my file.txt");
        File fileTwo = new File("My folder\\test.doc");
        MyFileFilter mFF = new MyFileFilter("txt");
        File[] fileList = dir1.listFiles(mFF);
        try {
            dir1.mkdir();
            dir2.mkdir();
            myFile.createNewFile();
            fileOne.createNewFile();
            fileTwo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOperations.writeToFile("Hello java abc", myFile);
        FileOperations.copyFile(myFile, fileOne);
        FileOperations.copyToDir(fileList, dir2);
        FileOperations.writeToFile("Surprise java", myFile);
        FileOperations.getSameWords(myFile, fileOne);
    }
}
