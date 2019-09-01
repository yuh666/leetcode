package cunzaichongfuyuansu3_220;

import java.util.TreeSet;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        return containsNearbyAlmostDuplicate(arr,k,t);
    }

    public boolean containsNearbyAlmostDuplicate(long[] nums, int k, long t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            Long ceiling = treeSet.ceiling(num - t);
            if(ceiling != null && ceiling <= num+t){
                return true;
            }
            treeSet.add(num);
            if (i - l == k) {
                treeSet.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}
