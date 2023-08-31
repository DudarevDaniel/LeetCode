package fiverr.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCache {

    private Map<Integer, Node> nodesByValueMap;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.nodesByValueMap = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addNode(Node newnode) {
        Node currentTail = head.next;
        head.next = newnode;
        newnode.prev = head;
        newnode.next = currentTail;
        currentTail.prev = newnode;
    }

    public int get(int key) {
        Node node = nodesByValueMap.get(key);
        if (node == null) {
            return -1;
        }
        deleteNode(node);
        addNode(node);
        nodesByValueMap.put(key, node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = nodesByValueMap.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            if (nodesByValueMap.size() < size) {
                addNode(newNode);
            } else {
                Node preTail = tail.prev;
                deleteNode(preTail);
                addNode(newNode);
                nodesByValueMap.remove(preTail.key);
            }
            nodesByValueMap.put(key, newNode);
        } else {
            deleteNode(node);
            node.val = value;
            addNode(node);
            nodesByValueMap.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
    }
}
