import java.util.ArrayDeque;

public class Blacklist {
    private ArrayDeque<Object> classes;

    public Blacklist() {
        classes = new ArrayDeque<>();
    }

    public void addClass(Object object) {
        if (object != null) {
            if (!inBlackList(object)) {
                classes.addFirst(object.getClass());
                System.out.println("Class " + object.getClass().getName() +
                        " added to blacklist");
            } else {
                System.out.println("Class " + object.getClass().getName() +
                        " already in this blacklist");
            }
        }

    }

    public boolean inBlackList (Object object) {
        if (classes.contains(object.getClass())) {
            return true;
        }
        return false;
    }
}
