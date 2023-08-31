package fiverr.lrucache;

public class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}
