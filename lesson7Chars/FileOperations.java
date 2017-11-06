import java.io.*;
import java.util.*;

public class FileOperations {

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

    public static void writeToList(String[] array, List characterList) {
        for (String word: array) {
            char[] temp = word.toCharArray();
            for (Character c: temp) {
                characterList.add(c);
            }
        }
    }

    public static HashMap<Character,Integer> countElement (List<Character> charList) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (Character element : charList) {
            Integer count = res.get(element);
            if (count == null) {
                res.put(element, 1);
            } else {
                res.put(element, count + 1);
            }
        }
        return res;
    }

    public static void sortByValue(HashMap<Character, Integer> map) {
        List entryList = new ArrayList(map.entrySet());
        Collections.sort(entryList, new Comparator() {
            public int compare(Object o1, Object o2) {
                Map.Entry e1 = (Map.Entry) o1;
                Map.Entry e2 = (Map.Entry) o2;
                Comparable c1 = (Comparable) e2.getValue();
                Comparable c2 = (Comparable) e1.getValue();
                return c1.compareTo(c2);
            }
        });
        System.out.print(entryList);

    }


    public static void showChars(File file) {
        List<Character> charlist = new ArrayList<>();
        String[] stringsFromFile = getStringArray(file);
        writeToList(stringsFromFile, charlist);
        HashMap<Character, Integer> charMap = countElement(charlist);
        sortByValue(charMap);

    }

}
