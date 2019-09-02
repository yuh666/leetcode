package genjvzichuxiandepinlvpaixv_451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String frequencySort(String s) {
        if (s.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int maxTimes = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer orDefault = map.getOrDefault(c, 0);
            int i1 = orDefault + 1;
            if (i1 > maxTimes) {
                maxTimes = i1;
            }
            map.put(c, i1);
        }
        ArrayList<Character>[] arrayLists = new ArrayList[maxTimes + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            ArrayList<Character> arrayList = arrayLists[value];
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                arrayLists[value] = arrayList;
            }
            arrayList.add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = arrayLists.length - 1; i >= 0; i--) {
            ArrayList<Character> count = arrayLists[i];
            if (count == null) {
                continue;
            }
            for (Character character : count) {
                for (int j = 0; j < i; j++) {
                    sb.append(character);
                }
            }
        }
        return sb.toString();
    }
}