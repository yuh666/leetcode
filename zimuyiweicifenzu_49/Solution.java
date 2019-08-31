package zimuyiweicifenzu_49;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] bitMap = new int[26];
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            Arrays.fill(bitMap,0);
            for (int j = 0; j < str.length(); j++) {
                bitMap[str.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int b : bitMap) {
                sb.append(b).append("#");
            }
            String key = sb.toString();
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
                map.put(key,list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"zbc","cbz"};
        List<List<String>> lists = new Solution().groupAnagrams(strs);
    }

}
