package wuchongfuzifudezuichangzichuan_3;

import java.util.Arrays;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int[] bitmap = new int[256];
        Arrays.fill(bitmap, -1);
        int maxLength = -1;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int exist = bitmap[c];
            if (exist == -1) {
                maxLength = Math.max(maxLength, i - l + 1);
                bitmap[c] = i;
            } else {
                for (int j = l; j <= exist; j++) {
                    bitmap[s.charAt(j)] = -1;
                }
                l = exist + 1;
                bitmap[c] = i;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int bbbbb = new Solution().lengthOfLongestSubstring("dvdf");
        System.out.println(bbbbb);
    }
}
