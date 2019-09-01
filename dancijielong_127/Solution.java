package dancijielong_127;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    class WordNode {
        String word;
        int level;

        public WordNode(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> bitMap = new HashMap<>();
        LinkedList<WordNode> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            WordNode wordNode = queue.removeFirst();
            queue.addLast(new WordNode(beginWord, 1));
            for (String s : wordList) {
                Boolean orDefault = bitMap.getOrDefault(s, false);
                if (orDefault) {
                    continue;
                }
                if (!canTransfer(wordNode.word, s)) {
                    continue;
                }
                if (s.equals(endWord)) {
                    return wordNode.level + 1;
                }
                bitMap.put(s, true);
                queue.add(new WordNode(s, wordNode.level + 1));
            }
        }
        return 0;
    }

    public boolean canTransfer(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++count == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
