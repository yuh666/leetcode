package jianzhiyingshe_677;

import java.util.Map;
import java.util.TreeMap;

/**
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * <p>
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * <p>
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MapSum {

    private class Node {
        int val;
        TreeMap<Character, Node> map;
        char data;
        boolean isWord;

        Node() {
            map = new TreeMap<>();
        }

        public Node(char data) {
            this();
            this.data = data;
        }

    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            Node sub = cur.map.get(c);
            if (sub == null) {
                sub = new Node(c);
                cur.map.put(c, sub);
            }
            cur = sub;
        }
        cur.isWord = true;
        cur.val = val;
    }

    public int sum(String key) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            Node sub = cur.map.get(c);
            if (sub == null) {
                return 0;
            }
            cur = sub;
        }
        return sum(cur);
    }


    private int sum(Node node) {
        if(node == null){
            return 0;
        }
        int c = 0;
        if(node.isWord){
            c += node.val;
        }
        for (Map.Entry<Character, Node> entry : node.map.entrySet()) {
            c += sum(entry.getValue());
        }
        return c;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */