package _8_高频题;

import java.util.HashMap;

public class _146_LRU缓存机制 {



    HashMap<Integer, Node> map;
    Node first;
    Node last;
    int capacity;

    public _146_LRU缓存机制(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            removeNode(node);
            addAfterFirst(node);
            return node.value;
        }
    }

    private void addAfterFirst(Node node) {
        Node next = first.next;
        first.next = node;
        next.prev = node;

        node.prev = first;
        node.next = next;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
        } else {
            if (map.size() == capacity) {
                removeNode(map.remove(last.prev.key));
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        addAfterFirst(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }


    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
