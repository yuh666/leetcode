package zhaodaozifuchuanzhongsuoyoudezimuyiweici_438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.merge(p.charAt(i), 1, (o, v) -> o + v);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sMap.merge(c, 1, (o, v) -> o + v);
            if (i - l + 1 == p.length()) {
                if (sMap.equals(pMap)) {
                    list.add(l);
                }
                char c1 = s.charAt(l);
                Integer val = sMap.get(c1);
                if(val == 1){
                    sMap.remove(c1);
                }else {
                    sMap.put(c1,val-1);
                }
                l++;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = new Solution().findAnagrams(s, p);
        System.out.println(anagrams);
    }


}
