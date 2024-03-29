package zuijiejindesanshuzhihe_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target)  {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Integer nearest = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(nearest == null){
                    nearest = sum;
                }
                if (sum == target) {
                    return target;
                }else{
                    if(Math.abs(sum-target) < Math.abs(nearest-target)){
                        nearest = sum;
                    }
                    if (sum < target) {
                        while (l < r && nums[l] == nums[++l]);
                    } else {
                        while (l < r && nums[r] == nums[--r]);
                    }
                }

            }
        }
        return nearest;
    }

    public static void main(String[] args) {

    }
}
