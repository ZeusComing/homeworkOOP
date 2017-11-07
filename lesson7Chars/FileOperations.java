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
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (mapEntry1, mapEntry2) -> {
            return mapEntry2.getValue().compareTo(mapEntry1.getValue());
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
