package tianjiayusousuodanci_211;

import shixiantrieshu_208.Trie;

/**
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDictionary {

    private class Node {
        boolean isWord;
        Node[] subNodes = new Node[26];
        char data;

        public Node(char data) {
            this.data = data;
        }
    }

    private Node root;


    public WordDictionary() {
        root = new Node('\0');
    }

    /**
     * Inserts a word into the
     */
    public void addWord(String word) {
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

    public boolean search(String word) {
        return match(word, root, 0);
    }

    private boolean match(String word, Node root, int index) {
        if (index == word.length()) {
            return root.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            Node[] subNodes = root.subNodes;
            for (Node subNode : subNodes) {
                if(subNode != null && match(word,subNode,index+1)){
                    return true;
                }
            }
        } else {
            Node subNode = root.subNodes[c - 'a'];
            if (subNode == null) {
                return false;
            }
            return match(word, subNode, index + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        boolean bad = obj.search("bad");
        System.out.println(bad);
    }
}
