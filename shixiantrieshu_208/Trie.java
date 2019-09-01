package shixiantrieshu_208;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {

    private class Node {
        boolean isWord;
        Node[] subNodes = new Node[26];
        char data;

        public Node(char data) {
            this.data = data;
        }
    }

    private Node root;


    public Trie() {
        root = new Node('\0');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node subNode = curr.subNodes[c - 'a'];
            if (subNode == null) {
                subNode = new Node(c);
                curr.subNodes[c - 'a'] = subNode;
            }
            if (i == word.length() - 1) {
                subNode.isWord = true;
            }
            curr = subNode;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node subNode = curr.subNodes[c - 'a'];
            if (subNode == null) {
                return false;
            }
            curr = subNode;
        }
        return curr.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node subNode = curr.subNodes[c - 'a'];
            if (subNode == null) {
                return false;
            }
            curr = subNode;
        }
        return true;
    }
}
