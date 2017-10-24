import java.io.*;

public class FileOperations {

    public static void copyFile(File fileIn, File fileOut) {
        if (fileIn == null || fileOut == null) {
            throw new IllegalArgumentException("It's null :(");
        }
        try (InputStream is = new FileInputStream(fileIn);
             OutputStream os = new FileOutputStream(fileOut)) {
            byte[] buffer = new byte[1024*1024];
            int byteCopy = 0;
            for (;(byteCopy = is.read(buffer)) > 0 ;) {
                os.write(buffer, 0, byteCopy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String text, File file) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyToDir(File[] files, File dir) {
        for (File file : files) {
            int slashIndex = file.getName().lastIndexOf("\\");
            String fileName = file.getName().substring(slashIndex + 1);
            try {
                File newFile = new File(dir + "\\" + fileName);
                newFile.createNewFile();
                copyFile(file, newFile);
                System.out.println("\"" + fileName + "\" is copied to " + dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] getStringArray(File file) {
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String resultString = "";
                for (String text = ""; (text = br.readLine()) != null; ) {
                    resultString += text;
                }
                String[] result = resultString.split("[- ,;:.!?\\s]+");
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static File getSameWords(File fileOne, File fileTwo) {
        String[] words1 = getStringArray(fileOne);
        String[] words2 = getStringArray(fileTwo);
        File resDir = new File("Results");
        File resultFile = new File("Results/res.txt");
        String result = "";
        try {
            resDir.mkdir();
            resultFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < words1.length ; i++) {
            for (int j = 0; j <words2.length ; j++) {
                if (words1[i].equals(words2[j])) {
                    result += words1[i];
                }
            }
        }
        writeToFile(result, resultFile);
        return resultFile;
    }
}
