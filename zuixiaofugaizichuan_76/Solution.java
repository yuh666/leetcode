package zuixiaofugaizichuan_76;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public String minWindow(String s, String t) {
        int start = 0;
        int end = s.length() + 1;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.merge(t.charAt(i), 1, (o, v) -> o + v);
        }
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = sMap.getOrDefault(c, 0);
            sMap.put(c, count + 1);
            while (cover(sMap, tMap)) {
                //长度判断
                if (end - start > i - l) {
                    end = i;
                    start = l;
                }
                char c1 = s.charAt(l);
                sMap.put(c1, sMap.get(c1) - 1);
                l++;
            }
        }
        return end == s.length() + 1 ? "" : s.substring(start, end + 1);
    }

    private boolean cover(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Integer val = sMap.get(entry.getKey());
            if (val == null || val < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new Solution().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

}
