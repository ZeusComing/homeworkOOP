import java.util.ArrayDeque;

public class Stack {
    private ArrayDeque<Object> stack;
    private Blacklist blacklist;

    public Stack(Blacklist blacklist) {
        this.stack = new ArrayDeque<>();
        this.blacklist = blacklist;
    }

    public void addObject(Object object) {
        if (object != null) {
            if (!blacklist.inBlackList(object.getClass())) {
                stack.addFirst(object);
                System.out.println("Object " + object +
                        " added to stack");
            }
        }
    }

    public Object geFirst() {
        return this.stack.getFirst();
    }

    public Object getAndRemove(Object object) {
        if (this.stack.offer(object)) {
            return this.stack.pop();
        }
        return null;
    }

    public void removeObject(Object object) {
        if (object != null && this.stack.contains(object)) {
            this.stack.remove(object);
        }
    }
}
