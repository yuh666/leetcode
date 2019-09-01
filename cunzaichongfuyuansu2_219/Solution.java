package cunzaichongfuyuansu2_219;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> set = new HashMap<>();
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer val = set.get(num);
            if (val != null && val > 0) {
                return true;
            }
            set.merge(num, 1, (o, v) -> o + v);
            if (i - l == k) {
                set.put(nums[l], set.get(nums[l])-1);
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1,2,3}, 2);
        System.out.println(b);
    }
}
