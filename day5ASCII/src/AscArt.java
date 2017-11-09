import java.io.File;
import java.util.*;

public class AscArt {
    private static char[] letters;
    private File lettersIn;

    public AscArt(File letters) {
        this.lettersIn = letters;
        this.letters = new char[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a',
                's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',};
    }

    public File getLettersIn() {
        return lettersIn;
    }

    public void setLettersIn(File lettersIn) {
        this.lettersIn = lettersIn;
    }

    public static char[] getLetters() {
        return letters;
    }

    private Map<Character, String[]> getMap() {
        Map<Character,String[]> map = new HashMap<>();
        String[][] lettersArray = FileOperation.readFile(this.lettersIn);
        for (int i = 0; i < getLetters().length; i++) {
            map.put(getLetters()[i], lettersArray[i]);
        }
        return map;
    }

    private Map<Character, String[]> getMMap(File file) {
        Map<Character,String[]> map = new HashMap<>();
        String[][] lettersArray = FileOperation.readFile(file);
        for (int i = 0; i < getLetters().length; i++) {
            map.put(getLetters()[i], lettersArray[i]);
        }
        return map;
    }




    public void printMessage (String message) {
        Map<Character, String[]> map = getMap();
        String[] tempArray = new String[6];
        Arrays.fill(tempArray, " ");
        char[] characters = message.toLowerCase().toCharArray();
        for (int i = 0; i < tempArray.length ; i++) {
            for (int j = 0; j < characters.length ; j++) {
                if (map.get(characters[j]) == null) {
                    tempArray[i] += "       ";
                } else {
                    tempArray[i] += map.get(characters[j])[i];
                }
            }
        }
        for (String s: tempArray) {
            System.out.println(s);
        }
    }
}
