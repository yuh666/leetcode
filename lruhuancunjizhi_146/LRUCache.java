package lruhuancunjizhi_146;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 */
class LRUCache {
class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    private Node head = new Node();
    private Node tail = new Node();
    private Map<Integer, Node> map = new HashMap<>();
    private int size = 0;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        int val = node.val;
        moveToHead(node);
        return val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            moveToHead(node);
            return;
        }

        if(size == capacity){
            Node prev = tail.prev;
            removeNode(prev);
            map.remove(prev.key);
            size--;
        }
        Node newNode = new Node(key, value);
        map.put(key,newNode);
        addNode(newNode);
        size++;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */