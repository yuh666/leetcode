package quanpailie_46;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    Map<Integer,Boolean> bitMap = new HashMap<>();

    public List<List<Integer>> permute(int[] nums) {
        _permute(nums, new ArrayList<>());
        return lists;
    }

    private void _permute(int[] nums, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (!bitMap.getOrDefault(num,false)) {
                bitMap.put(num,true);
                list.add(num);
                _permute(nums, list);
                list.remove(list.size() - 1);
                bitMap.put(num,false);
            }
        }
    }
}
